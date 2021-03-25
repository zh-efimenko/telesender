package me.eefimenko.telesender.config.property

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component
import javax.validation.constraints.NotBlank

/**
 * @author Yauheni Yefimenka
 */
@Component
@ConfigurationProperties("telegram.bot")
class TelegramProperties(

	@field:NotBlank var accessToken: String = ""

)
