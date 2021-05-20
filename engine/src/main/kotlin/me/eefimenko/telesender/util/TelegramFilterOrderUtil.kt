package me.eefimenko.telesender.util

import me.eefimenko.telesender.annotation.TelegramFilterOrder
import me.eefimenko.telesender.filter.TelegramFilter
import org.springframework.core.annotation.AnnotationUtils

object TelegramFilterOrderUtil {

	fun getOrder(type: Class<out TelegramFilter>): Int {
		return AnnotationUtils.findAnnotation(type, TelegramFilterOrder::class.java)!!.value
	}

}
