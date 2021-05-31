package io.github.telesender.model.telegram.send.media

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import io.github.telesender.model.telegram.common.MessageEntity
import io.github.telesender.model.telegram.send.dictionary.ParseMode
import io.github.telesender.model.telegram.send.keyboard.ReplyMarkup

/**
 * @author Yauheni Yefimenka
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
class AudioSendMessage @JvmOverloads constructor(

	chatId: Long,
	audio: Any,

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
	val title: String? = null,

	thumb: Any? = null,
	caption: String? = null,
	parseMode: ParseMode? = null,
	captionEntities: List<MessageEntity>? = null,
	disableNotification: Boolean? = null,
	replyToMessageId: Long? = null,
	allowSendingWithoutReply: Boolean? = null,
	replyMarkup: ReplyMarkup? = null

) : MediaSendMessage(
	chatId,
	audio,
	thumb,
	caption,
	parseMode,
	captionEntities,
	disableNotification,
	replyToMessageId,
	allowSendingWithoutReply,
	replyMarkup
) {

	@JsonProperty("audio")
	fun getAudio(): String = media

	override fun equals(other: Any?): Boolean {
		if (this === other) return true
		if (other !is AudioSendMessage) return false
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
