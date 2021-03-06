package io.github.telesender.model.telegram.send.inline

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.databind.ser.std.StdSerializer
import io.github.telesender.model.telegram.common.MessageEntity
import io.github.telesender.model.telegram.send.dictionary.ParseMode
import io.github.telesender.model.telegram.send.keyboard.InlineKeyboardMarkup

/**
 * Represents a link to a file. By default, this file will be sent by the user with an optional caption.
 * Alternatively, you can use input_message_content to send a message with the specified content instead of the file.
 * Currently, only .PDF and .ZIP files can be sent using this method.
 *
 * @author Yauheni Yefimenka
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
class InlineQueryResultDocument @JvmOverloads constructor(
	type: Type,
	id: String,

	/**
	 * Title for the result
	 */
	@get:JsonProperty("title")
	val title: String,

	/**
	 * A valid URL for the file
	 */
	@get:JsonProperty("document_url")
	val documentUrl: String,

	/**
	 * Mime type of the content of the file, either “application/pdf” or “application/zip”
	 */
	@get:JsonProperty("mime_type")
	@get:JsonSerialize(using = DocType.DocTypeSerializer::class)
	val mimeType: DocType,

	/**
	 * 	Optional. Caption of the document to be sent, 0-1024 characters after entities parsing
	 */
	@get:JsonProperty("caption")
	val caption: String? = null,

	/**
	 * 	Optional. Mode for parsing entities in the document caption. See formatting options for more details.
	 */
	@get:JsonProperty("parse_mode")
	@get:JsonSerialize(using = ParseMode.ParseModeSerializer::class)
	val parseMode: ParseMode? = null,

	/**
	 * 	Optional. List of special entities that appear in the caption, which can be specified instead of parse_mode
	 */
	@get:JsonProperty("caption_entities")
	val captionEntities: List<MessageEntity>? = null,

	/**
	 * 	Optional. Short description of the result
	 */
	@get:JsonProperty("description")
	val description: String? = null,

	inputMessageContent: InputMessageContent? = null,
	replyMarkup: InlineKeyboardMarkup? = null,

	/**
	 * 	Optional. URL of the thumbnail (jpeg only) for the file
	 */
	@get:JsonProperty("thumb_url")
	val thumbUrl: String? = null,

	/**
	 * 	Optional. Thumbnail width
	 */
	@get:JsonProperty("thumb_width")
	val thumbWidth: Int? = null,

	/**
	 * 	Optional. Thumbnail height
	 */
	@get:JsonProperty("thumb_height")
	val thumbHeight: Int? = null

) : InlineQueryResult(type, id, inputMessageContent, replyMarkup) {

	enum class DocType(val value: String) {

		ZIP("application/zip"),
		PDF("application/pdf");

		class DocTypeSerializer : StdSerializer<DocType>(DocType::class.java) {
			override fun serialize(value: DocType, generator: JsonGenerator, provider: SerializerProvider) {
				generator.writeString(value.value)
			}
		}
	}

	override fun equals(other: Any?): Boolean {
		if (this === other) return true
		if (other !is InlineQueryResultDocument) return false
		if (!super.equals(other)) return false

		if (title != other.title) return false
		if (documentUrl != other.documentUrl) return false
		if (mimeType != other.mimeType) return false
		if (caption != other.caption) return false
		if (parseMode != other.parseMode) return false
		if (captionEntities != other.captionEntities) return false
		if (description != other.description) return false
		if (thumbUrl != other.thumbUrl) return false
		if (thumbWidth != other.thumbWidth) return false
		if (thumbHeight != other.thumbHeight) return false

		return true
	}

	override fun hashCode(): Int {
		var result = super.hashCode()
		result = 31 * result + title.hashCode()
		result = 31 * result + documentUrl.hashCode()
		result = 31 * result + mimeType.hashCode()
		result = 31 * result + (caption?.hashCode() ?: 0)
		result = 31 * result + (parseMode?.hashCode() ?: 0)
		result = 31 * result + (captionEntities?.hashCode() ?: 0)
		result = 31 * result + (description?.hashCode() ?: 0)
		result = 31 * result + (thumbUrl?.hashCode() ?: 0)
		result = 31 * result + (thumbWidth ?: 0)
		result = 31 * result + (thumbHeight ?: 0)
		return result
	}
}
