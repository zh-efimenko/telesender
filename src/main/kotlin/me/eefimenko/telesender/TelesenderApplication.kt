package me.eefimenko.telesender

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TelesenderApplication

fun main(args: Array<String>) {
	runApplication<TelesenderApplication>(*args)
}
