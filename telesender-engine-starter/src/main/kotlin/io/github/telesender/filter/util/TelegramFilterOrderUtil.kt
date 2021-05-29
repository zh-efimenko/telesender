package io.github.telesender.filter.util

import io.github.telesender.filter.TelegramFilter
import io.github.telesender.filter.annotation.TelegramFilterOrder
import org.springframework.core.annotation.AnnotationUtils

/**
 * @author Yauheni Yefimenka
 */
object TelegramFilterOrderUtil {

	fun getOrder(type: Class<out TelegramFilter>): Int {
		return AnnotationUtils.findAnnotation(type, TelegramFilterOrder::class.java)!!.value
	}

}
