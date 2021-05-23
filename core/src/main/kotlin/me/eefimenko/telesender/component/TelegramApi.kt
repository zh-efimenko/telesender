package me.eefimenko.telesender.component

import me.eefimenko.telesender.model.telegram.recieve.*
import me.eefimenko.telesender.model.telegram.send.*
import me.eefimenko.telesender.model.telegram.send.inline.AnswerInlineQuery
import me.eefimenko.telesender.model.telegram.send.media.*
import me.eefimenko.telesender.model.telegram.send.media.group.MediaGroupSendMessage

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
	 * Use this method to send answers to callback queries sent from inline keyboards.
	 * The answer will be displayed to the user as a notification at the top of the chat screen or as an alert.
	 * On success, True is returned.
	 */
	fun answerInlineQuery(query: AnswerInlineQuery): Boolean

}
