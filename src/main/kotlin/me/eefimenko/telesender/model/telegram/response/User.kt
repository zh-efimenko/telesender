package me.eefimenko.telesender.model.telegram.response

import com.fasterxml.jackson.annotation.JsonProperty

data class User(

	/**
	 * Unique identifier for this user or bot.
	 */
	@JsonProperty("id")
	val id: Long,

	/**
	 * True, if this user is a bot.
	 */
	@JsonProperty("is_bot")
	val isBot: Boolean,

	/**
	 * User's or bot's first name.
	 */
	@JsonProperty("first_name")
	val firstName: String,

	/**
	 * Optional. User's or bot's last name.
	 */
	@JsonProperty("last_name")
	val lastName: String? = null,

	/**
	 * Optional. User's or bot's username.
	 */
	@JsonProperty("username")
	val username: String? = null,

	/**
	 * Optional. IETF language tag of the user's language.
	 */
	@JsonProperty("language_code")
	val languageCode: String? = null,

	/**
	 * Optional. True, if the bot can be invited to groups. Returned only in getMe.
	 */
	@JsonProperty("can_join_groups")
	val canJoinGroups: Boolean? = null,

	/**
	 * Optional. True, if privacy mode is disabled for the bot. Returned only in getMe.
	 */
	@JsonProperty("can_read_all_group_messages")
	val canReadAllGroupMessages: Boolean? = null,

	/**
	 * Optional. True, if the bot supports inline queries. Returned only in getMe.
	 */
	@JsonProperty("supports_inline_queries")
	val supportsInlineQueries: Boolean? = null

)
