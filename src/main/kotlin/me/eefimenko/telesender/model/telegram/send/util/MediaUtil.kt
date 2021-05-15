package me.eefimenko.telesender.model.telegram.send.util

import java.io.File

fun mediaStringOrFile(obj: Any?): Pair<String?, File?> {
	return when (obj) {
		null -> {
			Pair<String?, File?>(null, null)
		}
		is String -> {
			Pair<String?, File?>(obj, null)
		}
		is File -> {
			Pair<String?, File?>("attach://${obj.name}", obj)
		}
		else -> throw IllegalArgumentException("Object must be only String or File")
	}
}
