package me.eefimenko.telesender.model.telegram.request

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * This object represents a venue.
 *
 * @author Yauheni Yefimenka
 */
data class Venue(

	/**
	 * Venue location. Can't be a live location
	 */
	@JsonProperty("location")
	val location: Location,

	/**
	 * Name of the venue
	 */
	@JsonProperty("title")
	val title: String,

	/**
	 * Address of the venue
	 */
	@JsonProperty("address")
	val address: String,

	/**
	 * Optional. Foursquare identifier of the venue
	 */
	@JsonProperty("foursquare_id")
	val foursquareId: String? = null,

	/**
	 * Optional. Foursquare type of the venue. (For example, “arts_entertainment/default”,
	 * “arts_entertainment/aquarium” or “food/icecream”.)
	 */
	@JsonProperty("foursquare_type")
	val foursquareType: String? = null,

	/**
	 * Optional. Google Places identifier of the venue
	 */
	@JsonProperty("google_place_id")
	val googlePlaceId: String? = null,

	/**
	 * Optional. Google Places type of the venue. (See supported types.)
	 */
	@JsonProperty("google_place_type")
	val googlePlaceType: String? = null

)
