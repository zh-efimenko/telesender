package io.github.telesender.model.telegram.recieve

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Describes actions that a non-administrator user is allowed to take in a chat.
 *
 * @author Yauheni Yefimenka
 */
data class ChatPermissions(

	/**
	 * Optional. True, if the user is allowed to send text messages, contacts, locations and venues
	 */
	@JsonProperty("can_send_messages")
	val canSendMessages: Boolean?,


	/**
	 * Optional. True, if the user is allowed to send audios, documents, photos, videos, video notes and voice notes,
	 * implies can_send_messages
	 */
	@JsonProperty("can_send_media_messages")
	val canSendMediaMessages: Boolean?,


	/**
	 * Optional. True, if the user is allowed to send polls, implies can_send_messages
	 */
	@JsonProperty("can_send_polls")
	val canSendPolls: Boolean?,


	/**
	 * Optional. True, if the user is allowed to send animations, games, stickers and use inline bots,
	 * implies can_send_media_messages
	 */
	@JsonProperty("can_send_other_messages")
	val canSendOtherMessages: Boolean?,


	/**
	 * Optional. True, if the user is allowed to add web page previews to their messages,
	 * implies can_send_media_messages
	 */
	@JsonProperty("can_add_web_page_previews")
	val canAddWebPagePreviews: Boolean?,


	/**
	 * Optional. True, if the user is allowed to change the chat title, photo and other settings.
	 * Ignored in public supergroups
	 */
	@JsonProperty("can_change_info")
	val canChangeInfo: Boolean?,

	/**
	 * Optional. True, if the user is allowed to invite new users to the chat
	 */
	@JsonProperty("can_invite_users")
	val canInviteUsers: Boolean?,

	/**
	 * Optional. True, if the user is allowed to pin messages. Ignored in public supergroups
	 */
	@JsonProperty("can_pin_messages")
	val canPinMessages: Boolean?
)
