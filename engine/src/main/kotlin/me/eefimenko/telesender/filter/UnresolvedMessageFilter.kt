package me.eefimenko.telesender.filter

import me.eefimenko.telesender.annotation.TelegramFilterOrder
import me.eefimenko.telesender.component.TelegramApi
import me.eefimenko.telesender.model.telegram.recieve.Update
import me.eefimenko.telesender.model.telegram.send.TextMessage
import java.util.*

/**
 * @author Yauheni Yefimenka
 */
@TelegramFilterOrder(Integer.MAX_VALUE)
class UnresolvedMessageFilter(private val telegramApi: TelegramApi) : TelegramFilter {

	override fun handleMessage(update: Update, chain: TelegramFilterChain) {
		if (Objects.isNull(update.message)) {
			return
		}

		val message = update.message!!
		if ("PRIVATE".equals(message.chat.type, true)) {
			val response = TextMessage(
				chatId = message.chat.id,
				text = "Sorry, I don't understand you, try again."
			)
			telegramApi.sendMessage(response)
		}
	}

}
