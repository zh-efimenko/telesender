package io.github.telesender.model.telegram.send.inline

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import io.github.telesender.model.telegram.common.MessageEntity
import io.github.telesender.model.telegram.send.dictionary.ParseMode

/**
 * Represents the content of a text message to be sent as the result of an inline query.
 *
 * @author Yauheni Yefimenka
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
class InputTextMessageContent @JvmOverloads constructor(

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

) : InputMessageContent {

	override fun equals(other: Any?): Boolean {
		if (this === other) return true
		if (other !is InputTextMessageContent) return false

		if (messageText != other.messageText) return false
		if (parseMode != other.parseMode) return false
		if (entities != other.entities) return false
		if (disableWebPagePreview != other.disableWebPagePreview) return false

		return true
	}

	override fun hashCode(): Int {
		var result = messageText.hashCode()
		result = 31 * result + (parseMode?.hashCode() ?: 0)
		result = 31 * result + (entities?.hashCode() ?: 0)
		result = 31 * result + (disableWebPagePreview?.hashCode() ?: 0)
		return result
	}
}
