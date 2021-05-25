package me.eefimenko.telesender.filter

import me.eefimenko.telesender.annotation.TelegramFilterOrder
import me.eefimenko.telesender.filter.util.FilterExceptionUtil
import me.eefimenko.telesender.handler.PollAnswerHandler
import me.eefimenko.telesender.model.telegram.recieve.Update
import java.util.*

/**
 * @author Yauheni Yefimenka
 */
@TelegramFilterOrder(400)
class PollAnswerFilter(
	private val handlers: List<PollAnswerHandler>,
	private val exceptionUtil: FilterExceptionUtil
) : TelegramFilter {

	override fun handleMessage(update: Update, chain: TelegramFilterChain) {
		if (Objects.isNull(update.pollAnswer)) {
			chain.doHandle(update)
			return
		}

		val pollAnswer = update.pollAnswer!!

		for (handler in handlers) {
			try {
				handler.getProcess()(pollAnswer)
			} catch (ex: Exception) {
				exceptionUtil.handleException(pollAnswer, ex)
			}
		}
	}

}
