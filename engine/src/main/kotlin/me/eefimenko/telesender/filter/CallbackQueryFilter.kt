package me.eefimenko.telesender.filter

import me.eefimenko.telesender.annotation.TelegramFilterOrder
import me.eefimenko.telesender.component.TelegramApi
import me.eefimenko.telesender.config.property.TelegramEngineProperties
import me.eefimenko.telesender.handler.CallbackQueryHandler
import me.eefimenko.telesender.model.telegram.recieve.Update
import me.eefimenko.telesender.model.telegram.send.TextSendMessage
import mu.KotlinLogging
import java.util.*

/**
 * @author Yauheni Yefimenka
 */
@TelegramFilterOrder(200)
class CallbackQueryFilter(
	private val telegramApi: TelegramApi,
	private val handlers: List<CallbackQueryHandler>,
	private val properties: TelegramEngineProperties
) : TelegramFilter {

	private val log = KotlinLogging.logger {}

	override fun handleMessage(update: Update, chain: TelegramFilterChain) {
		if (Objects.isNull(update.callbackQuery)) {
			chain.doHandle(update)
			return
		}

		val callbackQuery = update.callbackQuery!!

		for (handler in handlers) {
			try {
				handler.getProcess()(callbackQuery)
			} catch (e: Exception) {
				val errorMessage = """
					filter: callbackQuery,
					callback_id: ${callbackQuery.id},
					user_id: ${callbackQuery.from.id},
					data: ${callbackQuery.data},
					message: ${e.message ?: "Error during handler processing"}
				""".trimIndent()

				log.error(errorMessage, e)

				if (properties.admin.enabled) {
					val response = TextSendMessage(chatId = properties.admin.chatId, text = errorMessage)
					telegramApi.send(response)
				}
			}
		}
	}

}
