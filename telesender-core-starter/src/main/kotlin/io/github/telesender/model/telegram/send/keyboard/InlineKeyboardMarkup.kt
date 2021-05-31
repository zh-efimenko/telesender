package io.github.telesender.model.telegram.send.keyboard

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * This object represents an inline keyboard that appears right next to the message it belongs to.
 *
 * @author Yauheni Yefimenka
 */
class InlineKeyboardMarkup(
	answers: List<InlineKeyboardButton>,
	columns: Int = DEFAULT_COLUMNS_NUMBER
) : ReplyMarkup {

	/**
	 * Array of button rows, each represented by an Array of InlineKeyboardButton objects.
	 */
	@JsonProperty("inline_keyboard")
	val inlineKeyboard: List<List<InlineKeyboardButton>> = answers.asSequence()
		.chunked(columns)
		.toList()

	companion object {
		private const val DEFAULT_COLUMNS_NUMBER = 2
	}

	override fun equals(other: Any?): Boolean {
		if (this === other) return true
		if (other !is InlineKeyboardMarkup) return false

		if (inlineKeyboard != other.inlineKeyboard) return false

		return true
	}

	override fun hashCode(): Int {
		return inlineKeyboard.hashCode()
	}
}
