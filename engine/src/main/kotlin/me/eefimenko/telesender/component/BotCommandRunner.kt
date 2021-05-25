package me.eefimenko.telesender.component

import me.eefimenko.telesender.config.property.TelegramEngineProperties
import me.eefimenko.telesender.handler.Handler
import me.eefimenko.telesender.model.telegram.common.BotCommand
import me.eefimenko.telesender.model.telegram.send.SetMyCommandsMessage
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

/**
 * @author Yauheni Yefimenka
 */
@Component
class BotCommandRunner(
	private val telegramApi: TelegramApi,
	private val properties: TelegramEngineProperties,
	private val handlers: List<Handler>
) : CommandLineRunner {

	override fun run(vararg args: String?) {
		val commands = mutableListOf<String>()
		commands.addAll(properties.getFullCommands())
		commands.addAll(handlers.flatMap { it.getCommands() })

		val botCommands = commands.map {
			val command = it.replace("/", "")
			BotCommand(command = command, description = command)
		}
		telegramApi.setMyCommands(SetMyCommandsMessage(commands = botCommands))
	}

}
