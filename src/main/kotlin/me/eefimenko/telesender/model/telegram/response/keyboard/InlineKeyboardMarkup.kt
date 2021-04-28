package me.eefimenko.telesender.model.telegram.response.keyboard

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * @author Yauheni Yefimenka
 *
 * This object represents an inline keyboard that appears right next to the message it belongs to.
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

}
