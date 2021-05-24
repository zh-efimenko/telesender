package me.eefimenko.telesender.model.telegram.send

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * @author Yauheni Yefimenka
 */
data class DeleteMessage(

	/**
	 * Unique identifier for the target chat or username of the target channel (in the format @channelusername)
	 */
	@get:JsonProperty("chat_id")
	val chatId: Long,

	/**
	 * Identifier of the message to delete
	 */
	@get:JsonProperty("message_id")
	val messageId: Long

)
