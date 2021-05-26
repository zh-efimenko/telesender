package me.eefimenko.telesender.filter

import me.eefimenko.telesender.annotation.TelegramFilterOrder
import me.eefimenko.telesender.component.TelegramApi
import me.eefimenko.telesender.filter.util.FilterExceptionUtil
import me.eefimenko.telesender.handler.MessageHandler
import me.eefimenko.telesender.handler.message.MessageHandlerState
import me.eefimenko.telesender.model.telegram.recieve.Message
import me.eefimenko.telesender.model.telegram.recieve.Update
import me.eefimenko.telesender.model.telegram.send.SendMessage
import me.eefimenko.telesender.model.telegram.send.TextSendMessage
import java.util.concurrent.ConcurrentHashMap

/**
 * @author Yauheni Yefimenka
 */
@TelegramFilterOrder(100)
class MessageFilter(
	private val telegramApi: TelegramApi,
	private val handlers: List<MessageHandler>,
	private val exceptionUtil: FilterExceptionUtil
) : TelegramFilter {

	private val states: MutableMap<Long, MessageHandlerState> = ConcurrentHashMap()

	override fun getCommands(): Map<String, String> {
		val commands = mutableMapOf<String, String>()
		handlers.forEach {
			commands.putAll(it.getCommands())
		}

		return commands
	}

	override fun handleMessage(update: Update, chain: TelegramFilterChain) {
		if (update.message == null) {
			chain.doHandle(update)
			return
		}

		val message = update.message!!

		val handler = this.findHandler(message)
		if (handler == null) {
			chain.doHandle(update)
			return
		}

		val state = states[message.chat.id]

		try {
			if (state == null) {
				val newState = MessageHandlerState(message, handler)
				states[message.chat.id] = newState

				handleStep(newState)
			} else {
				continueHandleStep(state, message)
			}
		} catch (ex: Exception) {
			states.remove(message.chat.id)

			exceptionUtil.handleException(message, ex)
		}
	}

	override fun clearState(update: Update, chain: TelegramFilterChain) {
		if (update.message == null) {
			chain.doClear(update)
			return
		}

		states.remove(update.message!!.chat.id)
	}

	private fun findHandler(message: Message): MessageHandler? {
		val state = states[message.chat.id]
		if (state != null) {
			return state.messageHandler
		}

		val text = message.text?.toLowerCase() ?: return null
		for (handler in handlers) {
			if (handler.getCommands().keys.any { text.startsWith(it) }) {
				return handler
			}
		}
		return null
	}

	private fun handleProcessBlock(state: MessageHandlerState): SendMessage? {
		states.remove(state.message.chat.id)
		return state.messageHandler.getProcess()(state.message, state.answers)
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
		} catch (ex: Exception) {
			val response = TextSendMessage(chatId = state.message.chat.id, text = ex.message ?: "Validation error (:")
			telegramApi.send(response)
		}
	}

}
