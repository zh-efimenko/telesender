package io.github.telesender.model.telegram.send

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * @author Yauheni Yefimenka
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
data class GetUserProfilePhotosSendMessage @JvmOverloads constructor(

	/**
	 * Unique identifier of the target user
	 */
	@get:JsonProperty("user_id")
	val userId: Long,

	/**
	 * Optional. Sequential number of the first photo to be returned. By default, all photos are returned.
	 */
	@get:JsonProperty("offset")
	val offset: Int? = null,

	/**
	 * Optional. Limits the number of photos to be retrieved. Values between 1-100 are accepted. Defaults to 100.
	 */
	@get:JsonProperty("limit")
	val limit: Int? = null

)
