package io.github.telesender.filter

import io.github.telesender.model.telegram.recieve.Update

/**
 * @author Yauheni Yefimenka
 */
interface TelegramFilterChain {

	fun doHandle(update: Update)

	fun doClear(update: Update)

}
