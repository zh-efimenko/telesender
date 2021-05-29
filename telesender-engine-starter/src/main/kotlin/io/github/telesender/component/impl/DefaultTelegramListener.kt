package io.github.telesender.component.impl

import io.github.telesender.component.TelegramListener
import io.github.telesender.filter.DefaultTelegramFilterChain
import io.github.telesender.filter.TelegramFilter
import io.github.telesender.filter.util.TelegramFilterOrderUtil
import io.github.telesender.model.event.TelegramUpdateEvent

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
