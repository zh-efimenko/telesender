package io.github.telesender.model.telegram.send.media.group

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import io.github.telesender.model.telegram.common.MessageEntity
import io.github.telesender.model.telegram.send.dictionary.ParseMode
import java.io.File

/**
 * Represents a general file to be sent.
 *
 * @author Yauheni Yefimenka
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
class InputMediaDocument(
	media: File,
	thumb: Any? = null,
	caption: String? = null,
	parseMode: ParseMode? = null,
	captionEntities: List<MessageEntity>? = null,

	/**
	 * Optional. Disables automatic server-side content type detection for files uploaded using multipart/form-data
	 */
	@get:JsonProperty("disable_content_type_detection")
	val disableContentTypeDetection: Boolean? = null

) : InputMedia(InputMediaType.DOCUMENT, media, thumb, caption, parseMode, captionEntities)
