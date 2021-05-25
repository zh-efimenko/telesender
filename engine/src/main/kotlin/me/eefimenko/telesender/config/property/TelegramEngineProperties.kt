package me.eefimenko.telesender.config.property

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

/**
 * @author Yauheni Yefimenka
 */
@Component
@ConfigurationProperties("telegram")
class TelegramEngineProperties {

	var filters: Map<String, Map<String, Any>> = mapOf()

	fun enabledFilter(name: String): Boolean = filters[name]?.get("enabled") as? Boolean ?: true

	@Suppress("UNCHECKED_CAST")
	fun getFilterCommands(name: String): Map<String, String> {
		if (!enabledFilter(name)) {
			return emptyMap()
		}

		val commands = filters[name]?.get("commands") as? Map<Int, String>
		return commands?.values?.associate {
			Pair(it.substringBefore(':'), it.substringAfter(':'))
		} ?: emptyMap()
	}

	fun getFullCommands(): Map<String, String> {
		val commands = mutableMapOf<String, String>()
		filters.keys.forEach {
			commands.putAll(this.getFilterCommands(it))
		}

		return commands
	}

	companion object {
		const val MESSAGE_FILTER = "message"
		const val CALLBACK_QUERY_FILTER = "callbackQuery"
		const val POLL_FILTER = "poll"
		const val POLL_ANSWER_FILTER = "pollAnswer"
		const val CANCEL_FILTER = "cancel"
		const val UNRESOLVED_FILTER = "unresolved"
	}
}
