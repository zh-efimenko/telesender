package io.github.telesender.filter.util.impl

import io.github.telesender.component.TelegramApi
import io.github.telesender.config.property.TelegramEngineProperties
import io.github.telesender.filter.util.FilterExceptionUtil
import io.github.telesender.model.telegram.recieve.Message
import io.github.telesender.model.telegram.recieve.Poll
import io.github.telesender.model.telegram.recieve.PollAnswer
import io.github.telesender.model.telegram.recieve.inline.CallbackQuery
import io.github.telesender.model.telegram.send.TextSendMessage
import mu.KotlinLogging

/**
 * @author Yauheni Yefimenka
 */
class DefaultFilterExceptionUtil(
	private val telegramApi: TelegramApi,
	private val properties: TelegramEngineProperties
) : FilterExceptionUtil {

	private val log = KotlinLogging.logger {}

	override fun handleException(obj: Any, ex: Exception) {
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
