package me.eefimenko.telesender.model.telegram.send.media

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import me.eefimenko.telesender.model.telegram.common.MessageEntity
import me.eefimenko.telesender.model.telegram.send.dictionary.ParseMode
import me.eefimenko.telesender.model.telegram.send.keyboard.ReplyMarkup

/**
 * @author Yauheni Yefimenka
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
class VideoMessage(

	chatId: Long,
	video: Any,

	/**
	 * Optional. Duration of the video in seconds
	 */
	@get:JsonProperty("duration")
	val duration: Int? = null,

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
	 * Optional. Pass True, if the uploaded video is suitable for streaming
	 */
	@get:JsonProperty("supports_streaming")
	val supportsStreaming: Boolean? = null,

	thumb: Any? = null,
	caption: String? = null,
	parseMode: ParseMode? = null,
	captionEntities: List<MessageEntity>? = null,
	disableNotification: Boolean? = null,
	replyToMessageId: Long? = null,
	allowSendingWithoutReply: Boolean? = null,
	replyMarkup: ReplyMarkup? = null

) : Media(
	chatId,
	video,
	thumb,
	caption,
	parseMode,
	captionEntities,
	disableNotification,
	replyToMessageId,
	allowSendingWithoutReply,
	replyMarkup
) {

	@JsonProperty("video")
	fun getVideo(): String = media

}
