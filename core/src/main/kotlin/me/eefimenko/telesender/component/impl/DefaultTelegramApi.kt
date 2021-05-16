package me.eefimenko.telesender.component.impl

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import kong.unirest.ContentType
import kong.unirest.GenericType
import kong.unirest.HttpResponse
import kong.unirest.UnirestInstance
import me.eefimenko.telesender.component.TelegramApi
import me.eefimenko.telesender.model.exception.TelegramApiException
import me.eefimenko.telesender.model.telegram.recieve.*
import me.eefimenko.telesender.model.telegram.send.*
import me.eefimenko.telesender.model.telegram.send.inline.AnswerInlineQuery
import me.eefimenko.telesender.model.telegram.send.media.*
import me.eefimenko.telesender.model.telegram.send.media.group.MediaGroupMessage
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

	override fun sendMessage(message: TextMessage): Message {
		val request = unirest
			.post("/sendMessage")
			.header(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.mimeType)
			.body(message)
		val response = request
			.asObject(object : GenericType<Response<Message>>() {})

		return this.handleResponse(response)
	}

	override fun copyMessage(message: CopyMessage): MessageId {
		val request = unirest
			.post("/copyMessage")
			.header(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.mimeType)
			.body(message)
		val response = request
			.asObject(object : GenericType<Response<MessageId>>() {})

		return this.handleResponse(response)
	}

	override fun forwardMessage(message: ForwardMessage): Message {
		val request = unirest
			.post("/forwardMessage")
			.header(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.mimeType)
			.body(message)
		val response = request
			.asObject(object : GenericType<Response<Message>>() {})

		return this.handleResponse(response)
	}

	override fun sendPhoto(message: PhotoMessage): Message {
		val values =
			jacksonObjectMapper().convertValue(message, object : TypeReference<MutableMap<String, Any>>() {})
		message.mediaFile?.let { values[it.name] = it }
		message.thumbFile?.let { values[it.name] = it }

		val request = unirest
			.post("/sendPhoto")
			.fields(values)
		val response = request
			.asObject(object : GenericType<Response<Message>>() {})

		return this.handleResponse(response)
	}

	override fun sendAudio(message: AudioMessage): Message {
		val values =
			jacksonObjectMapper().convertValue(message, object : TypeReference<MutableMap<String, Any>>() {})
		message.mediaFile?.let { values[it.name] = it }
		message.thumbFile?.let { values[it.name] = it }

		val request = unirest
			.post("/sendAudio")
			.fields(values)
		val response = request
			.asObject(object : GenericType<Response<Message>>() {})

		return this.handleResponse(response)
	}

	override fun sendDocument(message: DocumentMessage): Message {
		val values =
			jacksonObjectMapper().convertValue(message, object : TypeReference<MutableMap<String, Any>>() {})
		message.mediaFile?.let { values[it.name] = it }
		message.thumbFile?.let { values[it.name] = it }

		val request = unirest
			.post("/sendDocument")
			.fields(values)
		val response = request
			.asObject(object : GenericType<Response<Message>>() {})

		return this.handleResponse(response)
	}

	override fun sendVideo(message: VideoMessage): Message {
		val values =
			jacksonObjectMapper().convertValue(message, object : TypeReference<MutableMap<String, Any>>() {})
		message.mediaFile?.let { values[it.name] = it }
		message.thumbFile?.let { values[it.name] = it }

		val request = unirest
			.post("/sendVideo")
			.fields(values)
		val response = request
			.asObject(object : GenericType<Response<Message>>() {})

		return this.handleResponse(response)
	}

	override fun sendAnimation(message: AnimationMessage): Message {
		val values =
			jacksonObjectMapper().convertValue(message, object : TypeReference<MutableMap<String, Any>>() {})
		message.mediaFile?.let { values[it.name] = it }
		message.thumbFile?.let { values[it.name] = it }

		val request = unirest
			.post("/sendAnimation")
			.fields(values)
		val response = request
			.asObject(object : GenericType<Response<Message>>() {})

		return this.handleResponse(response)
	}

	override fun sendVoice(message: VoiceMessage): Message {
		val values =
			jacksonObjectMapper().convertValue(message, object : TypeReference<MutableMap<String, Any>>() {})
		message.mediaFile?.let { values[it.name] = it }
		message.thumbFile?.let { values[it.name] = it }

		val request = unirest
			.post("/sendVoice")
			.fields(values)
		val response = request
			.asObject(object : GenericType<Response<Message>>() {})

		return this.handleResponse(response)
	}

	override fun sendVideoNote(message: VideoNoteMessage): Message {
		val values =
			jacksonObjectMapper().convertValue(message, object : TypeReference<MutableMap<String, Any>>() {})
		message.mediaFile?.let { values[it.name] = it }
		message.thumbFile?.let { values[it.name] = it }

		val request = unirest
			.post("/sendVideoNote")
			.fields(values)
		val response = request
			.asObject(object : GenericType<Response<Message>>() {})

		return this.handleResponse(response)
	}

	override fun sendMediaGroup(message: MediaGroupMessage): List<Message> {
		val values =
			jacksonObjectMapper().convertValue(message, object : TypeReference<MutableMap<String, Any>>() {})
		message.media.forEach { media ->
			media.mediaFile?.let { values[it.name] = it }
			media.thumbFile?.let { values[it.name] = it }
		}

		val request = unirest
			.post("/sendMediaGroup")
			.fields(values)

		val response = request
			.asObject(object : GenericType<Response<List<Message>>>() {})

		return this.handleResponse(response)
	}

	override fun sendLocation(message: LocationMessage): Message {
		val request = unirest
			.post("/sendLocation")
			.header(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.mimeType)
			.body(message)
		val response = request
			.asObject(object : GenericType<Response<Message>>() {})

		return this.handleResponse(response)
	}

	override fun sendVenue(message: VenueMessage): Message {
		val request = unirest
			.post("/sendVenue")
			.header(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.mimeType)
			.body(message)
		val response = request
			.asObject(object : GenericType<Response<Message>>() {})

		return this.handleResponse(response)
	}

	override fun sendContact(message: ContactMessage): Message {
		val request = unirest
			.post("/sendContact")
			.header(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.mimeType)
			.body(message)
		val response = request
			.asObject(object : GenericType<Response<Message>>() {})

		return this.handleResponse(response)
	}

	override fun sendPoll(message: PollMessage): Message {
		val request = unirest
			.post("/sendPoll")
			.header(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.mimeType)
			.body(message)
		val response = request
			.asObject(object : GenericType<Response<Message>>() {})

		return this.handleResponse(response)
	}

	override fun getUserProfilePhotos(message: GetUserProfilePhotosMessage): UserProfilePhotos {
		val request = unirest
			.post("/getUserProfilePhotos")
			.header(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.mimeType)
			.body(message)
		val response = request
			.asObject(object : GenericType<Response<UserProfilePhotos>>() {})

		return this.handleResponse(response)
	}

	override fun answerInlineQuery(query: AnswerInlineQuery): Boolean {
		val request = unirest
			.post("/answerInlineQuery")
			.header(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.mimeType)
			.body(query)
		val response = request
			.asObject(object : GenericType<Response<Boolean>>() {})

		return this.handleResponse(response)
	}

	private fun <R> handleResponse(response: HttpResponse<Response<R>>): R {
		return response
			.ifFailure {
				val message = "Status: ${it.status}. Message: ${it.body}."
				log.error(message)
				throw TelegramApiException(message)
			}
			.body.result!!
	}

}
