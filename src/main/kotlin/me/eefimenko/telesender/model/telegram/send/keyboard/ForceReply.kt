package me.eefimenko.telesender.model.telegram.send.keyboard

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * @author Yauheni Yefimenka
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
class ForceReply(

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

) : ReplyMarkup
