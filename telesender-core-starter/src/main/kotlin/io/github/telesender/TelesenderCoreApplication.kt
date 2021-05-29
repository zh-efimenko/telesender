package io.github.telesender

import io.github.telesender.config.TelegramCoreConfig
import io.github.telesender.config.UnirestConfig
import io.github.telesender.config.property.TelegramCoreProperties
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import

@Configuration
@Import(
	TelegramCoreConfig::class,
	UnirestConfig::class,
	TelegramCoreProperties::class
)
class TelesenderCoreApplication
