package io.github.telesender.model.telegram.common

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import io.github.telesender.model.telegram.recieve.User

/**
 * @author Yauheni Yefimenka
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
data class MessageEntity @JvmOverloads constructor(

	/**
	 * Type of the entity. Can be “mention” (@username), “hashtag” (#hashtag), “cashtag” ($USD),
	 * “bot_command” (/start@jobs_bot), “url” (https://telegram.org), “email” (do-not-reply@telegram.org),
	 * “phone_number” (+1-212-555-0123), “bold” (bold text), “italic” (italic text),
	 * “underline” (underlined text), “strikethrough” (strikethrough text), “code” (monowidth string),
	 * “pre” (monowidth block), “text_link” (for clickable text URLs), “text_mention” (for users without usernames).
	 */
	@get:JsonProperty("type")
	val type: String,

	/**
	 * Offset in UTF-16 code units to the start of the entity.
	 */
	@get:JsonProperty("offset")
	val offset: Int,

	/**
	 * Length of the entity in UTF-16 code units.
	 */
	@get:JsonProperty("length")
	val length: Int,

	/**
	 * Optional. For “text_link” only, url that will be opened after user taps on the text.
	 */
	@get:JsonProperty("url")
	val url: String? = null,

	/**
	 * Optional. For “text_mention” only, the mentioned user.
	 */
	@get:JsonProperty("user")
	val user: User? = null,

	/**
	 * Optional. For “pre” only, the programming language of the entity text.
	 */
	@get:JsonProperty("language")
	val language: String? = null

) {

	companion object {
		@JvmStatic
		@JsonCreator
		fun of(
			@JsonProperty("type")
			type: String,
			@JsonProperty("offset")
			offset: Int,
			@JsonProperty("length")
			length: Int,
			@JsonProperty("url")
			url: String? = null,
			@JsonProperty("user")
			user: User? = null,
			@JsonProperty("language")
			language: String? = null
		): MessageEntity = MessageEntity(type, offset, length, url, user, language)
	}

}
