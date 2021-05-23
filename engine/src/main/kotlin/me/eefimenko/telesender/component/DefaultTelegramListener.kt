package me.eefimenko.telesender.component

import me.eefimenko.telesender.filter.DefaultTelegramFilterChain
import me.eefimenko.telesender.filter.TelegramFilter
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
