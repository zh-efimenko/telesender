package me.eefimenko.telesender.service

import me.eefimenko.telesender.handler.message.*
import me.eefimenko.telesender.model.telegram.send.TextSendMessage
import me.eefimenko.telesender.model.telegram.send.keyboard.InlineKeyboardButton
import me.eefimenko.telesender.model.telegram.send.keyboard.InlineKeyboardMarkup
import org.springframework.stereotype.Component

/**
 * @author Yauheni Yefimenka
 */
@Component
class TestMessageHandler : MessageHandler {

	override fun getCommands(): List<String> = listOf("/test", "/тест")

	override fun getSteps(): Map<String, MessageHandlerStep<*>> = listOf(
		object : MessageHandlerStep<String> {
			override fun getKey(): String = "one"

			override fun getQuestion(): QuestionBlock = {
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

			override fun getValidation(): ValidationBlock<String> = {
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

			override fun getQuestion(): QuestionBlock = {
				TextSendMessage(it.chat.id, text = "Точно?")
			}

			override fun getValidation(): ValidationBlock<String> = {
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

	override fun getProcess(): ProcessBlock = { state, answers ->
		TextSendMessage(state.chat.id, text = answers.values.toString())
	}

}
