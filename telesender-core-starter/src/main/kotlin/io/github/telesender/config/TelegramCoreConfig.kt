package io.github.telesender.config

import io.github.telesender.component.TelegramApi
import io.github.telesender.component.TelegramPollingClient
import io.github.telesender.component.impl.DefaultTelegramApi
import io.github.telesender.component.impl.DefaultTelegramPollingClient
import io.github.telesender.config.property.TelegramCoreProperties
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.context.ApplicationEventPublisher
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * @author Yauheni Yefimenka
 */
@Configuration
class TelegramCoreConfig {

	@ConditionalOnMissingBean
	@Bean
	fun telegramApi(properties: TelegramCoreProperties): TelegramApi = DefaultTelegramApi(properties)

	@ConditionalOnMissingBean
	@Bean
	fun telegramPolingClient(
		telegramApi: TelegramApi,
		eventPublisher: ApplicationEventPublisher
	): TelegramPollingClient = DefaultTelegramPollingClient(telegramApi, eventPublisher)

}
