package io.github.telesender.model.telegram.recieve

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * This object represents an animated emoji that displays a random value.
 *
 * @author Yauheni Yefimenka
 */
data class Dice(

	/**
	 * Emoji on which the dice throw animation is based
	 */
	@JsonProperty("emoji")
	val emoji: String,

	/**
	 * Value of the dice, 1-6 for “🎲”, “🎯” and “🎳” base emoji, 1-5 for “🏀” and “⚽” base emoji,
	 * 1-64 for “🎰” base emoji
	 */
	@JsonProperty("value")
	val value: Int

)
