package me.eefimenko.telesender.model.telegram.request

import com.fasterxml.jackson.annotation.JsonProperty
import me.eefimenko.telesender.model.telegram.request.inline.CallbackQuery
import me.eefimenko.telesender.model.telegram.request.inline.ChosenInlineResult
import me.eefimenko.telesender.model.telegram.request.inline.InlineQuery

/**
 * This object represents an incoming update.
 * At most one of the optional parameters can be present in any given update.
 */
data class Update(

	/**
	 * 	The update's unique identifier. Update identifiers start from a certain positive number
	 * 	and increase sequentially. This ID becomes especially handy if you're using Webhooks,
	 * 	since it allows you to ignore repeated updates or to restore the correct update sequence,
	 * 	should they get out of order. If there are no new updates for at least a week,
	 * 	then identifier of the next update will be chosen randomly instead of sequentially.
	 */
	@JsonProperty("update_id")
	val updateId: Long,

	/**
	 * Optional. New incoming message of any kind — text, photo, sticker, etc.
	 */
	@JsonProperty("message")
	val message: Message? = null,

	/**
	 * Optional. New version of a message that is known to the bot and was edited.
	 */
	@JsonProperty("edited_message")
	val editedMessage: Message? = null,

	/**
	 * Optional. New incoming channel post of any kind — text, photo, sticker, etc.
	 */
	@JsonProperty("channel_post")
	val channelPost: Message? = null,

	/**
	 * Optional. New version of a channel post that is known to the bot and was edited.
	 */
	@JsonProperty("edited_channel_post")
	val editedChannelPost: Message? = null,

	/**
	 * Optional. New incoming inline query
	 */
	@JsonProperty("inline_query")
	val inlineQuery: InlineQuery? = null,

	/**
	 * Optional. The result of an inline query that was chosen by a user and sent to their chat partner.
	 * Please see our documentation on the feedback collecting for details on how to enable these updates for your bot.
	 */
	@JsonProperty("chosen_inline_result")
	val chosenInlineResult: ChosenInlineResult? = null,

	/**
	 * Optional. New incoming callback query
	 */
	@JsonProperty("callback_query")
	val callbackQuery: CallbackQuery? = null,

	/**
	 * Optional. New poll state. Bots receive only updates about stopped polls and polls, which are sent by the bot
	 */
	@JsonProperty("poll")
	val poll: Poll? = null,

	/**
	 * Optional. A user changed their answer in a non-anonymous poll.
	 * Bots receive new votes only in polls that were sent by the bot itself.
	 */
	@JsonProperty("poll_answer")
	val pollAnswer: PollAnswer? = null

)
