package io.github.telesender.model.telegram.send.keyboard

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * @author Yauheni Yefimenka
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
class ForceReply @JvmOverloads constructor(

	/**
	 * Shows reply interface to the user, as if they manually selected the bot's message and tapped 'Reply'
	 */
	@get:JsonProperty("force_reply")
	val forceReply: Boolean = true,

	/**
	 * Optional. Use this parameter if you want to force reply from specific users only.
	 * Targets: 1) users that are @mentioned in the text of the Message object;
	 * 2) if the bot's message is a reply (has reply_to_message_id), sender of the original message.
	 */
	@get:JsonProperty("selective")
	val selective: Boolean? = null

) : ReplyMarkup {

	override fun equals(other: Any?): Boolean {
		if (this === other) return true
		if (other !is ForceReply) return false

		if (forceReply != other.forceReply) return false
		if (selective != other.selective) return false

		return true
	}

	override fun hashCode(): Int {
		var result = forceReply.hashCode()
		result = 31 * result + (selective?.hashCode() ?: 0)
		return result
	}
}
