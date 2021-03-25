package me.eefimenko.telesender.model.telegram.request.inline

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.databind.ser.std.StdSerializer
import me.eefimenko.telesender.model.telegram.request.keyboard.InlineKeyboardMarkup

/**
 * @author Yauheni Yefimenka
 */
abstract class InlineQueryResult(

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
				generator.writeString(value.name.toLowerCase())
			}

		}

	}

}
