package me.eefimenko.telesender.component

import me.eefimenko.telesender.filter.TelegramFilter
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
	private val filters: List<TelegramFilter>
) : CommandLineRunner {

	override fun run(vararg args: String?) {
		val commands = filters
			.flatMap { it.getCommands().entries }
			.groupBy({ it.key }, { it.value })

		val botCommands = commands.map {
			val command = it.key.replace("/", "")
			BotCommand(command = command, description = it.value[0])
		}
		telegramApi.setMyCommands(SetMyCommandsMessage(commands = botCommands))
	}

}
