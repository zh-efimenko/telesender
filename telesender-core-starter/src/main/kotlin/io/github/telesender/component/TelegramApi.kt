package io.github.telesender.component

import io.github.telesender.model.telegram.common.BotCommand
import io.github.telesender.model.telegram.recieve.*
import io.github.telesender.model.telegram.send.*
import io.github.telesender.model.telegram.send.inline.AnswerInlineQuery
import io.github.telesender.model.telegram.send.media.*
import io.github.telesender.model.telegram.send.media.group.MediaGroupSendMessage

/**
 * @author Yauheni Yefimenka
 */
interface TelegramApi {

	/**
	 * Send any content message
	 */
	fun send(message: SendMessage?): Any?

	/**
	 * A simple method for testing your bot's auth token. Requires no parameters.
	 * Returns basic information about the bot in form of a User object.
	 */
	fun getMe(): User

	/**
	 * There are two mutually exclusive ways of receiving updates for your bot — the getUpdates method on one hand
	 * and Webhooks on the other. Incoming updates are stored on the server until the bot receives them either way,
	 * but they will not be kept longer than 24 hours.
	 *
	 * Regardless of which option you choose, you will receive JSON-serialized Update objects as a result.
	 */
	fun getUpdates(offset: Long? = null, timeout: Int? = null): List<Update>

	/**
	 * 	Use this method to send text messages. On success, the sent Message is returned.
	 */
	fun sendMessage(message: TextSendMessage): Message

	/**
	 * Use this method to copy messages of any kind. Service messages and invoice messages can't be copied.
	 * The method is analogous to the method forwardMessage, but the copied message doesn't have a link
	 * to the original message. Returns the MessageId of the sent message on success.
	 */
	fun copyMessage(message: CopySendMessage): MessageId

	/**
	 * Use this method to forward messages of any kind. Service messages can't be forwarded.
	 * On success, the sent Message is returned.
	 */
	fun forwardMessage(message: ForwardSendMessage): Message

	/**
	 * Use this method to copy messages of any kind. Service messages and invoice messages can't be copied.
	 * The method is analogous to the method forwardMessage, but the copied message doesn't have a link
	 * to the original message. Returns the MessageId of the sent message on success.
	 */
	fun sendPhoto(message: PhotoSendMessage): Message

	/**
	 * Use this method to send audio files, if you want Telegram clients to display them in the music player.
	 * Your audio must be in the .MP3 or .M4A format. On success, the sent Message is returned.
	 * Bots can currently send audio files of up to 50 MB in size, this limit may be changed in the future.
	 * For sending voice messages, use the sendVoice method instead.
	 */
	fun sendAudio(message: AudioSendMessage): Message

	/**
	 * Use this method to send general files. On success, the sent Message is returned.
	 * Bots can currently send files of any type of up to 50 MB in size, this limit may be changed in the future.
	 */
	fun sendDocument(message: DocumentSendMessage): Message

	/**
	 * Use this method to send video files, Telegram clients support mp4 videos
	 * (other formats may be sent as Document). On success, the sent Message is returned.
	 * Bots can currently send video files of up to 50 MB in size, this limit may be changed in the future.
	 */
	fun sendVideo(message: VideoSendMessage): Message

	/**
	 * Use this method to send animation files (GIF or H.264/MPEG-4 AVC video without sound).
	 * On success, the sent Message is returned. Bots can currently send animation files of up to 50 MB in size,
	 * this limit may be changed in the future.
	 */
	fun sendAnimation(message: AnimationSendMessage): Message

	/**
	 * Use this method to send audio files, if you want Telegram clients to display the file as a playable
	 * voice message. For this to work, your audio must be in an .OGG file encoded with OPUS
	 * (other formats may be sent as Audio or Document). On success, the sent Message is returned.
	 * Bots can currently send voice messages of up to 50 MB in size, this limit may be changed in the future.
	 */
	fun sendVoice(message: VoiceSendMessage): Message

	/**
	 * As of v.4.0, Telegram clients support rounded square mp4 videos of up to 1 minute long.
	 * Use this method to send video messages. On success, the sent Message is returned.
	 */
	fun sendVideoNote(message: VideoNoteSendMessage): Message

	/**
	 * Use this method to send a group of photos, videos, documents or audios as an album.
	 * Documents and audio files can be only grouped in an album with messages of the same type.
	 * On success, an array of Messages that were sent is returned.
	 */
	fun sendMediaGroup(message: MediaGroupSendMessage): List<Message>

	/**
	 * Use this method to send point on the map. On success, the sent Message is returned.
	 */
	fun sendLocation(message: LocationSendMessage): Message

	/**
	 * Use this method to send information about a venue. On success, the sent Message is returned.
	 */
	fun sendVenue(message: VenueSendMessage): Message

	/**
	 * Use this method to send phone contacts. On success, the sent Message is returned.
	 */
	fun sendContact(message: ContactSendMessage): Message

	/**
	 * Use this method to send a native poll. On success, the sent Message is returned.
	 */
	fun sendPoll(message: PollSendMessage): Message

	/**
	 * Use this method to get a list of profile pictures for a user. Returns a UserProfilePhotos object.
	 */
	fun getUserProfilePhotos(message: GetUserProfilePhotosSendMessage): UserProfilePhotos

	/**
	 * Use this method to delete a message, including service messages, with the following limitations:
	 * - A message can only be deleted if it was sent less than 48 hours ago.
	 * - A dice message in a private chat can only be deleted if it was sent more than 24 hours ago.
	 * - Bots can delete outgoing messages in private chats, groups, and supergroups.
	 * - Bots can delete incoming messages in private chats.
	 * - Bots granted can_post_messages permissions can delete outgoing messages in channels.
	 * - If the bot is an administrator of a group, it can delete any message there.
	 * - If the bot has can_delete_messages permission in a supergroup or a channel, it can delete any message there.
	 * Returns True on success.
	 */
	fun deleteMessage(message: DeleteMessage): Boolean

	/**
	 * Use this method to send answers to callback queries sent from inline keyboards.
	 * The answer will be displayed to the user as a notification at the top of the chat screen or as an alert.
	 * On success, True is returned.
	 */
	fun answerInlineQuery(query: AnswerInlineQuery): Boolean

	/**
	 * Use this method to change the list of the bot's commands. Returns True on success.
	 */
	fun setMyCommands(message: SetMyCommandsMessage): Boolean

	/**
	 * Use this method to get the current list of the bot's commands. Requires no parameters.
	 * Returns Array of BotCommand on success.
	 */
	fun getMyCommands(): List<BotCommand>

	/**
	 * Use this method to get basic info about a file and prepare it for downloading.
	 * For the moment, bots can download files of up to 20MB in size. On success,
	 * a File object is returned.
	 * The file can then be downloaded via the link https://api.telegram.org/file/bot<token>/<file_path>,
	 * where <file_path> is taken from the response. It is guaranteed that the link will be valid
	 * for at least 1 hour. When the link expires, a new one can be requested by calling getFile again.
	 */
	fun getFile(message: GetFileMessage): File

}
