package me.eefimenko.telesender.model.telegram.recieve

import com.fasterxml.jackson.annotation.JsonProperty
import me.eefimenko.telesender.model.telegram.common.MessageEntity

/**
 * This object represents a game. Use BotFather to create and edit games,
 * their short names will act as unique identifiers.
 *
 * @author Yauheni Yefimenka
 */
data class Game(

	/**
	 * Title of the game
	 */
	@JsonProperty("title")
	val title: String,

	/**
	 * Description of the game
	 */
	@JsonProperty("description")
	val description: String,

	/**
	 * Photo that will be displayed in the game message in chats.
	 */
	@JsonProperty("photo")
	val photo: List<PhotoSize>,

	/**
	 * Optional. Brief description of the game or high scores included in the game message.
	 * Can be automatically edited to include current high scores for the game when the bot
	 * calls setGameScore, or manually edited using editMessageText. 0-4096 characters.
	 */
	@JsonProperty("text")
	val text: String? = null,

	/**
	 * Optional. Special entities that appear in text, such as usernames, URLs, bot commands, etc.
	 */
	@JsonProperty("text_entities")
	val textEntities: List<MessageEntity>? = null,

	/**
	 * Optional. Animation that will be displayed in the game message in chats. Upload via BotFather
	 */
	@JsonProperty("animation")
	val animation: Animation? = null

)
