package io.github.telesender.model.telegram.send.keyboard

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * @author Yauheni Yefimenka
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
class ReplyKeyboardRemove @JvmOverloads constructor(

	/**
	 * Requests clients to remove the custom keyboard (user will not be able to summon this keyboard;
	 * if you want to hide the keyboard from sight but keep it accessible, use one_time_keyboard in ReplyKeyboardMarkup)
	 */
	@get:JsonProperty("remove_keyboard")
	val removeKeyboard: Boolean = true,

	/**
	 * Optional. Use this parameter if you want to remove the keyboard for specific users only.
	 * Targets: 1) users that are @mentioned in the text of the Message object;
	 * 2) if the bot's message is a reply (has reply_to_message_id), sender of the original message.
	 *
	 * Example: A user votes in a poll, bot returns confirmation message in reply to the vote and removes
	 * the keyboard for that user, while still showing the keyboard with poll options to users who haven't voted yet.
	 */
	@get:JsonProperty("selective")
	val selective: Boolean? = null

) : ReplyMarkup {

	override fun equals(other: Any?): Boolean {
		if (this === other) return true
		if (other !is ReplyKeyboardRemove) return false

		if (removeKeyboard != other.removeKeyboard) return false
		if (selective != other.selective) return false

		return true
	}

	override fun hashCode(): Int {
		var result = removeKeyboard.hashCode()
		result = 31 * result + (selective?.hashCode() ?: 0)
		return result
	}
}
