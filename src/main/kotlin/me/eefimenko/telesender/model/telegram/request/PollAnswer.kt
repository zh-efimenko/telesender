package me.eefimenko.telesender.model.telegram.request

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * This object represents an answer of a user in a non-anonymous poll.
 *
 * @author Yauheni Yefimenka
 */
data class PollAnswer(

	/**
	 * Unique poll identifier
	 */
	@JsonProperty("poll_id")
	val pollId: Long,

	/**
	 * The user, who changed the answer to the poll
	 */
	@JsonProperty("user")
	val user: User,

	/**
	 * 0-based identifiers of answer options, chosen by the user. May be empty if the user retracted their vote.
	 */
	@JsonProperty("option_ids")
	val optionIds: List<Int>

)
