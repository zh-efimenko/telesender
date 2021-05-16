package me.eefimenko.telesender.model.telegram.recieve

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * This object represents a unique message identifier.
 *
 * @author Yauheni Yefimenka
 */
data class MessageId(

	/**
	 * Unique message identifier
	 */
	@JsonProperty("message_id")
	val messageId: Int

)
