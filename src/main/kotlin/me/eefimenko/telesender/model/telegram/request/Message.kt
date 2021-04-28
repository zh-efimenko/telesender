package me.eefimenko.telesender.model.telegram.request

import com.fasterxml.jackson.annotation.JsonProperty
import java.util.*

data class Message(

	/**
	 * Unique message identifier inside this chat.
	 */
	@JsonProperty("message_id")
	val messageId: Long,

	/**
	 * Optional. Sender, empty for messages sent to channels.
	 */
	@JsonProperty("from")
	val user: User? = null,

	/**
	 * Optional. Sender of the message, sent on behalf of a chat. The channel itself for channel messages.
	 * The supergroup itself for messages from anonymous group administrators.
	 * The linked channel for messages automatically forwarded to the discussion group.
	 */
	@JsonProperty("sender_chat")
	val senderChat: Chat? = null,

	/**
	 * Date the message was sent in Unix time.
	 */
	@JsonProperty("date")
	val date: Long,

	/**
	 * Conversation the message belongs to.
	 */
	@JsonProperty("chat")
	val chat: Chat,

	/**
	 * Optional. For forwarded messages, sender of the original message.
	 */
	@JsonProperty("forward_from")
	val forwardFrom: User? = null,

	/**
	 * Optional. Sender's name for messages forwarded from users who disallow adding a link
	 * to their account in forwarded messages.
	 */
	@JsonProperty("forward_sender_name")
	val forwardSenderName: String? = null,

	/**
	 * Optional. For forwarded messages, date the original message was sent in Unix time.
	 */
	@JsonProperty("forward_date")
	val forwardDate: Long? = null,

	/**
	 * Optional. Message is a shared contact, information about the contact.
	 */
	@JsonProperty("contact")
	val contact: Contact? = null,

	/**
	 * Optional. For text messages, the actual UTF-8 text of the message, 0-4096 characters.
	 */
	@JsonProperty("text")
	val text: String? = null

) {

	fun getDate(): Date = Date(date * 1000)

	fun getForwardDate(): Date? = forwardDate?.let { Date(it * 1000) }

}
