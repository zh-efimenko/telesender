package me.eefimenko.telesender.config.property

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration
import javax.validation.constraints.NotBlank

/**
 * @author Yauheni Yefimenka
 */
@Configuration
@ConfigurationProperties("telegram.bot")
class TelegramCoreProperties(

	@field:NotBlank var accessToken: String = ""

)
