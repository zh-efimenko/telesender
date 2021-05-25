package me.eefimenko.telesender.config

import me.eefimenko.telesender.component.DefaultTelegramListener
import me.eefimenko.telesender.component.TelegramApi
import me.eefimenko.telesender.component.TelegramListener
import me.eefimenko.telesender.config.property.TelegramEngineProperties
import me.eefimenko.telesender.filter.*
import me.eefimenko.telesender.handler.MessageHandler
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
	@ConditionalOnProperty(name = ["telegram.filters.message.enabled"], matchIfMissing = true)
	fun messageFilter(telegramApi: TelegramApi, messageHandlers: List<MessageHandler>): MessageFilter =
		MessageFilter(telegramApi, messageHandlers)

	@Bean
	@ConditionalOnProperty(name = ["telegram.filters.callbackQuery.enabled"], matchIfMissing = true)
	fun callbackQueryFilter(telegramApi: TelegramApi): CallbackQueryFilter =
		CallbackQueryFilter(telegramApi)

	@Bean
	@ConditionalOnProperty(name = ["telegram.filters.poll.enabled"], matchIfMissing = true)
	fun pollFilter(telegramApi: TelegramApi): PollFilter =
		PollFilter(telegramApi)

	@Bean
	@ConditionalOnProperty(name = ["telegram.filters.pollAnswer.enabled"], matchIfMissing = true)
	fun pollAnswerFilter(telegramApi: TelegramApi): PollAnswerFilter =
		PollAnswerFilter(telegramApi)

	@Bean
	@ConditionalOnProperty(name = ["telegram.filters.cancel.enabled"], matchIfMissing = true)
	fun cancelFilter(telegramApi: TelegramApi, properties: TelegramEngineProperties): CancelFilter =
		CancelFilter(telegramApi, properties)

	@Bean
	@ConditionalOnProperty(name = ["telegram.filters.unresolved.enabled"], matchIfMissing = true)
	fun unresolvedMessageFilter(telegramApi: TelegramApi): UnresolvedMessageFilter =
		UnresolvedMessageFilter(telegramApi)

}
