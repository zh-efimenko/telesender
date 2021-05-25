package me.eefimenko.telesender.handler.message

import me.eefimenko.telesender.handler.MessageHandler
import me.eefimenko.telesender.model.telegram.recieve.Chat
import java.util.concurrent.ConcurrentHashMap

/**
 * @author Yauheni Yefimenka
 */
class MessageHandlerState(
	val chat: Chat,
	val messageHandler: MessageHandler
) {

	var currentStep: MessageHandlerStep<*>? = messageHandler.getInitialStep()
	val answers: MutableMap<String, Any> = ConcurrentHashMap()

}
