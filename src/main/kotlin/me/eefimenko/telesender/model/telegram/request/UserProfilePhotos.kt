package me.eefimenko.telesender.model.telegram.request

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * This object represent a user's profile pictures.
 *
 * @author Yauheni Yefimenka
 */
data class UserProfilePhotos(

	/**
	 * Total number of profile pictures the target user has
	 */
	@JsonProperty("total_count")
	val total_count: Int,

	/**
	 * 	Requested profile pictures (in up to 4 sizes each)
	 */
	@JsonProperty("photos")
	val photos: List<List<PhotoSize>>

)
