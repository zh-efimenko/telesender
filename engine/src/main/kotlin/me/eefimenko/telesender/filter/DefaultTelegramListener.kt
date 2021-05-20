package me.eefimenko.telesender.filter

import me.eefimenko.telesender.component.TelegramListener
import me.eefimenko.telesender.model.event.TelegramUpdateEvent
import me.eefimenko.telesender.util.TelegramFilterOrderUtil

class DefaultTelegramListener(filters: List<TelegramFilter>) : TelegramListener {

	private val filters: List<TelegramFilter> = filters.sortedBy {
		TelegramFilterOrderUtil.getOrder(it::class.java)
	}

	override fun onMessage(event: TelegramUpdateEvent) {
		val chain = DefaultTelegramFilterChain(filters)
		chain.doFilter(event.update)
	}

}
