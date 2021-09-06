package com.pinterest.bootcampnavigation_03

import com.github.javafaker.Faker
import java.time.Instant
import java.time.temporal.ChronoUnit
import java.util.Date

class MessageList(listSize: Int = 100) {

    private val faker = Faker()
    private val list: MutableList<Message> = mutableListOf()

    private val lastWeek = Date().apply {
        time = Instant.now().minus(1, ChronoUnit.DAYS).toEpochMilli()
    }

    init {
        (1..listSize).forEach { _ ->
            list.add(
                Message(
                    sender = faker.name().fullName(),
                    body = faker.chuckNorris().fact(),
                    timestamp = faker.date().between(lastWeek, Date()))
            )
        }
    }

    fun getList(): List<Message> {
        return list.toList()
    }
}

data class Message(
    var sender: String,
    val body: String,
    val timestamp: Date
)