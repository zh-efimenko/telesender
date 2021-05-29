package io.github.telesender.model.telegram.send.inline

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Use this method to send answers to an inline query. On success, True is returned.
 * No more than 50 results per query are allowed.
 *
 * @author Yauheni Yefimenka
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
data class AnswerInlineQuery(

	/**
	 * Unique identifier for the answered query
	 */
	@get:JsonProperty("inline_query_id")
	val inlineQueryId: String,

	/**
	 * A JSON-serialized array of results for the inline query
	 */
	@get:JsonProperty("results")
	val results: List<InlineQueryResult>,

	/**
	 * Optional. The maximum amount of time in seconds that the result of the inline query may be cached on the server.
	 * Defaults to 300.
	 */
	@get:JsonProperty("cache_time")
	val cacheTime: Long? = null,
	/**
	 * Optional. Pass True, if results may be cached on the server side only for the user that sent the query.
	 * By default, results may be returned to any user who sends the same query
	 */
	@get:JsonProperty("is_personal")
	val isPersonal	: Boolean? = null,
	/**
	 * 	Optional. Pass the offset that a client should send in the next query with the same text to receive more
	 * 	results. Pass an empty string if there are no more results or if you don't support pagination.
	 * 	Offset length can't exceed 64 bytes.
	 */
	@get:JsonProperty("next_offset")
	val nextOffset: String? = null,
	/**
	 * 	Optional. If passed, clients will display a button with specified text that switches the user
	 * 	to a private chat with the bot and sends the bot a start message with the parameter switch_pm_parameter
	 */
	@get:JsonProperty("switch_pm_text")
	val switchPmText: String? = null,
	/**
	 * 	Optional. Deep-linking parameter for the /start message sent to the bot when user presses the switch button.
	 * 	1-64 characters, only A-Z, a-z, 0-9, _ and - are allowed.
	 */
	@get:JsonProperty("switch_pm_parameter")
	val switchPmParameter: String? = null

)
