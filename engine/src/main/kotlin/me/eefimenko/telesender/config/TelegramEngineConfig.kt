package me.eefimenko.telesender.config

import me.eefimenko.telesender.component.DefaultTelegramListener
import me.eefimenko.telesender.component.TelegramApi
import me.eefimenko.telesender.component.TelegramListener
import me.eefimenko.telesender.filter.CancelFilter
import me.eefimenko.telesender.filter.HandlersFilter
import me.eefimenko.telesender.filter.TelegramFilter
import me.eefimenko.telesender.filter.UnresolvedMessageFilter
import me.eefimenko.telesender.handler.Handler
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * @author Yauheni Yefimenka
 */
@Configuration
class TelegramEngineConfig {

	@ConditionalOnMissingBean
	@Bean
	fun telegramListener(filters: List<TelegramFilter>): TelegramListener = DefaultTelegramListener(filters)

	@Bean
	fun handlersFilter(telegramApi: TelegramApi, handlers: List<Handler>): HandlersFilter =
		HandlersFilter(telegramApi, handlers)

	@Bean
	@ConditionalOnProperty(name = ["telegram.filters.cancel.enabled"], matchIfMissing = true)
	fun cancelFilter(telegramApi: TelegramApi, handlersFilter: HandlersFilter): CancelFilter =
		CancelFilter(telegramApi, handlersFilter)

	@Bean
	@ConditionalOnProperty(name = ["telegram.filters.unresolved.enabled"], matchIfMissing = true)
	fun unresolvedMessageFilter(telegramApi: TelegramApi): UnresolvedMessageFilter =
		UnresolvedMessageFilter(telegramApi)

}
