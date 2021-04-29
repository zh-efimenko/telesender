package me.eefimenko.telesender.model.telegram.request

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * This object represents one size of a photo or a file / sticker thumbnail.
 */
data class PhotoSize(

	/**
	 * Identifier for this file, which can be used to download or reuse the file
	 */
	@JsonProperty("file_id")
	val fileId: String,

	/**
	 * 	Unique identifier for this file, which is supposed to be the same over time and for different bots.
	 * 	Can't be used to download or reuse the file.
	 */
	@JsonProperty("file_unique_id")
	val fileUniqueId: String,

	/**
	 * Photo width
	 */
	@JsonProperty("width")
	val width: Int,

	/**
	 * Photo height
	 */
	@JsonProperty("height")
	val height: Int,

	/**
	 * Optional. File size
	 */
	@JsonProperty("file_size")
	val fileSize: Int? = null

)
