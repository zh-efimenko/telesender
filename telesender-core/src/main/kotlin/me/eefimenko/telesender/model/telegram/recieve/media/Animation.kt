package me.eefimenko.telesender.model.telegram.recieve.media

import com.fasterxml.jackson.annotation.JsonProperty
import me.eefimenko.telesender.model.telegram.recieve.PhotoSize

/**
 * This object represents an animation file (GIF or H.264/MPEG-4 AVC video without sound).
 *
 * @author Yauheni Yefimenka
 */
data class Animation(

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
	 * Video width as defined by sender
	 */
	@JsonProperty("width")
	val width: Int,

	/**
	 * Video height as defined by sender
	 */
	@JsonProperty("height")
	val height: Int,

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
	 * Optional. Original animation filename as defined by sender
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
