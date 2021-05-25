package me.eefimenko.telesender.filter

import me.eefimenko.telesender.annotation.TelegramFilterOrder
import me.eefimenko.telesender.component.TelegramApi
import me.eefimenko.telesender.config.property.TelegramEngineProperties
import me.eefimenko.telesender.handler.PollHandler
import me.eefimenko.telesender.model.telegram.recieve.Update
import me.eefimenko.telesender.model.telegram.send.TextSendMessage
import mu.KotlinLogging
import java.util.*

/**
 * @author Yauheni Yefimenka
 */
@TelegramFilterOrder(300)
class PollFilter(
	private val telegramApi: TelegramApi,
	private val handlers: List<PollHandler>,
	private val properties: TelegramEngineProperties
) : TelegramFilter {

	private val log = KotlinLogging.logger {}

	override fun handleMessage(update: Update, chain: TelegramFilterChain) {
		if (Objects.isNull(update.poll)) {
			chain.doHandle(update)
			return
		}

		val poll = update.poll!!

		for (handler in handlers) {
			try {
				handler.getProcess()(poll)
			} catch (e: Exception) {
				val errorMessage = """
					filter: poll,
					poll_id: ${poll.id}, 
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
