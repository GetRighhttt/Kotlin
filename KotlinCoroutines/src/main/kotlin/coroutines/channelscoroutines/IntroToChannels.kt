package coroutines.channelscoroutines

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel

/*
Channels allow coroutines to communicate with each other, and are similar to queue data
structure. They are used for asynchronous communication between Coroutines.

One or more producer coroutines can write to a channel, and one or more receiver coroutines
can read from the channel. This is done sequentially: in order.

Elements are processed in the same order that they are received.

Channels have two main methods: send() and receive().
 */

fun main(): Unit = runBlocking{
    val basket = Channel<String>()

    launch { // coroutine1
        val fruits = listOf("Apple", "Orange")
        for (fruit in fruits) {
            println("coroutine1: Sending $fruit")
            basket.send(fruit)
        }
    }

    launch { // coroutine2
        repeat(2) {
            delay(100)
            println("coroutine2: Received ${basket.receive()}")
        }
    }
}