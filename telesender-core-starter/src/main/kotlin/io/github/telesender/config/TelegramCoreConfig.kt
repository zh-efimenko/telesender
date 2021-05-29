package io.github.telesender.config

import io.github.telesender.component.TelegramApi
import io.github.telesender.component.TelegramPollingClient
import io.github.telesender.component.impl.DefaultTelegramApi
import io.github.telesender.component.impl.DefaultTelegramPollingClient
import kong.unirest.UnirestInstance
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.context.ApplicationEventPublisher
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * @author Yauheni Yefimenka
 */
@Configuration
class TelegramCoreConfig(
	private val unirestInstance: UnirestInstance
) {

	@ConditionalOnMissingBean
	@Bean
	fun telegramApi(): TelegramApi = DefaultTelegramApi(unirestInstance)

	@ConditionalOnMissingBean
	@Bean
	fun telegramPolingClient(eventPublisher: ApplicationEventPublisher): TelegramPollingClient =
		DefaultTelegramPollingClient(telegramApi(), eventPublisher)

}
