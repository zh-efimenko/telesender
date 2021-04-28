package me.eefimenko.telesender.model.telegram.request

import com.fasterxml.jackson.annotation.JsonProperty

data class Chat(

	/**
	 * Unique identifier for this chat. This number may be greater than 32 bits and some programming languages
	 * may have difficulty/silent defects in interpreting it. But it is smaller than 52 bits,
	 * so a signed 64 bit integer or double-precision float type are safe for storing this identifier.
	 */
	@JsonProperty("id")
	val id: Long,

	/**
	 * Type of chat, can be either “private”, “group”, “supergroup” or “channel”.
	 */
	@JsonProperty("type")
	val type: String,

	/**
	 * Optional. Title, for supergroups, channels and group chats.
	 */
	@JsonProperty("title")
	val title: String? = null,

	/**
	 * Optional. Username, for private chats, supergroups and channels if available.
	 */
	@JsonProperty("username")
	val username: String? = null,

	/**
	 * Optional. First name of the other party in a private chat.
	 */
	@JsonProperty("first_name")
	val firstName: String? = null,

	/**
	 * Optional. Last name of the other party in a private chat.
	 */
	@JsonProperty("last_name")
	val lastName: String? = null,

	/**
	 * Optional. Bio of the other party in a private chat. Returned only in getChat.
	 */
	@JsonProperty("bio")
	val bio: String? = null,

	/**
	 * Optional. Description, for groups, supergroups and channel chats. Returned only in getChat.
	 */
	@JsonProperty("description")
	val description: String? = null,

	/**
	 * Optional. Chat invite link, for groups, supergroups and channel chats.
	 * Each administrator in a chat generates their own invite links, so the bot must first generate
	 * the link using exportChatInviteLink. Returned only in getChat.
	 */
	@JsonProperty("invite_link")
	val inviteLink: String? = null

)
