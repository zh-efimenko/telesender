package me.eefimenko.telesender.filter

import me.eefimenko.telesender.annotation.TelegramFilterOrder
import me.eefimenko.telesender.component.TelegramApi
import me.eefimenko.telesender.model.telegram.recieve.Chat
import me.eefimenko.telesender.model.telegram.recieve.Update
import java.util.*

/**
 * @author Yauheni Yefimenka
 */
@TelegramFilterOrder(200)
class CallbackQueryFilter(
	private val telegramApi: TelegramApi
) : TelegramFilter {

	override fun handleMessage(update: Update, chain: TelegramFilterChain) {
		if (Objects.isNull(update.callbackQuery)) {
			chain.doFilter(update)
			return
		}

		val callbackQuery = update.callbackQuery!!
	}

	override fun clearState(chat: Chat) {
//		TODO("Not yet implemented")
	}

}