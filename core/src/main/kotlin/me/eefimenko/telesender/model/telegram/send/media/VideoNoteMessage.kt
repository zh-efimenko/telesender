package me.eefimenko.telesender.model.telegram.send.media

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import me.eefimenko.telesender.model.telegram.send.keyboard.ReplyMarkup

/**
 * @author Yauheni Yefimenka
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
class VideoNoteMessage(

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

) : Media(
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

}
