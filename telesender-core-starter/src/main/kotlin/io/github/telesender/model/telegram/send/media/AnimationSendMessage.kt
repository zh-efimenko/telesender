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
class AnimationSendMessage @JvmOverloads constructor(

	chatId: Long,
	animation: Any,
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
	animation,
	thumb,
	caption,
	parseMode,
	captionEntities,
	disableNotification,
	replyToMessageId,
	allowSendingWithoutReply,
	replyMarkup
) {

	@JsonProperty("animation")
	fun getAnimation(): String = media

	override fun equals(other: Any?): Boolean {
		if (this === other) return true
		if (other !is AnimationSendMessage) return false
		if (!super.equals(other)) return false

		if (duration != other.duration) return false
		if (width != other.width) return false
		if (height != other.height) return false

		return true
	}

	override fun hashCode(): Int {
		var result = super.hashCode()
		result = 31 * result + (duration ?: 0)
		result = 31 * result + (width ?: 0)
		result = 31 * result + (height ?: 0)
		return result
	}
}
