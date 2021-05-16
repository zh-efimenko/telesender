package me.eefimenko.telesender.model.telegram.send.media.group

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import me.eefimenko.telesender.model.telegram.common.MessageEntity
import me.eefimenko.telesender.model.telegram.send.dictionary.ParseMode

/**
 * Represents an audio file to be treated as music to be sent.
 *
 * @author Yauheni Yefimenka
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
class InputMediaAudio(
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

) : InputMedia(InputMediaType.AUDIO, media, thumb, caption, parseMode, captionEntities)
