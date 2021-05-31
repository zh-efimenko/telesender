package io.github.telesender.model.telegram.send.keyboard

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * This object represents one button of an inline keyboard. You must use exactly one of the optional fields.
 *
 * @author Yauheni Yefimenka
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
class InlineKeyboardButton @JvmOverloads constructor(

	/**
	 * Label text on the button
	 */
	@get:JsonProperty("text")
	val text: String,

	/**
	 * 	Optional. HTTP or tg:// url to be opened when button is pressed
	 */
	@get:JsonProperty("url")
	val url: String? = null,

	/**
	 * Optional. Data to be sent in a callback query to the bot when button is pressed, 1-64 bytes.
	 */
	@get:JsonProperty("callback_data")
	val callback_data: String? = null,

	/**
	 * Optional. If set, pressing the button will prompt the user to select one of their chats,
	 * open that chat and insert the bot's username and the specified inline query in the input field.
	 * Can be empty, in which case just the bot's username will be inserted.
	 * Note: This offers an easy way for users to start using your bot in inline mode when they are
	 * currently in a private chat with it. Especially useful when combined with switch_pm… actions – in this case
	 * the user will be automatically returned to the chat they switched from, skipping the chat selection screen.
	 */
	@get:JsonProperty("switch_inline_query")
	val switch_inline_query: String? = null,

	/**
	 * Optional. If set, pressing the button will insert the bot's username and the specified inline query
	 * in the current chat's input field. Can be empty, in which case only the bot's username will be inserted.
	 * This offers a quick way for the user to open your bot in inline mode in the same chat – good for selecting
	 * something from multiple options.
	 */
	@get:JsonProperty("switch_inline_query_current_chat")
	val switch_inline_query_current_chat: String? = null,

	/**
	 * Optional. Specify True, to send a Pay button.
	 * NOTE: This type of button must always be the first button in the first row.
	 */
	@get:JsonProperty("pay")
	val pay: Boolean? = false

) {

	override fun equals(other: Any?): Boolean {
		if (this === other) return true
		if (other !is InlineKeyboardButton) return false

		if (text != other.text) return false
		if (url != other.url) return false
		if (callback_data != other.callback_data) return false
		if (switch_inline_query != other.switch_inline_query) return false
		if (switch_inline_query_current_chat != other.switch_inline_query_current_chat) return false
		if (pay != other.pay) return false

		return true
	}

	override fun hashCode(): Int {
		var result = text.hashCode()
		result = 31 * result + (url?.hashCode() ?: 0)
		result = 31 * result + (callback_data?.hashCode() ?: 0)
		result = 31 * result + (switch_inline_query?.hashCode() ?: 0)
		result = 31 * result + (switch_inline_query_current_chat?.hashCode() ?: 0)
		result = 31 * result + (pay?.hashCode() ?: 0)
		return result
	}
}
