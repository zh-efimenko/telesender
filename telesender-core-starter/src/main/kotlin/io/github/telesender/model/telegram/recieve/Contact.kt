package io.github.telesender.model.telegram.recieve

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * @author Yauheni Yefimenka
 */
data class Contact(

	/**
	 * Contact's phone number.
	 */
	@JsonProperty("phone_number")
	val phoneNumber: String,

	/**
	 * 	Contact's first name.
	 */
	@JsonProperty("first_name")
	val firstName: String,

	/**
	 * Optional. Contact's last name.
	 */
	@JsonProperty("last_name")
	val lastName: String? = null,

	/**
	 * Optional. Contact's user identifier in Telegram.
	 */
	@JsonProperty("user_id")
	val userId: Long? = null

)
