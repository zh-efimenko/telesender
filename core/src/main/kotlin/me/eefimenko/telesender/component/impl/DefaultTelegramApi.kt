package me.eefimenko.telesender.component.impl

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import kong.unirest.ContentType
import kong.unirest.GenericType
import kong.unirest.HttpResponse
import kong.unirest.UnirestInstance
import me.eefimenko.telesender.component.TelegramApi
import me.eefimenko.telesender.model.exception.TelegramApiException
import me.eefimenko.telesender.model.telegram.common.BotCommand
import me.eefimenko.telesender.model.telegram.recieve.*
import me.eefimenko.telesender.model.telegram.send.*
import me.eefimenko.telesender.model.telegram.send.inline.AnswerInlineQuery
import me.eefimenko.telesender.model.telegram.send.media.*
import me.eefimenko.telesender.model.telegram.send.media.group.MediaGroupSendMessage
import mu.KotlinLogging
import org.apache.http.HttpHeaders

/**
 * @author Yauheni Yefimenka
 */
class DefaultTelegramApi(
	private val unirest: UnirestInstance
) : TelegramApi {

	private val log = KotlinLogging.logger {}

	override fun send(message: SendMessage?): Any? {
		return when (message) {
			is ContactSendMessage -> sendContact(message)
			is CopySendMessage -> copyMessage(message)
			is ForwardSendMessage -> forwardMessage(message)
			is LocationSendMessage -> sendLocation(message)
			is PollSendMessage -> sendPoll(message)
			is TextSendMessage -> sendMessage(message)
			is VenueSendMessage -> sendVenue(message)
			is AnimationSendMessage -> sendAnimation(message)
			is AudioSendMessage -> sendAudio(message)
			is DocumentSendMessage -> sendDocument(message)
			is PhotoSendMessage -> sendPhoto(message)
			is VideoNoteSendMessage -> sendVideoNote(message)
			is VideoSendMessage -> sendVideo(message)
			is VoiceSendMessage -> sendVoice(message)
			is MediaGroupSendMessage -> sendMediaGroup(message)
			null -> null
			else -> IllegalArgumentException("The follow type is not supported")
		}
	}

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

	override fun sendMessage(message: TextSendMessage): Message {
		val request = unirest
			.post("/sendMessage")
			.header(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.mimeType)
			.body(message)
		val response = request
			.asObject(object : GenericType<Response<Message>>() {})

		return this.handleResponse(response)
	}

	override fun copyMessage(message: CopySendMessage): MessageId {
		val request = unirest
			.post("/copyMessage")
			.header(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.mimeType)
			.body(message)
		val response = request
			.asObject(object : GenericType<Response<MessageId>>() {})

		return this.handleResponse(response)
	}

	override fun forwardMessage(message: ForwardSendMessage): Message {
		val request = unirest
			.post("/forwardMessage")
			.header(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.mimeType)
			.body(message)
		val response = request
			.asObject(object : GenericType<Response<Message>>() {})

		return this.handleResponse(response)
	}

	override fun sendPhoto(message: PhotoSendMessage): Message {
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

	override fun sendAudio(message: AudioSendMessage): Message {
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

	override fun sendDocument(message: DocumentSendMessage): Message {
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

	override fun sendVideo(message: VideoSendMessage): Message {
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

	override fun sendAnimation(message: AnimationSendMessage): Message {
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

	override fun sendVoice(message: VoiceSendMessage): Message {
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

	override fun sendVideoNote(message: VideoNoteSendMessage): Message {
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

	override fun sendMediaGroup(message: MediaGroupSendMessage): List<Message> {
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

	override fun sendLocation(message: LocationSendMessage): Message {
		val request = unirest
			.post("/sendLocation")
			.header(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.mimeType)
			.body(message)
		val response = request
			.asObject(object : GenericType<Response<Message>>() {})

		return this.handleResponse(response)
	}

	override fun sendVenue(message: VenueSendMessage): Message {
		val request = unirest
			.post("/sendVenue")
			.header(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.mimeType)
			.body(message)
		val response = request
			.asObject(object : GenericType<Response<Message>>() {})

		return this.handleResponse(response)
	}

	override fun sendContact(message: ContactSendMessage): Message {
		val request = unirest
			.post("/sendContact")
			.header(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.mimeType)
			.body(message)
		val response = request
			.asObject(object : GenericType<Response<Message>>() {})

		return this.handleResponse(response)
	}

	override fun sendPoll(message: PollSendMessage): Message {
		val request = unirest
			.post("/sendPoll")
			.header(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.mimeType)
			.body(message)
		val response = request
			.asObject(object : GenericType<Response<Message>>() {})

		return this.handleResponse(response)
	}

	override fun getUserProfilePhotos(message: GetUserProfilePhotosSendMessage): UserProfilePhotos {
		val request = unirest
			.post("/getUserProfilePhotos")
			.header(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.mimeType)
			.body(message)
		val response = request
			.asObject(object : GenericType<Response<UserProfilePhotos>>() {})

		return this.handleResponse(response)
	}

	override fun deleteMessage(message: DeleteMessage): Boolean {
		val request = unirest
			.post("/deleteMessage")
			.header(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.mimeType)
			.body(message)
		val response = request
			.asObject(object : GenericType<Response<Boolean>>() {})

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

	override fun setMyCommands(message: SetMyCommandsMessage): Boolean {
		val request = unirest
			.post("/setMyCommands")
			.header(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.mimeType)
			.body(message)
		val response = request
			.asObject(object : GenericType<Response<Boolean>>() {})

		return this.handleResponse(response)
	}

	override fun getMyCommands(): List<BotCommand> {
		val response = unirest
			.get("/getMyCommands")
			.asObject(object : GenericType<Response<List<BotCommand>>>() {})

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
