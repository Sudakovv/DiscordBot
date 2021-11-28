package com.mihail.discordbot.work

import dev.kord.core.Kord
import dev.kord.core.entity.Message
import dev.kord.core.entity.ReactionEmoji
import dev.kord.core.event.message.MessageCreateEvent
import dev.kord.core.on
import kotlinx.coroutines.delay


class FillBot {
    suspend fun start() {
        println("Бот работает")
        val client = Kord(System.getenv("DISCORD_BOT"))

        client.on<MessageCreateEvent> {
            when (message.content) {
                "*ping" -> pong(message)
                "*hello" -> hello(message)
            }
        }
        client.login()
    }

    private suspend fun hello(message: Message) {
        message.channel.createMessage("hello")
    }

    private suspend fun pong(message: Message) {
        val pingPong = ReactionEmoji.Unicode("\uD83C\uDFD3")

        val response = message.channel.createMessage("Pong!")
        response.addReaction(pingPong)

        delay(5000)
        message.delete()
        response.delete()
    }
}