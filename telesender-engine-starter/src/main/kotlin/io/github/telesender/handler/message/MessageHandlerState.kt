package io.github.telesender.handler.message

import io.github.telesender.handler.MessageHandler
import io.github.telesender.model.telegram.recieve.Message
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
