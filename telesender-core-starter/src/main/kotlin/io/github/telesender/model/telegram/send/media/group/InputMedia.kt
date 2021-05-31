package io.github.telesender.model.telegram.send.media.group

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.databind.ser.std.StdSerializer
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import io.github.telesender.model.telegram.common.MessageEntity
import io.github.telesender.model.telegram.send.dictionary.ParseMode
import io.github.telesender.model.telegram.send.util.mediaStringOrFile
import java.io.File

/**
 * @author Yauheni Yefimenka
 */
abstract class InputMedia @JvmOverloads constructor(

	/**
	 * Type of the result, must be photo, document, video, audio or animation
	 */
	@get:JsonProperty("type")
	@get:JsonSerialize(using = InputMediaType.InputMediaTypeSerializer::class)
	val type: InputMediaType,

	media: Any,
	thumb: Any? = null,

	/**
	 * Optional. Caption of the photo to be sent, 0-1024 characters after entities parsing
	 */
	@get:JsonProperty("caption")
	val caption: String? = null,

	/**
	 * Optional. Mode for parsing entities in the photo caption. See formatting options for more details.
	 */
	@get:JsonProperty("parse_mode")
	@get:JsonSerialize(using = ParseMode.ParseModeSerializer::class)
	val parseMode: ParseMode? = null,

	/**
	 * Optional. List of special entities that appear in the caption, which can be specified instead of parse_mode
	 */
	@get:JsonProperty("caption_entities")
	val captionEntities: List<MessageEntity>? = null

) {

	/**
	 * File to send. Pass a file_id to send a file that exists on the Telegram servers (recommended),
	 * pass an HTTP URL for Telegram to get a file from the Internet, or pass “attach://<file_attach_name>”
	 * to upload a new one using multipart/form-data under <file_attach_name> name.
	 * More info on Sending Files
	 */
	@JsonProperty("media")
	val media: String

	/**
	 * Put file to request as multipart explicit
	 */
	@JsonIgnore
	val mediaFile: File?

	/**
	 * Optional. Thumbnail of the file sent; can be ignored if thumbnail generation for the file is supported
	 * server-side. The thumbnail should be in JPEG format and less than 200 kB in size. A thumbnail's
	 * width and height should not exceed 320. Ignored if the file is not uploaded using multipart/form-data.
	 * Thumbnails can't be reused and can be only uploaded as a new file,
	 * so you can pass “attach://<file_attach_name>” if the thumbnail was uploaded using multipart/form-data
	 * under <file_attach_name>.
	 * More info on Sending Files
	 */
	@JsonProperty("thumb")
	val thumb: String?

	/**
	 * Put file to request as multipart explicit
	 */
	@JsonIgnore
	val thumbFile: File?

	init {
		mediaStringOrFile(media).let {
			this.media = it.first as String
			this.mediaFile = it.second
		}
		mediaStringOrFile(thumb).let {
			this.thumb = it.first
			this.thumbFile = it.second
		}
	}

	class InputMediaSerializer : StdSerializer<InputMedia>(InputMedia::class.java) {
		override fun serialize(value: InputMedia, gen: JsonGenerator, provider: SerializerProvider) {
			gen.writeString(jacksonObjectMapper().writeValueAsString(value))
		}
	}

	override fun equals(other: Any?): Boolean {
		if (this === other) return true
		if (other !is InputMedia) return false

		if (type != other.type) return false
		if (caption != other.caption) return false
		if (parseMode != other.parseMode) return false
		if (captionEntities != other.captionEntities) return false
		if (media != other.media) return false
		if (mediaFile != other.mediaFile) return false
		if (thumb != other.thumb) return false
		if (thumbFile != other.thumbFile) return false

		return true
	}

	override fun hashCode(): Int {
		var result = type.hashCode()
		result = 31 * result + (caption?.hashCode() ?: 0)
		result = 31 * result + (parseMode?.hashCode() ?: 0)
		result = 31 * result + (captionEntities?.hashCode() ?: 0)
		result = 31 * result + media.hashCode()
		result = 31 * result + (mediaFile?.hashCode() ?: 0)
		result = 31 * result + (thumb?.hashCode() ?: 0)
		result = 31 * result + (thumbFile?.hashCode() ?: 0)
		return result
	}
}
