package me.eefimenko.telesender.component.impl

import me.eefimenko.telesender.component.BotCommandRunner
import me.eefimenko.telesender.component.TelegramApi
import me.eefimenko.telesender.filter.TelegramFilter
import me.eefimenko.telesender.model.telegram.common.BotCommand
import me.eefimenko.telesender.model.telegram.send.SetMyCommandsMessage

/**
 * @author Yauheni Yefimenka
 */
class DefaultBotCommandRunner(
	private val telegramApi: TelegramApi,
	private val filters: List<TelegramFilter>
) : BotCommandRunner {

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
