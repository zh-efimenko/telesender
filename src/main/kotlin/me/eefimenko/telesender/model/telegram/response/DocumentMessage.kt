package me.eefimenko.telesender.model.telegram.response

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import me.eefimenko.telesender.model.telegram.MessageEntity
import me.eefimenko.telesender.model.telegram.response.dictionary.ParseMode
import me.eefimenko.telesender.model.telegram.response.keyboard.ReplyMarkup
import java.io.File

/**
 * @author Yauheni Yefimenka
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
data class DocumentMessage(

	/**
	 * Unique identifier for the target chat or username of the target channel
	 * (in the format @channelusername)
	 */
	@get:JsonProperty("chat_id")
	val chatId: Long,

	/**
	 * Optional. Document caption (may also be used when resending documents by file_id),
	 * 0-1024 characters after entities parsing
	 */
	@get:JsonProperty("caption")
	val caption: String? = null,

	/**
	 * Optional. Mode for parsing entities in the document caption. See formatting options for more details.
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
	 * File to send. Pass a file_id as String to send a file that exists on the Telegram servers (recommended),
	 * pass an HTTP URL as a String for Telegram to get a file from the Internet, or upload
	 * a new one using multipart/form-data.
	 * More info on Sending Files
	 *
	 * Without @JsonProperty due to Jackson cannot serialize File class
	 *
	 * Type is String or File
	 */
	val document: Any,

	/**
	 * Optional. Thumbnail of the file sent; can be ignored if thumbnail generation for the file is supported
	 * server-side. The thumbnail should be in JPEG format and less than 200 kB in size. A thumbnail's
	 * width and height should not exceed 320. Ignored if the file is not uploaded using multipart/form-data.
	 * Thumbnails can't be reused and can be only uploaded as a new file,
	 * so you can pass “attach://<file_attach_name>” if the thumbnail was uploaded using multipart/form-data
	 * under <file_attach_name>.
	 * More info on Sending Files
	 *
	 * Without @JsonProperty due to Jackson cannot serialize File class
	 *
	 * Type is String or File
	 */
	val thumb: Any? = null,

	/**
	 * Optional. Disables automatic server-side content type detection for files uploaded using multipart/form-data
	 */
	@get:JsonProperty("disable_content_type_detection")
	val disableContentTypeDetection: Boolean? = null,

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

) {

	init {
		require(document !is File || document !is String)
		thumb?.let { require(it !is File || it !is String) }
	}

	fun documentIsFile(): Boolean = document is File

	fun thumbIsFile(): Boolean = thumb is File

}
