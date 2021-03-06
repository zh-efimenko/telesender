package io.github.telesender.filter.annotation

/**
 * @author Yauheni Yefimenka
 */
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS)
annotation class TelegramFilterOrder(val value: Int)
