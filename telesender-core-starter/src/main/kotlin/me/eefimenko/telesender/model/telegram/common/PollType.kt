package me.eefimenko.telesender.model.telegram.common

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.deser.std.StdDeserializer
import com.fasterxml.jackson.databind.ser.std.StdSerializer

/**
 * @author Yauheni Yefimenka
 */
enum class PollType(val value: String) {

	REGULAR("regular"),
	QUIZ("quiz");

	companion object {
		fun of(text: String?): PollType? = values().find { it.value == text }
	}

	class PollTypeSerializer : StdSerializer<PollType>(PollType::class.java) {
		override fun serialize(mode: PollType, generator: JsonGenerator, provider: SerializerProvider) {
			generator.writeString(mode.value)
		}
	}

	class PollTypDeserializer : StdDeserializer<PollType>(PollType::class.java) {
		override fun deserialize(p: JsonParser, ctxt: DeserializationContext): PollType? = p.text?.let { of(it) }
	}
}
