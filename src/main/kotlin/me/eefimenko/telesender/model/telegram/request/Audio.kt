package me.eefimenko.telesender.model.telegram.request

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * This object represents an audio file to be treated as music by the Telegram clients.
 */
data class Audio(

	/**
	 * Identifier for this file, which can be used to download or reuse the file
	 */
	@JsonProperty("file_id")
	val fileId: String,

	/**
	 * Unique identifier for this file, which is supposed to be the same over time and for different bots.
	 * Can't be used to download or reuse the file.
	 */
	@JsonProperty("file_unique_id")
	val fileUniqueId: String,

	/**
	 * Duration of the audio in seconds as defined by sender
	 */
	@JsonProperty("duration")
	val duration: Int,

	/**
	 * Optional. Performer of the audio as defined by sender or by audio tags
	 */
	@JsonProperty("performer")
	val performer: String? = null,

	/**
	 * Optional. Title of the audio as defined by sender or by audio tags
	 */
	@JsonProperty("title")
	val title: String? = null,

	/**
	 * Optional. Original filename as defined by sender
	 */
	@JsonProperty("file_name")
	val fileName: String? = null,

	/**
	 * Optional. MIME type of the file as defined by sender
	 */
	@JsonProperty("mime_type")
	val mimeType: String? = null,

	/**
	 * Optional. File size
	 */
	@JsonProperty("file_size")
	val fileSize: Int? = null,

	/**
	 * Optional. Thumbnail of the album cover to which the music file belongs
	 */
	@JsonProperty("thumb")
	val thumb: PhotoSize? = null

)
