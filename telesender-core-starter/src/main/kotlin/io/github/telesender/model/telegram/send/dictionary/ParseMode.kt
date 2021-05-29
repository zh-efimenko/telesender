package io.github.telesender.model.telegram.send.dictionary

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.ser.std.StdSerializer

/**
 * @author Yauheni Yefimenka
 */
enum class ParseMode(val value: String) {

	MARKDOWN_V2("MarkdownV2"),
	MARKDOWN("Markdown"),
	HTML("HTML");

	class ParseModeSerializer : StdSerializer<ParseMode>(ParseMode::class.java) {
		override fun serialize(mode: ParseMode, generator: JsonGenerator, provider: SerializerProvider) {
			generator.writeString(mode.value)
		}
	}
}
