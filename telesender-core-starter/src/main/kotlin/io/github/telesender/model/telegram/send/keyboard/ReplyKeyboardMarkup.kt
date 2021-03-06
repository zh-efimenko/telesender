package io.github.telesender.model.telegram.send.keyboard

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * @author Yauheni Yefimenka
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
class ReplyKeyboardMarkup @JvmOverloads constructor(
	answers: List<KeyboardButton>,
	columns: Int = DEFAULT_COLUMNS_NUMBER,

	/**
	 * Optional. Requests clients to resize the keyboard vertically for optimal fit
	 * (e.g., make the keyboard smaller if there are just two rows of buttons).
	 * Defaults to false, in which case the custom keyboard is always of the same height as the app's standard keyboard.
	 */
	@get:JsonProperty("resize_keyboard")
	val resizeKeyboard: Boolean? = null,

	/**
	 * Optional. Requests clients to hide the keyboard as soon as it's been used.
	 * The keyboard will still be available, but clients will automatically display the usual letter-keyboard
	 * in the chat – the user can press a special button in the input field to see the custom keyboard again.
	 * Defaults to false.
	 */
	@get:JsonProperty("one_time_keyboard")
	val oneTimeKeyboard: Boolean? = null,

	/**
	 * Optional. Use this parameter if you want to show the keyboard to specific users only.
	 * Targets: 1) users that are @mentioned in the text of the Message object;
	 * 2) if the bot's message is a reply (has reply_to_message_id), sender of the original message.
	 *
	 * Example: A user requests to change the bot's language, bot replies to the request with a keyboard
	 * to select the new language. Other users in the group don't see the keyboard.
	 */
	@get:JsonProperty("selective")
	val selective: Boolean? = null

) : ReplyMarkup {

	/**
	 * Array of button rows, each represented by an Array of KeyboardButton objects.
	 */
	@JsonProperty("keyboard")
	val keyboard: List<List<KeyboardButton>> = answers.asSequence()
		.chunked(columns)
		.toList()

	companion object {
		private const val DEFAULT_COLUMNS_NUMBER = 2
	}

	override fun equals(other: Any?): Boolean {
		if (this === other) return true
		if (other !is ReplyKeyboardMarkup) return false

		if (resizeKeyboard != other.resizeKeyboard) return false
		if (oneTimeKeyboard != other.oneTimeKeyboard) return false
		if (selective != other.selective) return false
		if (keyboard != other.keyboard) return false

		return true
	}

	override fun hashCode(): Int {
		var result = resizeKeyboard?.hashCode() ?: 0
		result = 31 * result + (oneTimeKeyboard?.hashCode() ?: 0)
		result = 31 * result + (selective?.hashCode() ?: 0)
		result = 31 * result + keyboard.hashCode()
		return result
	}
}
