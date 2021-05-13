package me.eefimenko.telesender.model.telegram.send

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import me.eefimenko.telesender.model.telegram.common.MessageEntity
import me.eefimenko.telesender.model.telegram.send.dictionary.ParseMode
import me.eefimenko.telesender.model.telegram.send.keyboard.ReplyMarkup

/**
 * @author Yauheni Yefimenka
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
class CopyMessage(

	/**
	 * Unique identifier for the target chat or username of the target channel
	 * (in the format @channelusername)
	 */
	@get:JsonProperty("chat_id")
	val chatId: Long,

	/**
	 * Unique identifier for the chat where the original message was sent
	 * (or channel username in the format @channelusername)
	 */
	@get:JsonProperty("from_chat_id")
	val fromChatId: Long,

	/**
	 * Message identifier in the chat specified in from_chat_id
	 */
	@get:JsonProperty("message_id")
	val message_id: Long,

	/**
	 * Optional. New caption for media, 0-1024 characters after entities parsing.
	 * If not specified, the original caption is kept
	 */
	@get:JsonProperty("caption")
	val caption: String? = null,

	/**
	 * Optional. Mode for parsing entities in the new caption. See formatting options for more details.
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

)
