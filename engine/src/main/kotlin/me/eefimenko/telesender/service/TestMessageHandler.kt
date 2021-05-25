package me.eefimenko.telesender.service

import me.eefimenko.telesender.handler.MessageHandler
import me.eefimenko.telesender.handler.MessageProcessBlock
import me.eefimenko.telesender.handler.MessageQuestionBlock
import me.eefimenko.telesender.handler.MessageValidationBlock
import me.eefimenko.telesender.handler.message.MessageHandlerStep
import me.eefimenko.telesender.model.telegram.send.TextSendMessage
import me.eefimenko.telesender.model.telegram.send.keyboard.InlineKeyboardButton
import me.eefimenko.telesender.model.telegram.send.keyboard.InlineKeyboardMarkup
import org.springframework.stereotype.Component

/**
 * @author Yauheni Yefimenka
 */
@Component
class TestMessageHandler : MessageHandler {

	override fun getCommands(): Map<String, String> = mapOf("/test" to "my test")

	override fun getSteps(): Map<String, MessageHandlerStep<*>> = listOf(
		object : MessageHandlerStep<String> {
			override fun getKey(): String = "one"

			override fun getQuestion(): MessageQuestionBlock = {
				TextSendMessage(
					it.chat.id,
					text = "Ты уверен?",
					replyMarkup = InlineKeyboardMarkup(
						answers = listOf(
							InlineKeyboardButton("да", callback_data = "да"),
							InlineKeyboardButton("нет", callback_data = "нет")
						)
					)
				)
			}

			override fun getValidation(): MessageValidationBlock<String> = {
				when (it.text) {
					"y" -> "Cool"
					"n" -> "Bad"
					else -> throw IllegalArgumentException("EX ONE")
				}
			}

			override fun getNextStepKey(): String = "two"

		},
		object : MessageHandlerStep<String> {
			override fun getKey(): String = "two"

			override fun getQuestion(): MessageQuestionBlock = {
				TextSendMessage(it.chat.id, text = "Точно?")
			}

			override fun getValidation(): MessageValidationBlock<String> = {
				when (it.text) {
					"y" -> "EXCELLENT"
					"n" -> "Very BAD"
					else -> throw IllegalArgumentException("EX TWO")
				}
			}

			override fun getNextStepKey(): String? = null

		}
	).associateBy { it.getKey() }

	override fun getInitialStepKey(): String = "one"

	override fun getProcess(): MessageProcessBlock = { chat, answers ->
		TextSendMessage(chat.id, text = answers.values.toString())
	}

}
