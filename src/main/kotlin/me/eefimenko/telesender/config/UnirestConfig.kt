package me.eefimenko.telesender.config

import kong.unirest.Unirest
import kong.unirest.UnirestInstance
import kong.unirest.jackson.JacksonObjectMapper
import me.eefimenko.telesender.config.property.TelegramProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * @author Yauheni Yefimenka
 */
@Configuration
class UnirestConfig(
	private val telegramProperties: TelegramProperties,
) {

	@Bean(destroyMethod = "shutDown")
	fun unirestInstance(): UnirestInstance {
		val instance = Unirest.primaryInstance()
		instance.config().objectMapper = JacksonObjectMapper()
		instance.config().defaultBaseUrl("https://api.telegram.org/bot${telegramProperties.accessToken}")
		return instance
	}

}
