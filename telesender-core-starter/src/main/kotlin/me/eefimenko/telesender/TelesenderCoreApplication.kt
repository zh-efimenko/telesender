package me.eefimenko.telesender

import me.eefimenko.telesender.config.TelegramCoreConfig
import me.eefimenko.telesender.config.UnirestConfig
import me.eefimenko.telesender.config.property.TelegramCoreProperties
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import

@Configuration
@Import(
	TelegramCoreConfig::class,
	UnirestConfig::class,
	TelegramCoreProperties::class
)
class TelesenderCoreApplication
