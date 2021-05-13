package me.eefimenko.telesender.model.telegram.response.keyboard

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
class KeyboardButton(

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
	val requestLocation: Boolean? = null

)
