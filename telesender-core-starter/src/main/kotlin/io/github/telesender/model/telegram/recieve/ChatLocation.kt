package io.github.telesender.model.telegram.recieve

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Represents a location to which a chat is connected.
 *
 * @author Yauheni Yefimenka
 */
data class ChatLocation(

	/**
	 * The location to which the supergroup is connected. Can't be a live location.
	 */
	@JsonProperty("location")
	val location: Location,

	/**
	 * Location address; 1-64 characters, as defined by the chat owner
	 */
	@JsonProperty("address")
	val address: String

)
