package io.github.telesender.model.telegram.send.media

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import io.github.telesender.model.telegram.send.keyboard.ReplyMarkup

/**
 * @author Yauheni Yefimenka
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
class VideoNoteSendMessage @JvmOverloads constructor(

	chatId: Long,
	videoNote: Any,

	/**
	 * Optional. Duration of the video in seconds
	 */
	@get:JsonProperty("duration")
	val duration: Int? = null,

	/**
	 * Optional. Video width and height, i.e. diameter of the video message
	 */
	@get:JsonProperty("length")
	val length: Int? = null,

	thumb: Any? = null,
	disableNotification: Boolean? = null,
	replyToMessageId: Long? = null,
	allowSendingWithoutReply: Boolean? = null,
	replyMarkup: ReplyMarkup? = null

) : MediaSendMessage(
	chatId,
	videoNote,
	thumb,
	null,
	null,
	null,
	disableNotification,
	replyToMessageId,
	allowSendingWithoutReply,
	replyMarkup
) {

	@JsonProperty("video_note")
	fun getVideoNote(): String = media

	override fun equals(other: Any?): Boolean {
		if (this === other) return true
		if (other !is VideoNoteSendMessage) return false
		if (!super.equals(other)) return false

		if (duration != other.duration) return false
		if (length != other.length) return false

		return true
	}

	override fun hashCode(): Int {
		var result = super.hashCode()
		result = 31 * result + (duration ?: 0)
		result = 31 * result + (length ?: 0)
		return result
	}
}
