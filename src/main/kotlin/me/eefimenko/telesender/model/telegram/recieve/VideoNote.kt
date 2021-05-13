package me.eefimenko.telesender.model.telegram.recieve

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * This object represents a video message (available in Telegram apps as of v.4.0).
 *
 * @author Yauheni Yefimenka
 */
data class VideoNote(

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
	 * Video width and height (diameter of the video message) as defined by sender
	 */
	@JsonProperty("length")
	val length: Int,

	/**
	 * Duration of the video in seconds as defined by sender
	 */
	@JsonProperty("duration")
	val duration: Int,

	/**
	 * Optional. Animation thumbnail as defined by sender
	 */
	@JsonProperty("thumb")
	val thumb: PhotoSize? = null,

	/**
	 * Optional. File size
	 */
	@JsonProperty("file_size")
	val fileSize: Int? = null

)
