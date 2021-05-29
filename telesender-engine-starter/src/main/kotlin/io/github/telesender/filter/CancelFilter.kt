package io.github.telesender.filter

import io.github.telesender.component.TelegramApi
import io.github.telesender.config.property.TelegramEngineProperties
import io.github.telesender.filter.annotation.TelegramFilterOrder
import io.github.telesender.model.telegram.recieve.Update
import io.github.telesender.model.telegram.send.TextSendMessage
import java.util.*

/**
 * @author Yauheni Yefimenka
 */
@TelegramFilterOrder(0)
class CancelFilter(
	private val telegramApi: TelegramApi,
	private val properties: TelegramEngineProperties,
) : TelegramFilter {

	override fun getCommands(): Map<String, String> = properties.cancelFilter.getCommands()

	override fun handleMessage(update: Update, chain: TelegramFilterChain) {
		if (Objects.isNull(update.message)) {
			chain.doHandle(update)
			return
		}

		val message = update.message!!
		val text = message.text?.lowercase() ?: ""
		if (this.getCommands().keys.any { text.startsWith(it) }) {
			chain.doClear(update)

			val response = TextSendMessage(chatId = message.chat.id, text = "Okay, let's start over.")
			telegramApi.sendMessage(response)
		} else {
			chain.doHandle(update)
		}
	}

}
