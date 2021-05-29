package io.github.telesender

import io.github.telesender.config.TelegramEngineConfig
import io.github.telesender.config.property.TelegramEngineProperties
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import

@Configuration
@Import(
	TelegramEngineConfig::class,
	TelegramEngineProperties::class
)
class TelesenderEngineApplication
