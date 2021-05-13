package me.eefimenko.telesender.model.telegram.recieve

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * This object represents a voice note.
 *
 * @author Yauheni Yefimenka
 */
data class Voice(

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
	 * Optional. MIME type of the file as defined by sender
	 */
	@JsonProperty("mime_type")
	val mimeType: String? = null,

	/**
	 * Optional. File size
	 */
	@JsonProperty("file_size")
	val fileSize: Int? = null

)
