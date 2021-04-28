package me.eefimenko.telesender.model.telegram.request

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * @author Yauheni Yefimenka
 *
 * This object represents a point on the map.
 */
class Location(

	/**
	 * Longitude as defined by sender.
	 */
	@JsonProperty("longitude")
	val longitude: Float,

	/**
	 * Latitude as defined by sender.
	 */
	@JsonProperty("latitude")
	val latitude: Float,

	/**
	 * Optional. The radius of uncertainty for the location, measured in meters; 0-1500
	 */
	@JsonProperty("horizontal_accuracy")
	val horizontal_accuracy: Float? = null,

	/**
	 * 	Optional. Time relative to the message sending date, during which the location can be updated,
	 * 	in seconds. For active live locations only.
	 */
	@JsonProperty("live_period")
	val live_period: Long? = null,

	/**
	 * Optional. The direction in which user is moving, in degrees; 1-360. For active live locations only.
	 */
	@JsonProperty("heading")
	val heading: Int? = null,

	/**
	 * Optional. Maximum distance for proximity alerts about approaching another chat member,
	 * in meters. For sent live locations only.
	 */
	@JsonProperty("proximity_alert_radius")
	val proximity_alert_radius: Int? = null

)
