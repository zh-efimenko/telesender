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
class VoiceMessage(

	chatId: Long,
	voice: Any,

	/**
	 * Optional. Duration of the audio in seconds
	 */
	@get:JsonProperty("duration")
	val duration: Int? = null,

	caption: String? = null,
	parseMode: ParseMode? = null,
	captionEntities: List<MessageEntity>? = null,
	disableNotification: Boolean? = null,
	replyToMessageId: Long? = null,
	allowSendingWithoutReply: Boolean? = null,
	replyMarkup: ReplyMarkup? = null

) : Media(
	chatId,
	voice,
	null,
	caption,
	parseMode,
	captionEntities,
	disableNotification,
	replyToMessageId,
	allowSendingWithoutReply,
	replyMarkup
) {

	@JsonProperty("voice")
	fun getVoice(): String = media

}
