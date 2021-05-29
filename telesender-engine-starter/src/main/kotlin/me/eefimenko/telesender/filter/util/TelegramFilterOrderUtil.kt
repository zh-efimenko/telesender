package me.eefimenko.telesender.filter.util

import me.eefimenko.telesender.filter.TelegramFilter
import me.eefimenko.telesender.filter.annotation.TelegramFilterOrder
import org.springframework.core.annotation.AnnotationUtils

/**
 * @author Yauheni Yefimenka
 */
object TelegramFilterOrderUtil {

	fun getOrder(type: Class<out TelegramFilter>): Int {
		return AnnotationUtils.findAnnotation(type, TelegramFilterOrder::class.java)!!.value
	}

}
