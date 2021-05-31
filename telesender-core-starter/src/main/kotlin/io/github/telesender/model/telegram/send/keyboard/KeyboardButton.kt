package io.github.telesender.model.telegram.send.keyboard

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * This object represents one button of the reply keyboard. For simple text buttons String can be used
 * instead of this object to specify text of the button. Optional fields request_contact, request_location,
 * and request_poll are mutually exclusive.
 *
 * @author Yauheni Yefimenka
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
class KeyboardButton @JvmOverloads constructor(

	/**
	 * Text of the button. If none of the optional fields are used,
	 * it will be sent as a message when the button is pressed.
	 */
	@get:JsonProperty("text")
	val text: String,

	/**
	 * 	Optional. If True, the user's phone number will be sent as a contact when the button is pressed.
	 * 	Available in private chats only
	 */
	@get:JsonProperty("request_contact")
	val requestContact: Boolean? = null,

	/**
	 * Optional. If True, the user's current location will be sent when the button is pressed.
	 * Available in private chats only
	 */
	@get:JsonProperty("request_location")
	val requestLocation: Boolean? = null,

	/**
	 * Optional. If specified, the user will be asked to create a poll and send it to the bot
	 * when the button is pressed. Available in private chats only
	 */
	@get:JsonProperty("request_poll")
	val requestPoll: KeyboardButtonPollType? = null

) {

	override fun equals(other: Any?): Boolean {
		if (this === other) return true
		if (other !is KeyboardButton) return false

		if (text != other.text) return false
		if (requestContact != other.requestContact) return false
		if (requestLocation != other.requestLocation) return false

		return true
	}

	override fun hashCode(): Int {
		var result = text.hashCode()
		result = 31 * result + (requestContact?.hashCode() ?: 0)
		result = 31 * result + (requestLocation?.hashCode() ?: 0)
		return result
	}
}
