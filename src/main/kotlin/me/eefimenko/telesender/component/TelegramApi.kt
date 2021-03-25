package me.eefimenko.telesender.component

import me.eefimenko.telesender.model.telegram.request.SendMessage
import me.eefimenko.telesender.model.telegram.request.inline.AnswerInlineQuery
import me.eefimenko.telesender.model.telegram.response.Message
import me.eefimenko.telesender.model.telegram.response.Update
import me.eefimenko.telesender.model.telegram.response.User

/**
 * @author Yauheni Yefimenka
 */
interface TelegramApi {

	fun getMe(): User

	fun getUpdates(offset: Long? = null, timeout: Int? = null): List<Update>

	fun sendMessage(sendMessage: SendMessage): Message

	fun answerInlineQuery(answerInlineQuery: AnswerInlineQuery): Boolean

}
