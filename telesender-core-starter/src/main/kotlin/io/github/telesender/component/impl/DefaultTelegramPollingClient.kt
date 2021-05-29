package io.github.telesender.component.impl

import io.github.telesender.component.TelegramApi
import io.github.telesender.component.TelegramPollingClient
import io.github.telesender.model.event.TelegramUpdateEvent
import mu.KotlinLogging
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.ApplicationEventPublisher
import org.springframework.context.ApplicationListener
import java.util.concurrent.TimeUnit
import javax.annotation.PreDestroy

/**
 * @author Yauheni Yefimenka
 */
class DefaultTelegramPollingClient(
	private val telegramApi: TelegramApi,
	private val eventPublisher: ApplicationEventPublisher
) : TelegramPollingClient, ApplicationListener<ApplicationReadyEvent> {

	private val log = KotlinLogging.logger {}
	private val client = Client()

	override fun onApplicationEvent(event: ApplicationReadyEvent) {
		this.start()
	}

	override fun start() {
		log.info("Telegram client: POLLING")
		client.start()
	}

	@PreDestroy
	override fun shutdown() {
		client.interrupt()
		client.join()
	}

	private inner class Client : Thread("PollingClient") {

		private var offset: Long = 0

		override fun run() {
			while (!isInterrupted) {
				try {
					val updates = telegramApi.getUpdates(offset, POLLING_TIMEOUT)

					if (updates.isEmpty()) {
						continue
					}

					// handle updates
					for (update in updates) {
						log.debug("Got a new event: {}", update)
						eventPublisher.publishEvent(TelegramUpdateEvent(update))
					}

					offset = updates.last().updateId + 1
				} catch (e: Exception) {
					log.error("Exception during polling messages", e)
					TimeUnit.SECONDS.sleep(100)
				}
			}
		}

	}

	companion object {
		private const val POLLING_TIMEOUT = 1000
	}

}
