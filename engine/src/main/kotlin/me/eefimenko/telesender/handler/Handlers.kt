package me.eefimenko.telesender.handler

import me.eefimenko.telesender.handler.message.MessageHandlerStep

/**
 * @author Yauheni Yefimenka
 */
interface Handler {

	fun getCommands(): Map<String, String>

}

interface MessageHandler : Handler {

	fun getSteps(): Map<String, MessageHandlerStep<*>>

	fun getInitialStepKey(): String?

	fun getProcess(): MessageProcessBlock

	fun getStepByKey(key: String): MessageHandlerStep<*>? = getSteps()[key]

	fun getInitialStep(): MessageHandlerStep<*>? = getInitialStepKey()?.let { getStepByKey(it) }

}

interface CallbackQueryHandler : Handler {

	fun getProcess(): CallbackQueryProcessBlock

}

interface PollHandler : Handler {

	fun getProcess(): PollProcessBlock

}

interface PollAnswerHandler : Handler {

	fun getProcess(): PollAnswerProcessBlock

}
