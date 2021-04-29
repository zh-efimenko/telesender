package me.eefimenko.telesender.model.telegram.response.inline

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import me.eefimenko.telesender.model.telegram.MessageEntity
import me.eefimenko.telesender.model.telegram.response.dictionary.ParseMode

/**
 * @author Yauheni Yefimenka
 *
 * Represents the content of a text message to be sent as the result of an inline query.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
class InputTextMessageContent(

	/**
	 * Unique identifier for this result, 1-64 Bytes.
	 */
	@get:JsonProperty("message_text")
	val messageText: String,

	/**
	 * Optional. Mode for parsing entities in the message text. See formatting options for more details.
	 */
	@get:JsonProperty("parse_mode")
	@get:JsonSerialize(using = ParseMode.ParseModeSerializer::class)
	val parseMode: ParseMode? = null,

	/**
	 * Optional. List of special entities that appear in message text, which can be specified instead of parse_mode.
	 */
	@get:JsonProperty("entities")
	val entities: List<MessageEntity>? = null,

	/**
	 * Optional. Disables link previews for links in the sent message.
	 */
	@get:JsonProperty("disable_web_page_preview")
	val disableWebPagePreview: Boolean? = null

) : InputMessageContent
