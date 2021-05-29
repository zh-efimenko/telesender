package io.github.telesender.handler

import io.github.telesender.handler.message.MessageHandlerStep

/**
 * @author Yauheni Yefimenka
 */
interface Handler

interface HandlerCommands {

	/**
	 * The key is text of the command, 1-32 characters.
	 * Can contain only lowercase English letters, digits and underscores. And command must start with /.
	 *
	 * The value is description
	 */
	fun getCommands(): Map<String, String>

}

interface MessageHandler : Handler, HandlerCommands {

	fun getSteps(): Map<String, MessageHandlerStep<*>>

	fun getInitialStepKey(): String?

	fun getProcess(): MessageProcessBlock

	fun getStepByKey(key: String): MessageHandlerStep<*>? = getSteps()[key]

	fun getInitialStep(): MessageHandlerStep<*>? = getInitialStepKey()?.let { getStepByKey(it) }

}

interface CallbackQueryHandler : Handler, HandlerCommands {

	fun getProcess(): CallbackQueryProcessBlock

}

interface PollHandler : Handler {

	fun getProcess(): PollProcessBlock

}

interface PollAnswerHandler : Handler {

	fun getProcess(): PollAnswerProcessBlock

}
