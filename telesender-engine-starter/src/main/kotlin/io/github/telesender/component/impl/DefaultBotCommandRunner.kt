package io.github.telesender.component.impl

import io.github.telesender.component.BotCommandRunner
import io.github.telesender.component.TelegramApi
import io.github.telesender.filter.TelegramFilter
import io.github.telesender.model.telegram.common.BotCommand
import io.github.telesender.model.telegram.send.SetMyCommandsMessage

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
