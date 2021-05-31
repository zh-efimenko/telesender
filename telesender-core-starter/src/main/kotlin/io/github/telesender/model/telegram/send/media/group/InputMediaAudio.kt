package io.github.telesender.model.telegram.send.media.group

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import io.github.telesender.model.telegram.common.MessageEntity
import io.github.telesender.model.telegram.send.dictionary.ParseMode

/**
 * Represents an audio file to be treated as music to be sent.
 *
 * @author Yauheni Yefimenka
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
class InputMediaAudio @JvmOverloads constructor(
	media: Any,
	thumb: Any? = null,
	caption: String? = null,
	parseMode: ParseMode? = null,
	captionEntities: List<MessageEntity>? = null,

	/**
	 * Optional. Duration of the audio in seconds
	 */
	@get:JsonProperty("duration")
	val duration: Int? = null,

	/**
	 * Optional. Performer
	 */
	@get:JsonProperty("performer")
	val performer: String? = null,

	/**
	 * Optional. Track name
	 */
	@get:JsonProperty("title")
	val title: String? = null

) : InputMedia(InputMediaType.AUDIO, media, thumb, caption, parseMode, captionEntities) {

	override fun equals(other: Any?): Boolean {
		if (this === other) return true
		if (other !is InputMediaAudio) return false
		if (!super.equals(other)) return false

		if (duration != other.duration) return false
		if (performer != other.performer) return false
		if (title != other.title) return false

		return true
	}

	override fun hashCode(): Int {
		var result = super.hashCode()
		result = 31 * result + (duration ?: 0)
		result = 31 * result + (performer?.hashCode() ?: 0)
		result = 31 * result + (title?.hashCode() ?: 0)
		return result
	}
}
