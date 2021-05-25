package me.eefimenko.telesender.filter

import me.eefimenko.telesender.model.telegram.recieve.Update

/**
 * @author Yauheni Yefimenka
 */
interface TelegramFilter {

	fun handleMessage(update: Update, chain: TelegramFilterChain) {
		chain.doHandle(update)
	}

	fun clearState(update: Update, chain: TelegramFilterChain) {
		chain.doClear(update)
	}

}
