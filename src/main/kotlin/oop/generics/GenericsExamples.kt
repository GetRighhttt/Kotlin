package oop.generics

// Invariant: Box<String> is not a Box<Any>. It both accepts and returns T.
class Box<T>(var value: T)

// in permits T in input positions. A consumer of Any can consume a String too.
interface Consumer<in T> { fun consumer(item: T) }
class ShowConsumer : Consumer<String> {
    override fun consumer(item: String) { println("$item has been consumed as input.") }
}

// out permits T in output positions. A producer of String can be used as Producer<Any>.
interface Producer<out T> { fun producer(): T }
class ShowProducer : Producer<String> {
    override fun producer(): String = "We are producing this string without any input."
}

fun main() {
    val box = Box("Kotlin")
    box.value = "More Kotlin"
    println(box.value) // More Kotlin
    // val anyBox: Box<Any> = box // Does not compile: Box is invariant.

    val stringProducer: Producer<String> = ShowProducer()
    val anyProducer: Producer<Any> = stringProducer
    println(anyProducer.producer())

    val anyConsumer: Consumer<Any> = object : Consumer<Any> {
        override fun consumer(item: Any) { println("Consumed: $item") }
    }
    val stringConsumer: Consumer<String> = anyConsumer
    stringConsumer.consumer("Item") // Consumed: Item
    ShowConsumer().consumer("Kotlin")
}
