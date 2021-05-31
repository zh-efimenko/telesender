package io.github.telesender.model.telegram.send

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import io.github.telesender.model.telegram.send.keyboard.ReplyMarkup

/**
 * @author Yauheni Yefimenka
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
data class VenueSendMessage @JvmOverloads constructor(

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
	 * Name of the venue
	 */
	@get:JsonProperty("title")
	val title: String,

	/**
	 * Address of the venue
	 */
	@get:JsonProperty("address")
	val address: String,

	/**
	 * Optional. Foursquare identifier of the venue
	 */
	@get:JsonProperty("foursquare_id")
	val foursquareId: String? = null,

	/**
	 * 	Optional. Foursquare type of the venue, if known.
	 * 	(For example, “arts_entertainment/default”, “arts_entertainment/aquarium” or “food/icecream”.)
	 */
	@get:JsonProperty("foursquare_type")
	val foursquareType: String? = null,

	/**
	 * Optional. Google Places identifier of the venue
	 */
	@get:JsonProperty("google_place_id")
	val googlePlaceId: String? = null,

	/**
	 * Optional. Google Places type of the venue. (See supported types -
	 * @link https://developers.google.com/maps/documentation/places/web-service/supported_types)
	 */
	@get:JsonProperty("google_place_type")
	val googlePlaceType: String? = null,

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
