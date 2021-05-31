package io.github.telesender.model.telegram.send

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import io.github.telesender.model.telegram.send.keyboard.ReplyMarkup

/**
 * @author Yauheni Yefimenka
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
data class LocationSendMessage @JvmOverloads constructor(

	/**
	 * Unique identifier for the target chat or username of the target channel
	 * (in the format @channelusername)
	 */
	@get:JsonProperty("chat_id")
	val chatId: Long,

	/**
	 * Latitude of the location
	 */
	@get:JsonProperty("latitude")
	val latitude: Float,

	/**
	 * Longitude of the location
	 */
	@get:JsonProperty("longitude")
	val longitude: Float,

	/**
	 * Optional. The radius of uncertainty for the location, measured in meters; 0-1500
	 */
	@get:JsonProperty("horizontal_accuracy")
	val horizontalAccuracy: Float? = null,

	/**
	 * Optional. For live locations, a direction in which the user is moving, in degrees.
	 * Must be between 1 and 360 if specified.
	 */
	@get:JsonProperty("heading")
	val heading: Int? = null,

	/**
	 * Optional. For live locations, a maximum distance for proximity alerts about approaching another
	 * chat member, in meters. Must be between 1 and 100000 if specified.
	 */
	@get:JsonProperty("proximity_alert_radius")
	val proximityAlertRadius: Int? = null,

	/**
	 * Optional. Sends the message silently. Users will receive a notification with no sound.
	 */
	@get:JsonProperty("disable_notification")
	val disableNotification: Boolean? = null,

	/**
	 * Optional. If the message is a reply, ID of the original message
	 */
	@get:JsonProperty("reply_to_message_id")
	val replyToMessageId: Long? = null,

	/**
	 * Optional. Pass True, if the message should be sent even if the specified replied-to message is not found
	 */
	@get:JsonProperty("allow_sending_without_reply")
	val allowSendingWithoutReply: Boolean? = null,

	/**
	 * Optional. Additional interface options. A JSON-serialized object for an inline keyboard,
	 * custom reply keyboard, instructions to remove reply keyboard or to force a reply from the user.
	 */
	@get:JsonProperty("reply_markup")
	val replyMarkup: ReplyMarkup? = null

) : SendMessage
