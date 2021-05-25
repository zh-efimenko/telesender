package me.eefimenko.telesender.model.telegram.recieve.inline

import com.fasterxml.jackson.annotation.JsonProperty
import me.eefimenko.telesender.model.telegram.recieve.Message
import me.eefimenko.telesender.model.telegram.recieve.User

/**
 * NOTE: After the user presses a callback button, Telegram clients will display a progress bar until
 * you call answerCallbackQuery. It is, therefore, necessary to react by calling answerCallbackQuery
 * even if no notification to the user is needed (e.g., without specifying any of the optional parameters).
 *
 * @author Yauheni Yefimenka
 */
data class CallbackQuery(

	/**
	 * Unique identifier for this query
	 */
	@JsonProperty("id")
	val id: String,

	/**
	 * Sender
	 */
	@JsonProperty("from")
	val from: User,

	/**
	 * Global identifier, uniquely corresponding to the chat to which the message with the callback button was sent.
	 * Useful for high scores in games.
	 */
	@JsonProperty("chat_instance")
	val chatInstance: String,

	/**
	 * Optional. Message with the callback button that originated the query.
	 * Note that message content and message date will not be available if the message is too old
	 */
	@JsonProperty("message")
	val message: Message? = null,

	/**
	 * Optional. Identifier of the message sent via the bot in inline mode, that originated the query.
	 */
	@JsonProperty("inline_message_id")
	val inlineMessageId: String? = null,

	/**
	 * Optional. Data associated with the callback button. Be aware that a bad client can send arbitrary data
	 * in this field.
	 */
	@JsonProperty("data")
	val data: String? = null,

	/**
	 * 	Optional. Short name of a Game to be returned, serves as the unique identifier for the game
	 */
	@JsonProperty("game_short_name")
	val gameShortName: String? = null
)
