package me.eefimenko.telesender.filter

import me.eefimenko.telesender.annotation.TelegramFilterOrder
import me.eefimenko.telesender.component.TelegramApi
import me.eefimenko.telesender.model.telegram.recieve.Chat
import me.eefimenko.telesender.model.telegram.recieve.Update
import java.util.*

/**
 * @author Yauheni Yefimenka
 */
@TelegramFilterOrder(400)
class PollAnswerFilter(
	private val telegramApi: TelegramApi
) : TelegramFilter {

	override fun handleMessage(update: Update, chain: TelegramFilterChain) {
		if (Objects.isNull(update.pollAnswer)) {
			chain.doFilter(update)
			return
		}

		val pollAnswer = update.pollAnswer!!
	}

	override fun clearState(chat: Chat) {
//		TODO("Not yet implemented")
	}

}
