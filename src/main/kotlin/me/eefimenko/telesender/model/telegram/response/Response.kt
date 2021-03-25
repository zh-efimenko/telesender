package me.eefimenko.telesender.model.telegram.response

import com.fasterxml.jackson.annotation.JsonProperty

data class Response<T>(

	@JsonProperty("ok")
	val ok: Boolean,

	@JsonProperty("result")
	val result: T? = null,

	@JsonProperty("error_code")
	val errorCode: Int? = null,

	@JsonProperty("description")
	val description: String? = null

)
