package me.eefimenko.telesender.filter

import me.eefimenko.telesender.model.telegram.recieve.Update

interface TelegramFilter {

	fun handleMessage(update: Update, chain: TelegramFilterChain)

}
