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
	fun getFilterCommands(name: String): List<String> {
		if (!enabledFilter(name)) {
			return emptyList()
		}

		val commands = filters[name]?.get("commands") as? Map<Int, String>
		return commands?.values?.toList() ?: emptyList()
	}

	fun getFullCommands(): List<String> = filters.keys.flatMap { getFilterCommands(it) }

	companion object {
		const val MESSAGE_FILTER = "message"
		const val CALLBACK_QUERY_FILTER = "callbackQuery"
		const val POLL_FILTER = "poll"
		const val POLL_ANSWER_FILTER = "pollAnswer"
		const val CANCEL_FILTER = "cancel"
		const val UNRESOLVED_FILTER = "unresolved"
	}
}
