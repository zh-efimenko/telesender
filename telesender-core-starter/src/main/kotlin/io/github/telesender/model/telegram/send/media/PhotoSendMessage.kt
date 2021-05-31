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
class PhotoSendMessage @JvmOverloads constructor(

	chatId: Long,
	photo: Any,
	caption: String? = null,
	parseMode: ParseMode? = null,
	captionEntities: List<MessageEntity>? = null,
	disableNotification: Boolean? = null,
	replyToMessageId: Long? = null,
	allowSendingWithoutReply: Boolean? = null,
	replyMarkup: ReplyMarkup? = null

) : MediaSendMessage(
	chatId,
	photo,
	null,
	caption,
	parseMode,
	captionEntities,
	disableNotification,
	replyToMessageId,
	allowSendingWithoutReply,
	replyMarkup
) {

	@JsonProperty("photo")
	fun getPhoto(): String = media

	override fun equals(other: Any?): Boolean {
		if (this === other) return true
		if (other !is PhotoSendMessage) return false
		if (!super.equals(other)) return false
		return true
	}

	override fun hashCode(): Int {
		return super.hashCode()
	}

}
