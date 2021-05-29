package me.eefimenko.telesender.config

import kong.unirest.UnirestInstance
import me.eefimenko.telesender.component.TelegramApi
import me.eefimenko.telesender.component.TelegramPollingClient
import me.eefimenko.telesender.component.impl.DefaultTelegramApi
import me.eefimenko.telesender.component.impl.DefaultTelegramPollingClient
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
