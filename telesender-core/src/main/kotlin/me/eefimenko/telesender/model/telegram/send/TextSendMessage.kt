package me.eefimenko.telesender.model.telegram.send

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import me.eefimenko.telesender.model.telegram.common.MessageEntity
import me.eefimenko.telesender.model.telegram.send.dictionary.ParseMode
import me.eefimenko.telesender.model.telegram.send.keyboard.ReplyMarkup

/**
 * @author Yauheni Yefimenka
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
data class TextSendMessage(

	/**
	 * Unique identifier for the target chat or username of the target channel (in the format @channelusername).
	 */
	@get:JsonProperty("chat_id")
	val chatId: Long,

	/**
	 * Text of the message to be sent, 1-4096 characters after entities parsing.
	 */
	@get:JsonProperty("text")
	val text: String,

	/**
	 * Mode for parsing entities in the message text. See formatting options for more details.
	 */
	@get:JsonProperty("parse_mode")
	@get:JsonSerialize(using = ParseMode.ParseModeSerializer::class)
	val parseMode: ParseMode? = null,

	/**
	 * List of special entities that appear in message text, which can be specified instead of parse_mode.
	 */
	@get:JsonProperty("entities")
	val entities: List<MessageEntity>? = null,

	/**
	 * Disables link previews for links in this message.
	 */
	@get:JsonProperty("disable_web_page_preview")
	val disableWebPagePreview: Boolean? = null,

	/**
	 * Sends the message silently. Users will receive a notification with no sound.
	 */
	@get:JsonProperty("disable_notification")
	val disableNotification: Boolean? = null,

	/**
	 * If the message is a reply, ID of the original message.
	 */
	@get:JsonProperty("reply_to_message_id")
	val replyToMessageId: Long? = null,

	/**
	 * Pass True, if the message should be sent even if the specified replied-to message is not found.
	 */
	@get:JsonProperty("allow_sending_without_reply")
	val allowSendingWithoutReply: Boolean? = null,

	/**
	 * Additional interface options. A JSON-serialized object for an inline keyboard,
	 * custom reply keyboard, instructions to remove reply keyboard or to force a reply from the user.
	 */
	@get:JsonProperty("reply_markup")
	val replyMarkup: ReplyMarkup? = null

) : SendMessage
