package me.eefimenko.telesender.handler.message

/**
 * @author Yauheni Yefimenka
 */
interface MessageHandlerStep<T : Any> {

	fun getKey(): String

	fun getQuestion(): QuestionBlock

	fun getValidation(): ValidationBlock<T>

	fun getNextStepKey(): String?

}
