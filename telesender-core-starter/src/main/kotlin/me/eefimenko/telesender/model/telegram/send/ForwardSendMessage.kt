package me.eefimenko.telesender.model.telegram.send

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * @author Yauheni Yefimenka
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
data class ForwardSendMessage(

	/**
	 * Unique identifier for the target chat or username of the target channel
	 * (in the format @channelusername)
	 */
	@get:JsonProperty("chat_id")
	val chatId: Long,

	/**
	 * Unique identifier for the chat where the original message was sent
	 * (or channel username in the format @channelusername)
	 */
	@get:JsonProperty("from_chat_id")
	val fromChatId: Long,

	/**
	 * Message identifier in the chat specified in from_chat_id
	 */
	@get:JsonProperty("message_id")
	val message_id: Long,

	/**
	 * Optional. Sends the message silently. Users will receive a notification with no sound.
	 */
	@get:JsonProperty("disable_notification")
	val disableNotification: Boolean? = null

) : SendMessage
