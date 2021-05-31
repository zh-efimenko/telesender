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
class DocumentSendMessage @JvmOverloads constructor(

	chatId: Long,
	document: Any,

	/**
	 * Optional. Disables automatic server-side content type detection for files uploaded using multipart/form-data
	 */
	@get:JsonProperty("disable_content_type_detection")
	val disableContentTypeDetection: Boolean? = null,

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
	document,
	thumb,
	caption,
	parseMode,
	captionEntities,
	disableNotification,
	replyToMessageId,
	allowSendingWithoutReply,
	replyMarkup
) {

	@JsonProperty("document")
	fun getDocument(): String = media

	override fun equals(other: Any?): Boolean {
		if (this === other) return true
		if (other !is DocumentSendMessage) return false
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
