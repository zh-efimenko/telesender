package me.eefimenko.telesender.handler

import me.eefimenko.telesender.handler.message.MessageHandlerStep

/**
 * @author Yauheni Yefimenka
 */
interface Handler {

	fun getCommands(): List<String>

	fun getProcess(): ProcessBlock

}

interface MessageHandler : Handler {

	fun getSteps(): Map<String, MessageHandlerStep<*>>

	fun getInitialStepKey(): String?

	fun getStepByKey(key: String): MessageHandlerStep<*>? = getSteps()[key]

	fun getInitialStep(): MessageHandlerStep<*>? = getInitialStepKey()?.let { getStepByKey(it) }

}

interface CallbackQueryHandler : Handler
