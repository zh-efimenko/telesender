package me.eefimenko.telesender.filter

import me.eefimenko.telesender.annotation.TelegramFilterOrder
import me.eefimenko.telesender.component.TelegramApi
import me.eefimenko.telesender.handler.message.MessageHandler
import me.eefimenko.telesender.handler.message.MessageHandlerState
import me.eefimenko.telesender.model.telegram.recieve.Chat
import me.eefimenko.telesender.model.telegram.recieve.Message
import me.eefimenko.telesender.model.telegram.recieve.Update
import me.eefimenko.telesender.model.telegram.send.SendMessage
import me.eefimenko.telesender.model.telegram.send.TextSendMessage
import mu.KotlinLogging
import java.util.concurrent.ConcurrentHashMap

/**
 * @author Yauheni Yefimenka
 */
@TelegramFilterOrder(100)
class MessageFilter(
	private val telegramApi: TelegramApi,
	private val messageHandlers: List<MessageHandler>
) : TelegramFilter {

	private val log = KotlinLogging.logger {}

	private val states: MutableMap<Long, MessageHandlerState> = ConcurrentHashMap()

	override fun handleMessage(update: Update, chain: TelegramFilterChain) {
		if (update.message == null) {
			chain.doFilter(update)
			return
		}

		val message = update.message!!

		val handler = this.findHandler(message)
		if (handler == null) {
			chain.doFilter(update)
			return
		}

		val state = states[message.chat.id]

		try {
			if (state == null) {
				val newState = MessageHandlerState(message.chat, handler)
				states[message.chat.id] = newState

				handleStep(newState)
			} else {
				continueHandleStep(state, message)
			}
		} catch (e: Exception) {
			log.error("Error during handler processing", e)

			clearState(message.chat)
			val response = TextSendMessage(chatId = message.chat.id, text = "Something went wrong :(")
			telegramApi.send(response)
		}
	}

	override fun clearState(chat: Chat) {
		states.remove(chat.id)
	}

	private fun findHandler(message: Message): MessageHandler? {
		val state = states[message.chat.id]
		if (state != null) {
			return state.messageHandler
		}

		val text = message.text?.toLowerCase() ?: return null
		for (handler in messageHandlers) {
			if (handler.getCommands().any { text.startsWith(it) }) {
				return handler
			}
		}
		return null
	}

	private fun handleProcessBlock(state: MessageHandlerState): SendMessage? {
		clearState(state.chat)
		return state.messageHandler.getProcess()(state, state.answers)
	}

	private fun handleStep(state: MessageHandlerState) {
		val response = state.currentStep?.let { it.getQuestion()(state) } ?: handleProcessBlock(state)
		telegramApi.send(response)
	}

	private fun continueHandleStep(state: MessageHandlerState, message: Message) {
		val currentStep = state.currentStep!!

		try {
			// validation
			val answer = currentStep.getValidation()(message)

			state.answers[currentStep.getKey()] = answer

			// next step
			val nextStepKey = currentStep.getNextStepKey()
			val nextStep = nextStepKey?.let { state.messageHandler.getStepByKey(nextStepKey) }
			state.currentStep = nextStep

			handleStep(state)
		} catch (e: Exception) {
			log.error(e.message, e)

			val response = TextSendMessage(chatId = state.chat.id, text = e.message ?: "Validation error (:")
			telegramApi.send(response)
		}
	}

}
