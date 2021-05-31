package io.github.telesender.model.telegram.send

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * @author Yauheni Yefimenka
 */
data class GetFileMessage(

	/**
	 * File identifier to get info about
	 */
	@get:JsonProperty("file_id")
	val fileId: String

)
