package me.eefimenko.telesender.filter

import me.eefimenko.telesender.annotation.TelegramFilterOrder
import me.eefimenko.telesender.component.TelegramApi
import me.eefimenko.telesender.config.property.TelegramEngineProperties
import me.eefimenko.telesender.config.property.TelegramEngineProperties.Companion.CANCEL_FILTER
import me.eefimenko.telesender.model.telegram.recieve.Update
import me.eefimenko.telesender.model.telegram.send.TextSendMessage
import java.util.*

/**
 * @author Yauheni Yefimenka
 */
@TelegramFilterOrder(0)
class CancelFilter(
	private val telegramApi: TelegramApi,
	private val properties: TelegramEngineProperties,
) : TelegramFilter {

	override fun handleMessage(update: Update, chain: TelegramFilterChain) {
		if (Objects.isNull(update.message)) {
			chain.doHandle(update)
			return
		}

		val message = update.message!!
		val text = message.text?.toLowerCase() ?: ""
		if (properties.getFilterCommands(CANCEL_FILTER).keys.any { text.startsWith(it) }) {
			chain.doClear(update)

			val response = TextSendMessage(chatId = message.chat.id, text = "Okay, let's start over.")
			telegramApi.sendMessage(response)
		} else {
			chain.doHandle(update)
		}
	}

}
