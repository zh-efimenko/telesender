package io.github.telesender.model.telegram.send.media.group

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import io.github.telesender.model.telegram.common.MessageEntity
import io.github.telesender.model.telegram.send.dictionary.ParseMode
import java.io.File

/**
 * Represents a video to be sent.
 *
 * @author Yauheni Yefimenka
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
class InputMediaVideo @JvmOverloads constructor(
	media: File,
	thumb: Any? = null,
	caption: String? = null,
	parseMode: ParseMode? = null,
	captionEntities: List<MessageEntity>? = null,

	/**
	 * Optional. Video width
	 */
	@get:JsonProperty("width")
	val width: Int? = null,

	/**
	 * Optional. Video height
	 */
	@get:JsonProperty("height")
	val height: Int? = null,

	/**
	 * Optional. Duration of the video in seconds
	 */
	@get:JsonProperty("duration")
	val duration: Int? = null,

	/**
	 * Optional. Pass True, if the uploaded video is suitable for streaming
	 */
	@get:JsonProperty("supports_streaming")
	val supportsStreaming: Boolean? = null

) : InputMedia(InputMediaType.VIDEO, media, thumb, caption, parseMode, captionEntities) {

	override fun equals(other: Any?): Boolean {
		if (this === other) return true
		if (other !is InputMediaVideo) return false
		if (!super.equals(other)) return false

		if (width != other.width) return false
		if (height != other.height) return false
		if (duration != other.duration) return false
		if (supportsStreaming != other.supportsStreaming) return false

		return true
	}

	override fun hashCode(): Int {
		var result = super.hashCode()
		result = 31 * result + (width ?: 0)
		result = 31 * result + (height ?: 0)
		result = 31 * result + (duration ?: 0)
		result = 31 * result + (supportsStreaming?.hashCode() ?: 0)
		return result
	}
}
