package io.github.telesender.model.telegram.recieve

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * This object represents a file ready to be downloaded.
 * The file can be downloaded via the link https://api.telegram.org/file/bot<token>/<file_path>.
 * It is guaranteed that the link will be valid for at least 1 hour.
 * When the link expires, a new one can be requested by calling getFile.
 *
 * @author Yauheni Yefimenka
 */
data class File(

	/**
	 * Identifier for this file, which can be used to download or reuse the file
	 */
	@JsonProperty("file_id")
	val fileId: String,

	/**
	 * Unique identifier for this file, which is supposed to be the same over time
	 * and for different bots. Can't be used to download or reuse the file.
	 */
	@JsonProperty("file_unique_id")
	val fileUniqueId: String,

	/**
	 * Optional. File size, if known
	 */
	@JsonProperty("file_size")
	val fileSize: Int? = null,

	/**
	 * Optional. File path. Use https://api.telegram.org/file/bot<token>/<file_path> to get the file.
	 */
	@JsonProperty("file_path")
	val filePath: String? = null

)
