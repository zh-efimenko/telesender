package io.github.telesender.model.telegram.send.media

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import io.github.telesender.model.telegram.common.MessageEntity
import io.github.telesender.model.telegram.send.SendMessage
import io.github.telesender.model.telegram.send.dictionary.ParseMode
import io.github.telesender.model.telegram.send.keyboard.ReplyMarkup
import io.github.telesender.model.telegram.send.util.mediaStringOrFile
import java.io.File

/**
 * @author Yauheni Yefimenka
 */
abstract class MediaSendMessage @JvmOverloads constructor(

	/**
	 * Unique identifier for the target chat or username of the target channel
	 * (in the format @channelusername)
	 */
	@get:JsonProperty("chat_id")
	val chatId: Long,

	media: Any,
	thumb: Any? = null,

	/**
	 * Optional. Caption, 0-1024 characters after entities parsing
	 */
	@get:JsonProperty("caption")
	val caption: String? = null,

	/**
	 * Optional. Mode for parsing entities in the caption. See formatting options for more details.
	 */
	@get:JsonProperty("parse_mode")
	@get:JsonSerialize(using = ParseMode.ParseModeSerializer::class)
	val parseMode: ParseMode? = null,

	/**
	 * Optional. List of special entities that appear in the new caption, which can be specified instead
	 * of parse_mode
	 */
	@get:JsonProperty("caption_entities")
	val captionEntities: List<MessageEntity>? = null,

	/**
	 * Optional. Sends the message silently. Users will receive a notification with no sound.
	 */
	@get:JsonProperty("disable_notification")
	val disableNotification: Boolean? = null,

	/**
	 * Optional. If the message is a reply, ID of the original message
	 */
	@get:JsonProperty("reply_to_message_id")
	val replyToMessageId: Long? = null,

	/**
	 * Optional. Pass True, if the message should be sent even if the specified replied-to message is not found
	 */
	@get:JsonProperty("allow_sending_without_reply")
	val allowSendingWithoutReply: Boolean? = null,

	/**
	 * Optional. Additional interface options. A JSON-serialized object for an inline keyboard,
	 * custom reply keyboard, instructions to remove reply keyboard or to force a reply from the user.
	 */
	@get:JsonProperty("reply_markup")
	val replyMarkup: ReplyMarkup? = null

) : SendMessage {

	/**
	 * Media to send. Pass a file_id as String to send a video that exists on the Telegram servers (recommended),
	 * pass an HTTP URL as a String for Telegram to get a video from the Internet, or upload a new video
	 * using multipart/form-data.
	 * More info on Sending Files
	 */
	@JsonIgnore
	protected val media: String

	/**
	 * Put file to request as multipart explicit
	 */
	@JsonIgnore
	val mediaFile: File?

	/**
	 * Optional. Thumbnail of the file sent; can be ignored if thumbnail generation for the file is supported
	 * server-side. The thumbnail should be in JPEG format and less than 200 kB in size. A thumbnail's
	 * width and height should not exceed 320. Ignored if the file is not uploaded using multipart/form-data.
	 * Thumbnails can't be reused and can be only uploaded as a new file,
	 * so you can pass “attach://<file_attach_name>” if the thumbnail was uploaded using multipart/form-data
	 * under <file_attach_name>.
	 * More info on Sending Files
	 */
	@JsonProperty("thumb")
	val thumb: String?

	/**
	 * Put file to request as multipart explicit
	 */
	@JsonIgnore
	val thumbFile: File?

	init {
		mediaStringOrFile(media).let {
			this.media = it.first as String
			this.mediaFile = it.second
		}
		mediaStringOrFile(thumb).let {
			this.thumb = it.first
			this.thumbFile = it.second
		}
	}

	override fun equals(other: Any?): Boolean {
		if (this === other) return true
		if (other !is MediaSendMessage) return false

		if (chatId != other.chatId) return false
		if (caption != other.caption) return false
		if (parseMode != other.parseMode) return false
		if (captionEntities != other.captionEntities) return false
		if (disableNotification != other.disableNotification) return false
		if (replyToMessageId != other.replyToMessageId) return false
		if (allowSendingWithoutReply != other.allowSendingWithoutReply) return false
		if (replyMarkup != other.replyMarkup) return false
		if (media != other.media) return false
		if (mediaFile != other.mediaFile) return false
		if (thumb != other.thumb) return false
		if (thumbFile != other.thumbFile) return false

		return true
	}

	override fun hashCode(): Int {
		var result = chatId.hashCode()
		result = 31 * result + (caption?.hashCode() ?: 0)
		result = 31 * result + (parseMode?.hashCode() ?: 0)
		result = 31 * result + (captionEntities?.hashCode() ?: 0)
		result = 31 * result + (disableNotification?.hashCode() ?: 0)
		result = 31 * result + (replyToMessageId?.hashCode() ?: 0)
		result = 31 * result + (allowSendingWithoutReply?.hashCode() ?: 0)
		result = 31 * result + (replyMarkup?.hashCode() ?: 0)
		result = 31 * result + media.hashCode()
		result = 31 * result + (mediaFile?.hashCode() ?: 0)
		result = 31 * result + (thumb?.hashCode() ?: 0)
		result = 31 * result + (thumbFile?.hashCode() ?: 0)
		return result
	}
}
