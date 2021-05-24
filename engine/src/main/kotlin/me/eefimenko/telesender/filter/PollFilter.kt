package me.eefimenko.telesender.filter

import me.eefimenko.telesender.annotation.TelegramFilterOrder
import me.eefimenko.telesender.component.TelegramApi
import me.eefimenko.telesender.model.telegram.recieve.Chat
import me.eefimenko.telesender.model.telegram.recieve.Update
import java.util.*

/**
 * @author Yauheni Yefimenka
 */
@TelegramFilterOrder(300)
class PollFilter(
	private val telegramApi: TelegramApi
) : TelegramFilter {

	override fun handleMessage(update: Update, chain: TelegramFilterChain) {
		if (Objects.isNull(update.poll)) {
			chain.doFilter(update)
			return
		}

		val poll = update.poll!!
	}

	override fun clearState(chat: Chat) {
//		TODO("Not yet implemented")
	}

}
