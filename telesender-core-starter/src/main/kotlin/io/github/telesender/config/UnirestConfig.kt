package io.github.telesender.config

import io.github.telesender.config.property.TelegramCoreProperties
import kong.unirest.Unirest
import kong.unirest.UnirestInstance
import kong.unirest.jackson.JacksonObjectMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * @author Yauheni Yefimenka
 */
@Configuration
class UnirestConfig(
	private val properties: TelegramCoreProperties,
) {

	@Bean(destroyMethod = "shutDown")
	fun unirestInstance(): UnirestInstance {
		val instance = Unirest.primaryInstance()
		instance.config().objectMapper = JacksonObjectMapper()
		instance.config().defaultBaseUrl("https://api.telegram.org/bot${properties.accessToken}")
		return instance
	}

}
