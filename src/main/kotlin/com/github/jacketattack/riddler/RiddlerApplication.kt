 package com.github.jacketattack.riddler

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RiddlerApplication

fun main(args: Array<String>) {
	runApplication<RiddlerApplication>(*args)
}
