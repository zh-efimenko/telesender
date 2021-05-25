package me.eefimenko.telesender

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TelesenderEngineApplication

fun main(args: Array<String>) {
	runApplication<TelesenderEngineApplication>(*args)
}
