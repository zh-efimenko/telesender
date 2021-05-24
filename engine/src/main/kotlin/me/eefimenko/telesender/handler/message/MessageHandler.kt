package me.eefimenko.telesender.handler.message

/**
 * @author Yauheni Yefimenka
 */
interface MessageHandler {

	fun getCommands(): List<String>

	fun getSteps(): Map<String, MessageHandlerStep<*>>

	fun getInitialStepKey(): String?

	fun getProcess(): ProcessBlock

	fun getStepByKey(key: String): MessageHandlerStep<*>? = getSteps()[key]

	fun getInitialStep(): MessageHandlerStep<*>? = getInitialStepKey()?.let { getStepByKey(it) }

}
