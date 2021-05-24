package me.eefimenko.telesender.filter

import me.eefimenko.telesender.annotation.TelegramFilterOrder
import me.eefimenko.telesender.component.TelegramApi
import me.eefimenko.telesender.model.telegram.recieve.Chat
import me.eefimenko.telesender.model.telegram.recieve.Update
import me.eefimenko.telesender.model.telegram.send.TextSendMessage
import java.util.*

/**
 * @author Yauheni Yefimenka
 */
@TelegramFilterOrder(0)
class CancelFilter(
	private val telegramApi: TelegramApi,
	private val filters: List<TelegramFilter>
) : TelegramFilter {

	override fun handleMessage(update: Update, chain: TelegramFilterChain) {
		if (Objects.isNull(update.message)) {
			chain.doFilter(update)
			return
		}

		val message = update.message!!
		val text = message.text?.toLowerCase() ?: ""
		if (listOf("/cancel", "/отмена").any { text.startsWith(it) }) {
			this.clearState(message.chat)

			val response = TextSendMessage(chatId = message.chat.id, text = "Okay, let's start over.")
			telegramApi.sendMessage(response)
		} else {
			chain.doFilter(update)
		}
	}

	override fun clearState(chat: Chat) {
		filters.forEach { it.clearState(chat) }
	}

}
