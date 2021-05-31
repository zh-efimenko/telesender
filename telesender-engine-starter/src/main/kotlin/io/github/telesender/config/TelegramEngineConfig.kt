package io.github.telesender.config

import io.github.telesender.component.BotCommandRunner
import io.github.telesender.component.TelegramApi
import io.github.telesender.component.TelegramListener
import io.github.telesender.component.impl.DefaultBotCommandRunner
import io.github.telesender.component.impl.DefaultTelegramListener
import io.github.telesender.config.property.TelegramEngineProperties
import io.github.telesender.filter.*
import io.github.telesender.filter.util.FilterExceptionUtil
import io.github.telesender.filter.util.impl.DefaultFilterExceptionUtil
import io.github.telesender.handler.CallbackQueryHandler
import io.github.telesender.handler.MessageHandler
import io.github.telesender.handler.PollAnswerHandler
import io.github.telesender.handler.PollHandler
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

	@ConditionalOnMissingBean
	@Bean
	fun botCommandRunner(telegramApi: TelegramApi, filters: List<TelegramFilter>): BotCommandRunner =
		DefaultBotCommandRunner(telegramApi, filters)

	@ConditionalOnMissingBean
	@Bean
	fun filterExceptionUtil(telegramApi: TelegramApi, properties: TelegramEngineProperties): FilterExceptionUtil =
		DefaultFilterExceptionUtil(telegramApi, properties)

	@Bean
	@ConditionalOnProperty(name = ["telegram.filters.message.enabled"], matchIfMissing = true)
	fun messageFilter(
		telegramApi: TelegramApi,
		handlers: List<MessageHandler>,
		exceptionUtil: FilterExceptionUtil
	): MessageFilter = MessageFilter(telegramApi, handlers, exceptionUtil)

	@Bean
	@ConditionalOnProperty(name = ["telegram.filters.callbackQuery.enabled"], matchIfMissing = true)
	fun callbackQueryFilter(
		telegramApi: TelegramApi,
		handlers: List<CallbackQueryHandler>,
		exceptionUtil: FilterExceptionUtil
	): CallbackQueryFilter = CallbackQueryFilter(telegramApi, handlers, exceptionUtil)

	@Bean
	@ConditionalOnProperty(name = ["telegram.filters.poll.enabled"], matchIfMissing = true)
	fun pollFilter(
		telegramApi: TelegramApi,
		handlers: List<PollHandler>,
		exceptionUtil: FilterExceptionUtil
	): PollFilter = PollFilter(telegramApi, handlers, exceptionUtil)

	@Bean
	@ConditionalOnProperty(name = ["telegram.filters.pollAnswer.enabled"], matchIfMissing = true)
	fun pollAnswerFilter(
		telegramApi: TelegramApi,
		handlers: List<PollAnswerHandler>,
		exceptionUtil: FilterExceptionUtil
	): PollAnswerFilter = PollAnswerFilter(telegramApi, handlers, exceptionUtil)

	@Bean
	@ConditionalOnProperty(name = ["telegram.filters.cancel.enabled"], matchIfMissing = true)
	fun cancelFilter(telegramApi: TelegramApi, properties: TelegramEngineProperties): CancelFilter =
		CancelFilter(telegramApi, properties)

	@Bean
	@ConditionalOnProperty(name = ["telegram.filters.unresolved.enabled"], matchIfMissing = true)
	fun unresolvedMessageFilter(telegramApi: TelegramApi): UnresolvedMessageFilter =
		UnresolvedMessageFilter(telegramApi)

}
