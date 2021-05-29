package io.github.telesender.handler.message

import io.github.telesender.handler.MessageQuestionBlock
import io.github.telesender.handler.MessageValidationBlock

/**
 * @author Yauheni Yefimenka
 */
interface MessageHandlerStep<T : Any> {

	fun getKey(): String

	fun getQuestion(): MessageQuestionBlock

	fun getValidation(): MessageValidationBlock<T>

	fun getNextStepKey(): String?

}
