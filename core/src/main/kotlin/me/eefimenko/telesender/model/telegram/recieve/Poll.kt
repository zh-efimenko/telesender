package me.eefimenko.telesender.model.telegram.recieve

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import me.eefimenko.telesender.model.telegram.common.MessageEntity
import me.eefimenko.telesender.model.telegram.common.PollType

/**
 * This object contains information about a poll.
 *
 * @author Yauheni Yefimenka
 */
data class Poll(

	/**
	 * Unique poll identifier
	 */
	@JsonProperty("id")
	val id: String,

	/**
	 * Poll question, 1-300 characters
	 */
	@JsonProperty("question")
	val question: String,

	/**
	 * List of poll options
	 */
	@JsonProperty("options")
	val options: List<PollOption>,

	/**
	 * Total number of users that voted in the poll
	 */
	@JsonProperty("total_voter_count")
	val totalVoterCount: Int,

	/**
	 * True, if the poll is closed
	 */
	@JsonProperty("is_closed")
	val isClosed: Boolean,

	/**
	 * True, if the poll is anonymous
	 */
	@JsonProperty("is_anonymous")
	val isAnonymous: Boolean,

	/**
	 * Poll type, currently can be “regular” or “quiz”
	 */
	@JsonProperty("type")
	@JsonDeserialize(using = PollType.PollTypDeserializer::class)
	val type: PollType,

	/**
	 * True, if the poll allows multiple answers
	 */
	@JsonProperty("allows_multiple_answers")
	val allowsMultipleAnswers: Boolean,

	/**
	 * Optional. 0-based identifier of the correct answer option. Available only for polls in the quiz mode,
	 * which are closed, or was sent (not forwarded) by the bot or to the private chat with the bot.
	 */
	@JsonProperty("correct_option_id")
	val correctOptionId: Int? = null,

	/**
	 * Optional. Text that is shown when a user chooses an incorrect answer or taps on the lamp icon
	 * in a quiz-style poll, 0-200 characters
	 */
	@JsonProperty("explanation")
	val explanation: String? = null,

	/**
	 * Optional. Special entities like usernames, URLs, bot commands, etc. that appear in the explanation
	 */
	@JsonProperty("explanation_entities")
	val explanationEntities: List<MessageEntity>? = null,

	/**
	 * Optional. Amount of time in seconds the poll will be active after creation
	 */
	@JsonProperty("open_period")
	val openPeriod: Int? = null,

	/**
	 * Optional. Point in time (Unix timestamp) when the poll will be automatically closed
	 */
	@JsonProperty("close_date")
	val closeDate: Int? = null

)
