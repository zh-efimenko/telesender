package me.eefimenko.telesender.model.telegram.common

import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * This object represents a bot command.
 *
 * @author Yauheni Yefimenka
 */
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
data class BotCommand(

	/**
	 * Text of the command, 1-32 characters. Can contain only lowercase English letters, digits and underscores.
	 */
	@JsonProperty("command")
	val command: String,

	/**
	 * Description of the command, 3-256 characters.
	 */
	@JsonProperty("description")
	val description: String

)
