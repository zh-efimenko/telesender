package me.eefimenko.telesender.filter.util

import me.eefimenko.telesender.component.TelegramApi
import me.eefimenko.telesender.config.property.TelegramEngineProperties
import me.eefimenko.telesender.model.telegram.recieve.Message
import me.eefimenko.telesender.model.telegram.recieve.Poll
import me.eefimenko.telesender.model.telegram.recieve.PollAnswer
import me.eefimenko.telesender.model.telegram.recieve.inline.CallbackQuery
import me.eefimenko.telesender.model.telegram.send.TextSendMessage
import mu.KotlinLogging

/**
 * @author Yauheni Yefimenka
 */
class FilterExceptionUtil(
	private val telegramApi: TelegramApi,
	private val properties: TelegramEngineProperties
) {

	private val log = KotlinLogging.logger {}

	fun handleException(obj: Any, ex: Exception) {
		var errorMessage = ex.message ?: "Error during handler processing"

		when (obj) {
			is Message -> {
				errorMessage = """
					filter: message,
					chat_id: ${obj.chat.id}, 
					user_id: ${obj.from?.id},
					message: $errorMessage
				""".trimIndent()
			}
			is CallbackQuery -> {
				errorMessage = """
					filter: callbackQuery,
					callback_id: ${obj.id},
					user_id: ${obj.from.id},
					data: ${obj.data},
					message: $errorMessage
				""".trimIndent()
			}
			is Poll -> {
				errorMessage = """
					filter: poll,
					poll_id: ${obj.id}, 
					message: $errorMessage
				""".trimIndent()
			}
			is PollAnswer -> {
				errorMessage = """
					filter: pollAnswer,
					poll_id: ${obj.pollId}, 
					user_id: ${obj.user.id}, 
					message: $errorMessage
				""".trimIndent()
			}
		}

		log.error(errorMessage, ex)

		if (properties.admin.enabled) {
			val response = TextSendMessage(chatId = properties.admin.chatId, text = errorMessage)
			telegramApi.send(response)
		}
	}

}
