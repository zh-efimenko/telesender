package me.eefimenko.telesender.model.telegram.request

import com.fasterxml.jackson.annotation.JsonProperty
import me.eefimenko.telesender.model.telegram.MessageEntity
import me.eefimenko.telesender.model.telegram.response.keyboard.InlineKeyboardMarkup
import java.util.*

/**
 * @author Yauheni Yefimenka
 */
data class Message(

	/**
	 * Unique message identifier inside this chat.
	 */
	@JsonProperty("message_id")
	val messageId: Long,

	/**
	 * Optional. Sender, empty for messages sent to channels.
	 */
	@JsonProperty("from")
	val from: User? = null,

	/**
	 * Optional. Sender of the message, sent on behalf of a chat. The channel itself for channel messages.
	 * The supergroup itself for messages from anonymous group administrators.
	 * The linked channel for messages automatically forwarded to the discussion group.
	 */
	@JsonProperty("sender_chat")
	val senderChat: Chat? = null,

	/**
	 * Date the message was sent in Unix time.
	 */
	@JsonProperty("date")
	val date: Long,

	/**
	 * Conversation the message belongs to.
	 */
	@JsonProperty("chat")
	val chat: Chat,

	/**
	 * Optional. For forwarded messages, sender of the original message.
	 */
	@JsonProperty("forward_from")
	val forwardFrom: User? = null,

	/**
	 * Optional. For messages forwarded from channels or from anonymous administrators,
	 * information about the original sender chat
	 */
	@JsonProperty("forward_from_chat")
	val forwardFromChat: Chat? = null,

	/**
	 * Optional. For messages forwarded from channels, identifier of the original message in the channel
	 */
	@JsonProperty("forward_from_message_id")
	val forwardFromMessageId: Int? = null,

	/**
	 * Optional. For messages forwarded from channels, signature of the post author if present
	 */
	@JsonProperty("forward_signature")
	val forwardSignature: Int? = null,

	/**
	 * Optional. Sender's name for messages forwarded from users who disallow adding a link
	 * to their account in forwarded messages.
	 */
	@JsonProperty("forward_sender_name")
	val forwardSenderName: String? = null,

	/**
	 * Optional. For forwarded messages, date the original message was sent in Unix time.
	 */
	@JsonProperty("forward_date")
	val forwardDate: Long? = null,

	/**
	 * Optional. For replies, the original message. Note that the Message object in this field will not contain
	 * further reply_to_message fields even if it itself is a reply.
	 */
	@JsonProperty("reply_to_message")
	val replyToMessage: Message? = null,

	/**
	 * Optional. Bot through which the message was sent.
	 */
	@JsonProperty("via_bot")
	val viaBot: User? = null,

	/**
	 * Optional. Bot through which the message was sent.
	 */
	@JsonProperty("edit_date")
	val editDate: Long? = null,

	/**
	 * Optional. The unique identifier of a media message group this message belongs to.
	 */
	@JsonProperty("media_group_id")
	val mediaGroupId: String? = null,

	/**
	 * Optional. Signature of the post author for messages in channels, or the custom title of an anonymous
	 * group administrator
	 */
	@JsonProperty("author_signature")
	val authorSignature: String? = null,

	/**
	 * Optional. For text messages, the actual UTF-8 text of the message, 0-4096 characters.
	 */
	@JsonProperty("text")
	val text: String? = null,

	/**
	 * Optional. For text messages, special entities like usernames, URLs, bot commands, etc. that appear in the text
	 */
	@JsonProperty("entities")
	val entities: List<MessageEntity>? = null,

	/**
	 * 	Optional. Message is an animation, information about the animation.
	 * 	For backward compatibility, when this field is set, the document field will also be set
	 */
	@JsonProperty("animation")
	val animation: Animation? = null,

	/**
	 * 	Optional. Message is an audio file, information about the file
	 */
	@JsonProperty("audio")
	val audio: Audio? = null,

	/**
	 * 	Optional. Message is a general file, information about the file
	 */
	@JsonProperty("document")
	val document: Document? = null,

	/**
	 * 	Optional. Message is a photo, available sizes of the photo
	 */
	@JsonProperty("photo")
	val photo: List<PhotoSize>? = null,

	/**
	 * 	Optional. Message is a video, information about the video
	 */
	@JsonProperty("video")
	val video: Video? = null,

	/**
	 * 	Optional. Message is a video note, information about the video message
	 */
	@JsonProperty("video_note")
	val videoNote: VideoNote? = null,

	/**
	 * Optional. Message is a sticker, information about the sticker
	 */
	@JsonProperty("sticker")
	val sticker: Sticker? = null,

	/**
	 * Optional. Message is a voice message, information about the file
	 */
	@JsonProperty("voice")
	val voice: Voice? = null,

	/**
	 * Optional. For messages with a caption, special entities like usernames, URLs,
	 * bot commands, etc. that appear in the caption
	 */
	@JsonProperty("caption_entities")
	val captionEntities: List<MessageEntity>? = null,

	/**
	 * Optional. Message is a shared contact, information about the contact.
	 */
	@JsonProperty("contact")
	val contact: Contact? = null,

	/**
	 * Optional. Message is a dice with random value
	 */
	@JsonProperty("dice")
	val dice: Dice? = null,

	/**
	 * Optional. Message is a game, information about the game.
	 */
	@JsonProperty("game")
	val game: Game? = null,

	/**
	 * Optional. Message is a native poll, information about the poll
	 */
	@JsonProperty("poll")
	val poll: Poll? = null,

	/**
	 * Optional. Message is a venue, information about the venue. For backward compatibility,
	 * when this field is set, the location field will also be set
	 */
	@JsonProperty("venue")
	val venue: Venue? = null,

	/**
	 * Optional. Message is a shared location, information about the location
	 */
	@JsonProperty("location")
	val location: Location? = null,

	/**
	 * Optional. Message is a shared location, information about the location
	 */
	@JsonProperty("new_chat_members")
	val newChatMembers: List<User>? = null,

	/**
	 * Optional. Message is a shared location, information about the location
	 */
	@JsonProperty("left_chat_member")
	val leftChatMember: User? = null,

	/**
	 * Optional. A chat title was changed to this value
	 */
	@JsonProperty("new_chat_title")
	val newChatTitle: String? = null,

	/**
	 * Optional. A chat photo was change to this value
	 */
	@JsonProperty("new_chat_photo")
	val newChatPhoto: List<PhotoSize>? = null,

	/**
	 * Optional. True. Service message: the chat photo was deleted
	 */
	@JsonProperty("delete_chat_photo")
	val deleteChatPhoto: Boolean? = null,

	/**
	 * Optional. True. Service message: the group has been created
	 */
	@JsonProperty("group_chat_created")
	val groupChatCreated: Boolean? = null,

	/**
	 * Optional. True. Service message: the supergroup has been created. This field can't be received
	 * in a message coming through updates, because bot can't be a member of a supergroup when it is created.
	 * It can only be found in reply_to_message if someone replies to a very first message in a directly
	 * created supergroup.
	 */
	@JsonProperty("supergroup_chat_created")
	val supergroupChatCreated: Boolean? = null,

	/**
	 * Optional. True. Service message: the channel has been created. This field can't be received
	 * in a message coming through updates, because bot can't be a member of a channel when it is created.
	 * It can only be found in reply_to_message if someone replies to a very first message in a channel.
	 */
	@JsonProperty("channel_chat_created")
	val channelChatCreated: Boolean? = null,

	/**
	 * Optional. Specified message was pinned. Note that the Message object in this field will
	 * not contain further reply_to_message fields even if it is itself a reply.
	 */
	@JsonProperty("pinned_message")
	val pinnedMessage: Message? = null,

	/**
	 * Optional. Inline keyboard attached to the message.
	 * login_url buttons are represented as ordinary url buttons.
	 */
	@JsonProperty("reply_markup")
	val replyMarkup: List<InlineKeyboardMarkup>? = null

) {

	fun getDate(): Date = Date(date * 1000)

	fun getForwardDate(): Date? = forwardDate?.let { Date(it * 1000) }

	fun getEditDate(): Date? = editDate?.let { Date(it * 1000) }

}
