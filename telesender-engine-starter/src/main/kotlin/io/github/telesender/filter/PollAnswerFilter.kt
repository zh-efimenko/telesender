package io.github.telesender.filter

import io.github.telesender.component.TelegramApi
import io.github.telesender.filter.annotation.TelegramFilterOrder
import io.github.telesender.filter.util.FilterExceptionUtil
import io.github.telesender.handler.PollAnswerHandler
import io.github.telesender.model.telegram.recieve.Update
import java.util.*

/**
 * @author Yauheni Yefimenka
 */
@TelegramFilterOrder(400)
class PollAnswerFilter(
	private val telegramApi: TelegramApi,
	private val handlers: List<PollAnswerHandler>,
	private val exceptionUtil: FilterExceptionUtil
) : TelegramFilter {

	override fun getCommands(): Map<String, String> = mapOf()

	override fun handleMessage(update: Update, chain: TelegramFilterChain) {
		if (Objects.isNull(update.pollAnswer)) {
			chain.doHandle(update)
			return
		}

		val pollAnswer = update.pollAnswer!!

		for (handler in handlers) {
			try {
				val response = handler.getProcess()(pollAnswer)
				telegramApi.send(response)
			} catch (ex: Exception) {
				exceptionUtil.handleException(pollAnswer, ex)
			}
		}
	}

}
