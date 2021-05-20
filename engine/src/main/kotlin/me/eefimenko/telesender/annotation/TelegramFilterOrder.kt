package me.eefimenko.telesender.annotation

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS)
annotation class TelegramFilterOrder(val value: Int)
