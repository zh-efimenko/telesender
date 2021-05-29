package io.github.telesender.filter

import io.github.telesender.component.TelegramApi
import io.github.telesender.filter.annotation.TelegramFilterOrder
import io.github.telesender.filter.util.FilterExceptionUtil
import io.github.telesender.handler.CallbackQueryHandler
import io.github.telesender.model.telegram.recieve.Update
import io.github.telesender.model.telegram.recieve.inline.CallbackQuery
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
		val text = callbackQuery.data?.lowercase() ?: return null
		for (handler in handlers) {
			if (handler.getCommands().keys.any { text.startsWith(it) }) {
				return handler
			}
		}
		return null
	}

}
