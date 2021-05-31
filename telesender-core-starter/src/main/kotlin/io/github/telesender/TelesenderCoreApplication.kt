package io.github.telesender

import io.github.telesender.config.TelegramCoreConfig
import io.github.telesender.config.property.TelegramCoreProperties
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import

@Configuration
@Import(
	TelegramCoreConfig::class,
	TelegramCoreProperties::class
)
class TelesenderCoreApplication
