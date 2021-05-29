package io.github.telesender.model.telegram.recieve.inline

import com.fasterxml.jackson.annotation.JsonProperty
import io.github.telesender.model.telegram.recieve.Location
import io.github.telesender.model.telegram.recieve.User

/**
 * Note: It is necessary to enable inline feedback via @Botfather in order to receive these objects in updates.
 *
 * @author Yauheni Yefimenka
 */
data class ChosenInlineResult(

	/**
	 * The unique identifier for the result that was chosen
	 */
	@JsonProperty("result_id")
	val resultId: String,

	/**
	 * The user that chose the result
	 */
	@JsonProperty("from")
	val from: User,

	/**
	 * The query that was used to obtain the result
	 */
	@JsonProperty("query")
	val query: String,

	/**
	 * Optional. Sender location, only for bots that require user location
	 */
	@JsonProperty("location")
	val location: Location? = null,

	/**
	 * Optional. Identifier of the sent inline message. Available only if there is an inline keyboard
	 * attached to the message. Will be also received in callback queries and can be used to edit the message.
	 */
	@JsonProperty("inline_message_id")
	val inlineMessageId: String? = null

)
