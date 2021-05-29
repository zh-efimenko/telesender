package me.eefimenko.telesender

import me.eefimenko.telesender.config.TelegramEngineConfig
import me.eefimenko.telesender.config.property.TelegramEngineProperties
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import

@Configuration
@Import(
	TelegramEngineConfig::class,
	TelegramEngineProperties::class
)
class TelesenderEngineApplication
