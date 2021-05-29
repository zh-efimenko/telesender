package io.github.telesender.config.property

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

/**
 * @author Yauheni Yefimenka
 */
@Configuration
@ConfigurationProperties("telegram.bot")
class TelegramCoreProperties(
	var accessToken: String = ""
)
