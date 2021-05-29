package me.eefimenko.telesender.model.telegram.send.media.group

import com.fasterxml.jackson.annotation.JsonInclude
import me.eefimenko.telesender.model.telegram.common.MessageEntity
import me.eefimenko.telesender.model.telegram.send.dictionary.ParseMode

/**
 * Represents a photo to be sent.
 *
 * @author Yauheni Yefimenka
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
class InputMediaPhoto(
	media: Any,
	caption: String? = null,
	parseMode: ParseMode? = null,
	captionEntities: List<MessageEntity>? = null
) : InputMedia(InputMediaType.PHOTO, media, null, caption, parseMode, captionEntities)
