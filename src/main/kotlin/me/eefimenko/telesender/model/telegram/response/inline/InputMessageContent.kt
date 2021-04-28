package me.eefimenko.telesender.model.telegram.response.inline

import com.fasterxml.jackson.annotation.JsonInclude

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
