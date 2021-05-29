package io.github.telesender.model.telegram.send.media.group

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.ser.std.StdSerializer

/**
 * @author Yauheni Yefimenka
 */
enum class InputMediaType {

	PHOTO,
	DOCUMENT,
	ANIMATION,
	AUDIO,
	VIDEO;

	class InputMediaTypeSerializer : StdSerializer<InputMediaType>(InputMediaType::class.java) {
		override fun serialize(mode: InputMediaType, generator: JsonGenerator, provider: SerializerProvider) {
			generator.writeString(mode.name.lowercase())
		}
	}
}
