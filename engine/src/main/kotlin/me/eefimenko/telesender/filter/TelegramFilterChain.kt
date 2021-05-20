package me.eefimenko.telesender.filter

import me.eefimenko.telesender.model.telegram.recieve.Update

interface TelegramFilterChain {

	fun doFilter(update: Update)

}
