package io.github.telesender.component

import io.github.telesender.model.event.TelegramUpdateEvent
import org.springframework.context.event.EventListener

/**
 * @author Yauheni Yefimenka
 */
interface TelegramListener {

	@EventListener
	fun onMessage(event: TelegramUpdateEvent)

}
