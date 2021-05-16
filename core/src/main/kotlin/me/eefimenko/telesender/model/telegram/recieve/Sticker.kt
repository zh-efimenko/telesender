package me.eefimenko.telesender.model.telegram.recieve

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * @author Yauheni Yefimenka
 */
data class Sticker(

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
	 * Sticker width
	 */
	@JsonProperty("width")
	val width: Int,

	/**
	 * Sticker height
	 */
	@JsonProperty("height")
	val height: Int,

	/**
	 * True, if the sticker is animated
	 */
	@JsonProperty("is_animated")
	val isAnimated: Boolean,

	/**
	 * Optional. Sticker thumbnail in the .WEBP or .JPG format
	 */
	@JsonProperty("thumb")
	val thumb: PhotoSize? = null,

	/**
	 * Optional. Emoji associated with the sticker
	 */
	@JsonProperty("emoji")
	val emoji: String? = null,

	/**
	 * Optional. Name of the sticker set to which the sticker belongs
	 */
	@JsonProperty("set_name")
	val setName: String? = null,

	/**
	 * Optional. For mask stickers, the position where the mask should be placed
	 */
	@JsonProperty("mask_position")
	val maskPosition: MaskPosition? = null,

	/**
	 * Optional. File size
	 */
	@JsonProperty("file_size")
	val fileSize: Int? = null

)
