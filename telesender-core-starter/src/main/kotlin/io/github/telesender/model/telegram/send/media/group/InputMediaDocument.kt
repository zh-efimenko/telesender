package io.github.telesender.model.telegram.send.media.group

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import io.github.telesender.model.telegram.common.MessageEntity
import io.github.telesender.model.telegram.send.dictionary.ParseMode
import java.io.File

/**
 * Represents a general file to be sent.
 *
 * @author Yauheni Yefimenka
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
class InputMediaDocument @JvmOverloads constructor(
	media: File,
	thumb: Any? = null,
	caption: String? = null,
	parseMode: ParseMode? = null,
	captionEntities: List<MessageEntity>? = null,

	/**
	 * Optional. Disables automatic server-side content type detection for files uploaded using multipart/form-data
	 */
	@get:JsonProperty("disable_content_type_detection")
	val disableContentTypeDetection: Boolean? = null

) : InputMedia(InputMediaType.DOCUMENT, media, thumb, caption, parseMode, captionEntities) {

	override fun equals(other: Any?): Boolean {
		if (this === other) return true
		if (other !is InputMediaDocument) return false
		if (!super.equals(other)) return false

		if (disableContentTypeDetection != other.disableContentTypeDetection) return false

		return true
	}

	override fun hashCode(): Int {
		var result = super.hashCode()
		result = 31 * result + (disableContentTypeDetection?.hashCode() ?: 0)
		return result
	}
}
