package io.github.telesender.filter

import io.github.telesender.component.TelegramApi
import io.github.telesender.filter.annotation.TelegramFilterOrder
import io.github.telesender.filter.util.FilterExceptionUtil
import io.github.telesender.handler.PollHandler
import io.github.telesender.model.telegram.recieve.Update
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
