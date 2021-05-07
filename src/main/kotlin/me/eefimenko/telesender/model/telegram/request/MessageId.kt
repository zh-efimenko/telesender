package me.eefimenko.telesender.model.telegram.request

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * This object represents a unique message identifier.
 */
data class MessageId(

	/**
	 * Unique message identifier
	 */
	@JsonProperty("message_id")
	val messageId: Int

)
