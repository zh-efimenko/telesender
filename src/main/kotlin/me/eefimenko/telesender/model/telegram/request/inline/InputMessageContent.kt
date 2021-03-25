package me.eefimenko.telesender.model.telegram.request.inline

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import me.eefimenko.telesender.model.telegram.request.MessageEntity
import me.eefimenko.telesender.model.telegram.request.dictionary.ParseMode

/**
 * @author Yauheni Yefimenka
 */
interface InputMessageContent

@JsonInclude(JsonInclude.Include.NON_NULL)
class InputLocationMessageContent : InputMessageContent

@JsonInclude(JsonInclude.Include.NON_NULL)
class InputVenueMessageContent : InputMessageContent

@JsonInclude(JsonInclude.Include.NON_NULL)
class InputContactMessageContent : InputMessageContent
