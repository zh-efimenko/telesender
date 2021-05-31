package io.github.telesender.model.telegram.send.inline

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.databind.ser.std.StdSerializer
import io.github.telesender.model.telegram.send.keyboard.InlineKeyboardMarkup

/**
 * @author Yauheni Yefimenka
 */
abstract class InlineQueryResult @JvmOverloads constructor(

	/**
	 * 	Type of the result.
	 */
	@get:JsonProperty("type")
	@get:JsonSerialize(using = Type.TypeSerializer::class)
	val type: Type,

	/**
	 * Unique identifier for this result, 1-64 Bytes.
	 */
	@get:JsonProperty("id")
	val id: String,

	/**
	 * Content of the message to be sent.
	 */
	@get:JsonProperty("input_message_content")
	val inputMessageContent: InputMessageContent? = null,

	/**
	 * 	Optional. Inline keyboard attached to the message.
	 */
	@get:JsonProperty("reply_markup")
	val replyMarkup: InlineKeyboardMarkup? = null

) {

	enum class Type {

		ARTICLE,
		PHOTO,
		GIF,
		MPEG4_GIF,
		VIDEO,
		AUDIO,
		VOICE,
		DOCUMENT,
		LOCATION,
		VENUE,
		CONTACT,
		GAME,
		STICKER;

		class TypeSerializer : StdSerializer<Type>(Type::class.java) {
			override fun serialize(value: Type, generator: JsonGenerator, provider: SerializerProvider) {
				generator.writeString(value.name.lowercase())
			}
		}
	}

	override fun equals(other: Any?): Boolean {
		if (this === other) return true
		if (other !is InlineQueryResult) return false

		if (type != other.type) return false
		if (id != other.id) return false
		if (inputMessageContent != other.inputMessageContent) return false
		if (replyMarkup != other.replyMarkup) return false

		return true
	}

	override fun hashCode(): Int {
		var result = type.hashCode()
		result = 31 * result + id.hashCode()
		result = 31 * result + (inputMessageContent?.hashCode() ?: 0)
		result = 31 * result + (replyMarkup?.hashCode() ?: 0)
		return result
	}
}
