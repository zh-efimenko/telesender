package io.github.telesender.config.property

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

/**
 * @author Yauheni Yefimenka
 */
@Configuration
@ConfigurationProperties("telegram")
class TelegramEngineProperties(
	var cancelFilter: CancelFilterConfig
) {

	var admin: AdminConfig = AdminConfig()

	class AdminConfig(
		var enabled: Boolean = false,
		var chatId: Long = 0
	)

	@Configuration
	@ConfigurationProperties("telegram.filters.cancel")
	class CancelFilterConfig(
		var enabled: Boolean = true,
		var commands: List<String> = listOf("/cancel:cancel")
	) {
		/**
		 * Normalized commands
		 */
		fun getCommands(): Map<String, String> {
			if (!enabled) return mapOf()

			return commands.associate {
				Pair(it.substringBefore(':'), it.substringAfter(':'))
			}
		}
	}

}
