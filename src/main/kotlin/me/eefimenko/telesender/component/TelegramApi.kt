package me.eefimenko.telesender.component

import me.eefimenko.telesender.model.telegram.response.SendMessage
import me.eefimenko.telesender.model.telegram.response.inline.AnswerInlineQuery
import me.eefimenko.telesender.model.telegram.request.Message
import me.eefimenko.telesender.model.telegram.request.Update
import me.eefimenko.telesender.model.telegram.request.User

/**
 * @author Yauheni Yefimenka
 */
interface TelegramApi {

	fun getMe(): User

	fun getUpdates(offset: Long? = null, timeout: Int? = null): List<Update>

	fun sendMessage(sendMessage: SendMessage): Message

	fun answerInlineQuery(answerInlineQuery: AnswerInlineQuery): Boolean

}
