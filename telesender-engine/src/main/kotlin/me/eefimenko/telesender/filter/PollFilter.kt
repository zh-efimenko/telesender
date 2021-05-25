package me.eefimenko.telesender.filter

import me.eefimenko.telesender.annotation.TelegramFilterOrder
import me.eefimenko.telesender.filter.util.FilterExceptionUtil
import me.eefimenko.telesender.handler.PollHandler
import me.eefimenko.telesender.model.telegram.recieve.Update
import java.util.*

/**
 * @author Yauheni Yefimenka
 */
@TelegramFilterOrder(300)
class PollFilter(
	private val handlers: List<PollHandler>,
	private val exceptionUtil: FilterExceptionUtil
) : TelegramFilter {

	override fun handleMessage(update: Update, chain: TelegramFilterChain) {
		if (Objects.isNull(update.poll)) {
			chain.doHandle(update)
			return
		}

		val poll = update.poll!!

		for (handler in handlers) {
			try {
				handler.getProcess()(poll)
			} catch (ex: Exception) {
				exceptionUtil.handleException(poll, ex)
			}
		}
	}

}
