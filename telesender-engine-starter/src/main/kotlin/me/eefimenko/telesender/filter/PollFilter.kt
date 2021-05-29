package me.eefimenko.telesender.filter

import me.eefimenko.telesender.component.TelegramApi
import me.eefimenko.telesender.filter.annotation.TelegramFilterOrder
import me.eefimenko.telesender.filter.util.FilterExceptionUtil
import me.eefimenko.telesender.handler.PollHandler
import me.eefimenko.telesender.model.telegram.recieve.Update
import java.util.*

/**
 * @author Yauheni Yefimenka
 */
@TelegramFilterOrder(300)
class PollFilter(
	private val telegramApi: TelegramApi,
	private val handlers: List<PollHandler>,
	private val exceptionUtil: FilterExceptionUtil
) : TelegramFilter {

	override fun getCommands(): Map<String, String> = mapOf()

	override fun handleMessage(update: Update, chain: TelegramFilterChain) {
		if (Objects.isNull(update.poll)) {
			chain.doHandle(update)
			return
		}

		val poll = update.poll!!

		for (handler in handlers) {
			try {
				val response = handler.getProcess()(poll)
				telegramApi.send(response)
			} catch (ex: Exception) {
				exceptionUtil.handleException(poll, ex)
			}
		}
	}

}
