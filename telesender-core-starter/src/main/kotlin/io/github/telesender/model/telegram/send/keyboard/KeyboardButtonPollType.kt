package io.github.telesender.model.telegram.send.keyboard

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import io.github.telesender.model.telegram.common.PollType

/**
 * This object represents type of a poll, which is allowed to be created and sent
 * when the corresponding button is pressed.
 *
 * @author Yauheni Yefimenka
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
class KeyboardButtonPollType(

	/**
	 * Optional. If quiz is passed, the user will be allowed to create only polls in the quiz mode.
	 * If regular is passed, only regular polls will be allowed. Otherwise, the user will be allowed
	 * to create a poll of any type.
	 */
	@get:JsonProperty("type")
	@get:JsonSerialize(using = PollType.PollTypeSerializer::class)
	val type: PollType? = null

) : ReplyMarkup
