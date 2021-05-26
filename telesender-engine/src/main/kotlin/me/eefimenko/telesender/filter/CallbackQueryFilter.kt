package me.eefimenko.telesender.filter

import me.eefimenko.telesender.annotation.TelegramFilterOrder
import me.eefimenko.telesender.component.TelegramApi
import me.eefimenko.telesender.filter.util.FilterExceptionUtil
import me.eefimenko.telesender.handler.CallbackQueryHandler
import me.eefimenko.telesender.model.telegram.recieve.Update
import me.eefimenko.telesender.model.telegram.recieve.inline.CallbackQuery
import java.util.*

/**
 * @author Yauheni Yefimenka
 */
@TelegramFilterOrder(200)
class CallbackQueryFilter(
	private val telegramApi: TelegramApi,
	private val handlers: List<CallbackQueryHandler>,
	private val exceptionUtil: FilterExceptionUtil
) : TelegramFilter {

	override fun getCommands(): Map<String, String> = mapOf()

	override fun handleMessage(update: Update, chain: TelegramFilterChain) {
		if (Objects.isNull(update.callbackQuery)) {
			chain.doHandle(update)
			return
		}

		val callbackQuery = update.callbackQuery!!

		val handler = this.findHandler(callbackQuery)
		if (handler == null) {
			chain.doHandle(update)
			return
		}

		try {
			val response = handler.getProcess()(callbackQuery)
			telegramApi.send(response)
		} catch (ex: Exception) {
			exceptionUtil.handleException(callbackQuery, ex)
		}
	}

	private fun findHandler(callbackQuery: CallbackQuery): CallbackQueryHandler? {
		val text = callbackQuery.data?.toLowerCase() ?: return null
		for (handler in handlers) {
			if (handler.getCommands().keys.any { text.startsWith(it) }) {
				return handler
			}
		}
		return null
	}

}
