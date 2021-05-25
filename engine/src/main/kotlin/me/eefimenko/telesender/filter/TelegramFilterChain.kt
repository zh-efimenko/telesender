package me.eefimenko.telesender.filter

import me.eefimenko.telesender.model.telegram.recieve.Update

/**
 * @author Yauheni Yefimenka
 */
interface TelegramFilterChain {

	fun doHandle(update: Update)

	fun doClear(update: Update)

}
