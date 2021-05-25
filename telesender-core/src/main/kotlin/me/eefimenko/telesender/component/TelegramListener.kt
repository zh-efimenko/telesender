package me.eefimenko.telesender.component

import me.eefimenko.telesender.model.event.TelegramUpdateEvent
import org.springframework.context.event.EventListener

/**
 * @author Yauheni Yefimenka
 */
interface TelegramListener {

	@EventListener
	fun onMessage(event: TelegramUpdateEvent)

}
