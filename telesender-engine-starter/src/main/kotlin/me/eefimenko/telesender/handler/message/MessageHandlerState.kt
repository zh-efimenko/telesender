package me.eefimenko.telesender.handler.message

import me.eefimenko.telesender.handler.MessageHandler
import me.eefimenko.telesender.model.telegram.recieve.Message
import java.util.concurrent.ConcurrentHashMap

/**
 * @author Yauheni Yefimenka
 */
class MessageHandlerState(
	val message: Message,
	val messageHandler: MessageHandler
) {

	var currentStep: MessageHandlerStep<*>? = messageHandler.getInitialStep()
	val answers: MutableMap<String, Any> = ConcurrentHashMap()

}
