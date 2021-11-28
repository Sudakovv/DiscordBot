package com.mihail.discordbot

import com.mihail.discordbot.work.FillBot
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DiscordbotApplication

fun main(args: Array<String>) {
	val fillBot = FillBot()
	runApplication<DiscordbotApplication>(*args)
	println("Hello")
	GlobalScope.launch {
		fillBot.start()
	}
}
