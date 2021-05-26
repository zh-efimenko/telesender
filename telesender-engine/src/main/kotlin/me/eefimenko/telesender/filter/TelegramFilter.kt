package me.eefimenko.telesender.filter

import me.eefimenko.telesender.model.telegram.recieve.Update

/**
 * @author Yauheni Yefimenka
 */
interface TelegramFilter {

	/**
	 * The key is text of the command, 1-32 characters.
	 * Can contain only lowercase English letters, digits and underscores. And command must start with /.
	 *
	 * The value is description
	 */
	fun getCommands(): Map<String, String>

	fun handleMessage(update: Update, chain: TelegramFilterChain) {
		chain.doHandle(update)
	}

	fun clearState(update: Update, chain: TelegramFilterChain) {
		chain.doClear(update)
	}

}
