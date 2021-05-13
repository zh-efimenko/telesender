package me.eefimenko.telesender.model.telegram.request.inline

import com.fasterxml.jackson.annotation.JsonProperty
import me.eefimenko.telesender.model.telegram.request.Location
import me.eefimenko.telesender.model.telegram.request.User

/**
 * This object represents an incoming inline query. When the user sends an empty query, your bot could
 * return some default or trending results.
 *
 * @author Yauheni Yefimenka
 */
class InlineQuery(

	/**
	 * Unique identifier for this query.
	 */
	@JsonProperty("id")
	val id: String,

	/**
	 * Sender.
	 */
	@JsonProperty("from")
	val from: User,

	/**
	 * Optional. Sender location, only for bots that request user location.
	 */
	@JsonProperty("location")
	val location: Location? = null,

	/**
	 * Text of the query (up to 256 characters).
	 */
	@JsonProperty("query")
	val query: String,

	/**
	 * Offset of the results to be returned, can be controlled by the bot.
	 */
	@JsonProperty("offset")
	val offset: String

)
