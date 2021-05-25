package me.eefimenko.telesender.filter

import me.eefimenko.telesender.annotation.TelegramFilterOrder
import me.eefimenko.telesender.filter.util.FilterExceptionUtil
import me.eefimenko.telesender.handler.CallbackQueryHandler
import me.eefimenko.telesender.model.telegram.recieve.Update
import java.util.*

/**
 * @author Yauheni Yefimenka
 */
@TelegramFilterOrder(200)
class CallbackQueryFilter(
	private val handlers: List<CallbackQueryHandler>,
	private val exceptionUtil: FilterExceptionUtil
) : TelegramFilter {

	override fun handleMessage(update: Update, chain: TelegramFilterChain) {
		if (Objects.isNull(update.callbackQuery)) {
			chain.doHandle(update)
			return
		}

		val callbackQuery = update.callbackQuery!!

		for (handler in handlers) {
			try {
				handler.getProcess()(callbackQuery)
			} catch (ex: Exception) {
				exceptionUtil.handleException(callbackQuery, ex)
			}
		}
	}

}
