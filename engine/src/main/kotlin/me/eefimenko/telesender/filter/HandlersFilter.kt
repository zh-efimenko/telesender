package me.eefimenko.telesender.filter

import me.eefimenko.telesender.annotation.TelegramFilterOrder
import me.eefimenko.telesender.model.telegram.recieve.Chat
import me.eefimenko.telesender.model.telegram.recieve.Update

/**
 * @author Yauheni Yefimenka
 */
@TelegramFilterOrder(1)
class HandlersFilter : TelegramFilter {

	override fun handleMessage(update: Update, chain: TelegramFilterChain) {
		TODO("Not yet implemented")
	}

	fun clearState(chat: Chat) {
//		states.remove(chat.id)
	}

}
