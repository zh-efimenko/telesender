package io.github.telesender.model.telegram.send

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import io.github.telesender.model.telegram.common.MessageEntity
import io.github.telesender.model.telegram.common.PollType
import io.github.telesender.model.telegram.send.dictionary.ParseMode
import io.github.telesender.model.telegram.send.keyboard.ReplyMarkup

/**
 * @author Yauheni Yefimenka
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
data class PollSendMessage @JvmOverloads constructor(

	/**
	 * Unique identifier for the target chat or username of the target channel
	 * (in the format @channelusername)
	 */
	@get:JsonProperty("chat_id")
	val chatId: Long,

	/**
	 * Poll question, 1-300 characters
	 */
	@get:JsonProperty("question")
	val question: String,

	/**
	 * A JSON-serialized list of answer options, 2-10 strings 1-100 characters each
	 */
	@get:JsonProperty("options")
	val options: List<String>,

	/**
	 * Optional. True, if the poll needs to be anonymous, defaults to True
	 */
	@get:JsonProperty("is_anonymous")
	val isAnonymous: Boolean? = null,

	/**
	 * Optional. Poll type, “quiz” or “regular”, defaults to “regular”
	 */
	@get:JsonProperty("type")
	@get:JsonSerialize(using = PollType.PollTypeSerializer::class)
	val type: PollType? = null,

	/**
	 * Optional. True, if the poll allows multiple answers, ignored for polls in quiz mode, defaults to False
	 */
	@get:JsonProperty("allows_multiple_answers")
	val allowsMultipleAnswers: Boolean? = null,

	/**
	 * Optional. 0-based identifier of the correct answer option, required for polls in quiz mode
	 */
	@get:JsonProperty("correct_option_id")
	val correctOptionId: Int? = null,

	/**
	 * Optional. Text that is shown when a user chooses an incorrect answer or taps on the lamp icon
	 * in a quiz-style poll, 0-200 characters with at most 2 line feeds after entities parsing
	 */
	@get:JsonProperty("explanation")
	val explanation: String? = null,

	/**
	 * Optional. Mode for parsing entities in the explanation. See formatting options for more details.
	 */
	@get:JsonProperty("explanation_parse_mode")
	@get:JsonSerialize(using = ParseMode.ParseModeSerializer::class)
	val explanationParseMode: ParseMode? = null,

	/**
	 * Optional. List of special entities that appear in the poll explanation,
	 * which can be specified instead of parse_mode
	 */
	@get:JsonProperty("explanation_entities")
	val explanationEntities: List<MessageEntity>? = null,

	/**
	 * Optional. Amount of time in seconds the poll will be active after creation, 5-600.
	 * Can't be used together with close_date.
	 */
	@get:JsonProperty("open_period")
	val openPeriod: Int? = null,

	/**
	 * Optional. Point in time (Unix timestamp) when the poll will be automatically closed.
	 * Must be at least 5 and no more than 600 seconds in the future.
	 * Can't be used together with open_period.
	 */
	@get:JsonProperty("close_date")
	val closeDate: Int? = null,

	/**
	 * Optional. Pass True, if the poll needs to be immediately closed. This can be useful for poll preview.
	 */
	@get:JsonProperty("is_closed")
	val isClosed: Boolean? = null,

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
