package io.github.telesender.filter

import io.github.telesender.model.telegram.recieve.Update

/**
 * @author Yauheni Yefimenka
 */
class DefaultTelegramFilterChain(filters: List<TelegramFilter>) : TelegramFilterChain {

	private val iterator: Iterator<TelegramFilter> = filters.iterator()

	override fun doHandle(update: Update) {
		if (iterator.hasNext()) {
			val filter = iterator.next()
			filter.handleMessage(update, this)
		}
	}

	override fun doClear(update: Update) {
		if (iterator.hasNext()) {
			val filter = iterator.next()
			filter.clearState(update, this)
		}
	}

}
