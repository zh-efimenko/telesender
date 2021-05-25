package me.eefimenko.telesender.filter

import me.eefimenko.telesender.annotation.TelegramFilterOrder
import me.eefimenko.telesender.component.TelegramApi
import me.eefimenko.telesender.config.property.TelegramEngineProperties
import me.eefimenko.telesender.handler.PollAnswerHandler
import me.eefimenko.telesender.model.telegram.recieve.Update
import me.eefimenko.telesender.model.telegram.send.TextSendMessage
import mu.KotlinLogging
import java.util.*

/**
 * @author Yauheni Yefimenka
 */
@TelegramFilterOrder(400)
class PollAnswerFilter(
	private val telegramApi: TelegramApi,
	private val handlers: List<PollAnswerHandler>,
	private val properties: TelegramEngineProperties
) : TelegramFilter {

	private val log = KotlinLogging.logger {}

	override fun handleMessage(update: Update, chain: TelegramFilterChain) {
		if (Objects.isNull(update.pollAnswer)) {
			chain.doHandle(update)
			return
		}

		val pollAnswer = update.pollAnswer!!

		for (handler in handlers) {
			try {
				handler.getProcess()(pollAnswer)
			} catch (e: Exception) {
				val errorMessage = """
					filter: pollAnswer,
					poll_id: ${pollAnswer.pollId}, 
					user_id: ${pollAnswer.user.id}, 
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
