package me.eefimenko.telesender.filter

import me.eefimenko.telesender.model.telegram.recieve.Chat
import me.eefimenko.telesender.model.telegram.recieve.Update

/**
 * @author Yauheni Yefimenka
 */
interface TelegramFilter {

	fun handleMessage(update: Update, chain: TelegramFilterChain)

	fun clearState(chat: Chat)

}
