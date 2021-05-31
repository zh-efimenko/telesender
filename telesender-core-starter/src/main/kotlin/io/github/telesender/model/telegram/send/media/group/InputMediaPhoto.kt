package io.github.telesender.model.telegram.send.media.group

import com.fasterxml.jackson.annotation.JsonInclude
import io.github.telesender.model.telegram.common.MessageEntity
import io.github.telesender.model.telegram.send.dictionary.ParseMode

/**
 * Represents a photo to be sent.
 *
 * @author Yauheni Yefimenka
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
class InputMediaPhoto @JvmOverloads constructor(
	media: Any,
	caption: String? = null,
	parseMode: ParseMode? = null,
	captionEntities: List<MessageEntity>? = null
) : InputMedia(InputMediaType.PHOTO, media, null, caption, parseMode, captionEntities) {

	override fun equals(other: Any?): Boolean {
		if (this === other) return true
		if (other !is InputMediaPhoto) return false
		if (!super.equals(other)) return false
		return true
	}

	override fun hashCode(): Int {
		return super.hashCode()
	}
}
