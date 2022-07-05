package de.tschuehly.thymeleaflivereloadgradle

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ThymeleafLivereloadGradleApplication

fun main(args: Array<String>) {
	runApplication<ThymeleafLivereloadGradleApplication>(*args)
}
