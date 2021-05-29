package io.github.telesender.model.telegram.recieve.media

import com.fasterxml.jackson.annotation.JsonProperty
import io.github.telesender.model.telegram.recieve.PhotoSize

/**
 * This object represents a general file (as opposed to photos, voice messages and audio files).
 *
 * @author Yauheni Yefimenka
 */
data class Document(

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
	 * Optional. Document thumbnail as defined by sender
	 */
	@JsonProperty("thumb")
	val thumb: PhotoSize? = null,

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
	val fileSize: Int? = null
)
