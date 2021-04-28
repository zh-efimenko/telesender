package me.eefimenko.telesender.component.impl

import kong.unirest.ContentType
import kong.unirest.GenericType
import kong.unirest.HttpResponse
import kong.unirest.UnirestInstance
import me.eefimenko.telesender.component.TelegramApi
import me.eefimenko.telesender.model.exception.TelegramApiException
import me.eefimenko.telesender.model.telegram.response.SendMessage
import me.eefimenko.telesender.model.telegram.response.inline.AnswerInlineQuery
import me.eefimenko.telesender.model.telegram.request.Message
import me.eefimenko.telesender.model.telegram.request.Response
import me.eefimenko.telesender.model.telegram.request.Update
import me.eefimenko.telesender.model.telegram.request.User
import mu.KotlinLogging
import org.apache.http.HttpHeaders

/**
 * @author Yauheni Yefimenka
 */
class DefaultTelegramApi(
	private val unirest: UnirestInstance
) : TelegramApi {

	private val log = KotlinLogging.logger {}

	override fun getMe(): User {
		val response = unirest
			.get("/getMe")
			.asObject(object : GenericType<Response<User>>() {})

		return this.handleResponse(response)
	}

	override fun getUpdates(offset: Long?, timeout: Int?): List<Update> {
		val params = hashMapOf<String, Any>()
		offset?.let { params["offset"] = it }
		timeout?.let { params["timeout"] = it }

		val response = unirest
			.get("/getUpdates")
			.queryString(params)
			.asObject(object : GenericType<Response<List<Update>>>() {})

		return this.handleResponse(response)
	}

	override fun sendMessage(sendMessage: SendMessage): Message {
		val request = unirest
			.post("/sendMessage")
			.header(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.mimeType)
			.body(sendMessage)
		val response = request
			.asObject(object : GenericType<Response<Message>>() {})

		return this.handleResponse(response)
	}

	override fun answerInlineQuery(answerInlineQuery: AnswerInlineQuery): Boolean {
		val request = unirest
			.post("/answerInlineQuery")
			.header(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.mimeType)
			.body(answerInlineQuery)
		val response = request
			.asObject(object : GenericType<Response<Boolean>>() {})

		return this.handleResponse(response)
	}

	private fun <T> handleResponse(response: HttpResponse<Response<T>>): T {
		return response
			.ifFailure {
				val message = "Status: ${it.status}. Message: ${it.body}."
				log.error(message)
				throw TelegramApiException(message)
			}
			.body.result!!
	}

}
