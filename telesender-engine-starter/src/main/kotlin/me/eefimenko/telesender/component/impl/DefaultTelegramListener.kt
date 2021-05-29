package me.eefimenko.telesender.component.impl

import me.eefimenko.telesender.component.TelegramListener
import me.eefimenko.telesender.filter.DefaultTelegramFilterChain
import me.eefimenko.telesender.filter.TelegramFilter
import me.eefimenko.telesender.filter.util.TelegramFilterOrderUtil
import me.eefimenko.telesender.model.event.TelegramUpdateEvent

/**
 * @author Yauheni Yefimenka
 */
class DefaultTelegramListener(filters: List<TelegramFilter>) : TelegramListener {

	private val filters: List<TelegramFilter> = filters.sortedBy {
		TelegramFilterOrderUtil.getOrder(it::class.java)
	}

	override fun onMessage(event: TelegramUpdateEvent) {
		val chain = DefaultTelegramFilterChain(filters)
		chain.doHandle(event.update)
	}

}
