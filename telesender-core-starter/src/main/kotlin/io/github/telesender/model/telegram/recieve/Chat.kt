package io.github.telesender.model.telegram.recieve

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * @author Yauheni Yefimenka
 */
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
	val inviteLink: String? = null,

	/**
	 * Optional. The most recent pinned message (by sending date). Returned only in getChat.
	 */
	@JsonProperty("pinned_message")
	val pinnedMessage: Message? = null,

	/**
	 * Optional. The most recent pinned message (by sending date). Returned only in getChat.
	 */
	@JsonProperty("permissions")
	val permissions: ChatPermissions? = null,

	/**
	 * Optional. The time after which all messages sent to the chat will be automatically deleted;
	 * in seconds. Returned only in getChat.
	 */
	@JsonProperty("slow_mode_delay")
	val slowModeDelay: Int? = null,

	/**
	 * Optional. For supergroups, name of group sticker set. Returned only in getChat.
	 */
	@JsonProperty("sticker_set_name")
	val stickerSetName: String? = null,

	/**
	 * Optional. True, if the bot can change the group sticker set. Returned only in getChat.
	 */
	@JsonProperty("can_set_sticker_set")
	val canSetStickerSet: Boolean? = null,

	/**
	 * Optional. Unique identifier for the linked chat, i.e. the discussion group identifier for a channel
	 * and vice versa; for supergroups and channel chats. This identifier may be greater than 32 bits
	 * and some programming languages may have difficulty/silent defects in interpreting it.
	 * But it is smaller than 52 bits, so a signed 64 bit integer or double-precision float type are safe
	 * for storing this identifier. Returned only in getChat.
	 */
	@JsonProperty("linked_chat_id")
	val linkedChatId: Int? = null,

	/**
	 * Optional. For supergroups, the location to which the supergroup is connected. Returned only in getChat.
	 */
	@JsonProperty("location")
	val location: ChatLocation? = null

)
