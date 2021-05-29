package io.github.telesender.filter

import io.github.telesender.component.TelegramApi
import io.github.telesender.filter.annotation.TelegramFilterOrder
import io.github.telesender.model.telegram.recieve.Update
import io.github.telesender.model.telegram.send.TextSendMessage
import java.util.*

/**
 * @author Yauheni Yefimenka
 */
@TelegramFilterOrder(Integer.MAX_VALUE)
class UnresolvedMessageFilter(
	private val telegramApi: TelegramApi
) : TelegramFilter {

	override fun getCommands(): Map<String, String> = mapOf()

	override fun handleMessage(update: Update, chain: TelegramFilterChain) {
		if (Objects.isNull(update.message)) {
			return
		}

		val message = update.message!!
		if ("PRIVATE".equals(message.chat.type, true)) {
			val response = TextSendMessage(
				chatId = message.chat.id,
				text = "Sorry, I don't understand you, try again."
			)
			telegramApi.sendMessage(response)
		}
	}

}
