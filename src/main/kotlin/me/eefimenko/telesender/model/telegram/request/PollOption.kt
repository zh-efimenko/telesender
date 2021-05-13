package me.eefimenko.telesender.model.telegram.request

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * This object contains information about one answer option in a poll.
 *
 * @author Yauheni Yefimenka
 */
data class PollOption(

	/**
	 * Option text, 1-100 characters
	 */
	@JsonProperty("text")
	val text: String,

	/**
	 * Number of users that voted for this option
	 */
	@JsonProperty("voter_count")
	val voterCount: Int

)
