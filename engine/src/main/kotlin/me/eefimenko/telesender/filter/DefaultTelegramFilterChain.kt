package me.eefimenko.telesender.filter

import me.eefimenko.telesender.model.telegram.recieve.Update

/**
 * @author Yauheni Yefimenka
 */
class DefaultTelegramFilterChain(filters: List<TelegramFilter>) : TelegramFilterChain {

	private val iterator: Iterator<TelegramFilter> = filters.iterator()

	override fun doFilter(update: Update) {
		if (iterator.hasNext()) {
			val filter = iterator.next()
			filter.handleMessage(update, this)
		}
	}

}
