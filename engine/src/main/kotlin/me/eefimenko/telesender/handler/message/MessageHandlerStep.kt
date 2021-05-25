package me.eefimenko.telesender.handler.message

import me.eefimenko.telesender.handler.MessageQuestionBlock
import me.eefimenko.telesender.handler.MessageValidationBlock

/**
 * @author Yauheni Yefimenka
 */
interface MessageHandlerStep<T : Any> {

	fun getKey(): String

	fun getQuestion(): MessageQuestionBlock

	fun getValidation(): MessageValidationBlock<T>

	fun getNextStepKey(): String?

}
