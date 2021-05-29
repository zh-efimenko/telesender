package io.github.telesender.model.telegram.send

import com.fasterxml.jackson.annotation.JsonProperty
import io.github.telesender.model.telegram.common.BotCommand

/**
 * @author Yauheni Yefimenka
 */
data class SetMyCommandsMessage(

	/**
	 * A JSON-serialized list of bot commands to be set as the list of the bot's commands.
	 * At most 100 commands can be specified.
	 */
	@get:JsonProperty("commands")
	val commands: List<BotCommand>

)
