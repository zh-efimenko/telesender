package me.eefimenko.telesender.component.impl

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import kong.unirest.ContentType
import kong.unirest.GenericType
import kong.unirest.HttpResponse
import kong.unirest.UnirestInstance
import me.eefimenko.telesender.component.TelegramApi
import me.eefimenko.telesender.model.exception.TelegramApiException
import me.eefimenko.telesender.model.telegram.request.*
import me.eefimenko.telesender.model.telegram.response.*
import me.eefimenko.telesender.model.telegram.response.inline.AnswerInlineQuery
import mu.KotlinLogging
import org.apache.http.HttpHeaders
import java.io.File

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

	override fun sendMessage(textMessage: TextMessage): Message {
		val request = unirest
			.post("/sendMessage")
			.header(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.mimeType)
			.body(textMessage)
		val response = request
			.asObject(object : GenericType<Response<Message>>() {})

		return this.handleResponse(response)
	}

	override fun copyMessage(copyMessage: CopyMessage): MessageId {
		val request = unirest
			.post("/copyMessage")
			.header(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.mimeType)
			.body(copyMessage)
		val response = request
			.asObject(object : GenericType<Response<MessageId>>() {})

		return this.handleResponse(response)
	}

	override fun forwardMessage(forwardMessage: ForwardMessage): Message {
		val request = unirest
			.post("/forwardMessage")
			.header(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.mimeType)
			.body(forwardMessage)
		val response = request
			.asObject(object : GenericType<Response<Message>>() {})

		return this.handleResponse(response)
	}

	override fun sendPhoto(photoMessage: PhotoMessage): Message {
		val values =
			jacksonObjectMapper().convertValue(photoMessage, object : TypeReference<MutableMap<String, Any>>() {})
		values["photo"] = if (photoMessage.photoIsFile()) photoMessage.photo as File else photoMessage.photo as String

		val request = unirest
			.post("/sendPhoto")
			.fields(values)
		val response = request
			.asObject(object : GenericType<Response<Message>>() {})

		return this.handleResponse(response)
	}

	override fun sendAudio(audioMessage: AudioMessage): Message {
		val values =
			jacksonObjectMapper().convertValue(audioMessage, object : TypeReference<MutableMap<String, Any>>() {})
		values["audio"] = if (audioMessage.audioIsFile()) audioMessage.audio as File else audioMessage.audio as String
		audioMessage.thumb?.let {
			values["thumb"] = if (audioMessage.thumbIsFile()) it as File else it as String
		}

		val request = unirest
			.post("/sendAudio")
			.fields(values)
		val response = request
			.asObject(object : GenericType<Response<Message>>() {})

		return this.handleResponse(response)
	}

	override fun sendDocument(documentMessage: DocumentMessage): Message {
		val values =
			jacksonObjectMapper().convertValue(documentMessage, object : TypeReference<MutableMap<String, Any>>() {})
		values["document"] =
			if (documentMessage.documentIsFile()) documentMessage.document as File else documentMessage.document as String
		documentMessage.thumb?.let {
			values["thumb"] = if (documentMessage.thumbIsFile()) it as File else it as String
		}

		val request = unirest
			.post("/sendDocument")
			.fields(values)
		val response = request
			.asObject(object : GenericType<Response<Message>>() {})

		return this.handleResponse(response)
	}

	override fun sendVideo(videoMessage: VideoMessage): Message {
		val values =
			jacksonObjectMapper().convertValue(videoMessage, object : TypeReference<MutableMap<String, Any>>() {})
		values["video"] =
			if (videoMessage.videoIsFile()) videoMessage.video as File else videoMessage.video as String
		videoMessage.thumb?.let {
			values["thumb"] = if (videoMessage.thumbIsFile()) it as File else it as String
		}

		val request = unirest
			.post("/sendVideo")
			.fields(values)
		val response = request
			.asObject(object : GenericType<Response<Message>>() {})

		return this.handleResponse(response)
	}

	override fun sendAnimation(animationMessage: AnimationMessage): Message {
		val values =
			jacksonObjectMapper().convertValue(animationMessage, object : TypeReference<MutableMap<String, Any>>() {})
		values["animation"] =
			if (animationMessage.animationIsFile()) animationMessage.animation as File else animationMessage.animation as String
		animationMessage.thumb?.let {
			values["thumb"] = if (animationMessage.thumbIsFile()) it as File else it as String
		}

		val request = unirest
			.post("/sendAnimation")
			.fields(values)
		val response = request
			.asObject(object : GenericType<Response<Message>>() {})

		return this.handleResponse(response)
	}

	override fun sendVoice(voiceMessage: VoiceMessage): Message {
		val values =
			jacksonObjectMapper().convertValue(voiceMessage, object : TypeReference<MutableMap<String, Any>>() {})
		values["voice"] = if (voiceMessage.voiceIsFile()) voiceMessage.voice as File else voiceMessage.voice as String

		val request = unirest
			.post("/sendVoice")
			.fields(values)
		val response = request
			.asObject(object : GenericType<Response<Message>>() {})

		return this.handleResponse(response)
	}

	override fun sendVideoNote(videoNoteMessage: VideoNoteMessage): Message {
		val values =
			jacksonObjectMapper().convertValue(videoNoteMessage, object : TypeReference<MutableMap<String, Any>>() {})
		values["video_note"] =
			if (videoNoteMessage.videoNoteIsFile()) videoNoteMessage.videoNote as File else videoNoteMessage.videoNote as String
		videoNoteMessage.thumb?.let {
			values["thumb"] = if (videoNoteMessage.thumbIsFile()) it as File else it as String
		}

		val request = unirest
			.post("/sendVideoNote")
			.fields(values)
		val response = request
			.asObject(object : GenericType<Response<Message>>() {})

		return this.handleResponse(response)
	}

	override fun sendMediaGroup(mediaGroupMessage: MediaGroupMessage): List<Message> {
		val request = unirest
			.post("/sendMediaGroup")
			.header(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.mimeType)
			.body(mediaGroupMessage)
		val response = request
			.asObject(object : GenericType<Response<List<Message>>>() {})

		return this.handleResponse(response)
	}

	override fun sendLocation(locationMessage: LocationMessage): Message {
		val request = unirest
			.post("/sendLocation")
			.header(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.mimeType)
			.body(locationMessage)
		val response = request
			.asObject(object : GenericType<Response<Message>>() {})

		return this.handleResponse(response)
	}

	override fun sendVenue(venueMessage: VenueMessage): Message {
		val request = unirest
			.post("/sendVenue")
			.header(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.mimeType)
			.body(venueMessage)
		val response = request
			.asObject(object : GenericType<Response<Message>>() {})

		return this.handleResponse(response)
	}

	override fun sendContact(contactMessage: ContactMessage): Message {
		val values =
			jacksonObjectMapper().convertValue(contactMessage, object : TypeReference<MutableMap<String, Any>>() {})

		val request = unirest
			.post("/sendContact")
			.fields(values)
		val response = request
			.asObject(object : GenericType<Response<Message>>() {})

		return this.handleResponse(response)
	}

	override fun sendPoll(pollMessage: PollMessage): Message {
		val request = unirest
			.post("/sendPoll")
			.header(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.mimeType)
			.body(pollMessage)
		val response = request
			.asObject(object : GenericType<Response<Message>>() {})

		return this.handleResponse(response)
	}

	override fun getUserProfilePhotos(getUserProfilePhotosMessage: GetUserProfilePhotosMessage): UserProfilePhotos {
		val request = unirest
			.post("/getUserProfilePhotos")
			.header(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.mimeType)
			.body(getUserProfilePhotosMessage)
		val response = request
			.asObject(object : GenericType<Response<UserProfilePhotos>>() {})

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
