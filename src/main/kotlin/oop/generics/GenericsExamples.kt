package oop.generics

/*
Let's go over a few Generic examples
 */

// Invariant type which is just a basic generic
interface BasicGeneric<T> {
     fun genericType()
}

class Basic: BasicGeneric<Any> {
     override fun genericType() {
          println("Just a generic class.")
     }

}

// Consumer interface that only consumes values I.E no return type
interface Consumer<in T> {
     fun consumer(item: T)
}

class ShowConsumer: Consumer<String> {
     override fun consumer(item: String) {
          println("$item has been Consumed as input.")
     }

}

// Producer interface that only produces values I.E has a return type
interface Producer<out T> {
     fun producer(): T
}

class ShowProducer: Producer<String> {
     override fun producer(): String = "We are producing this string without any input."
}

fun main() {

     val genericExample = Basic()
     genericExample.genericType() // Just a generic class.

     val stringConsumer = ShowConsumer()
     stringConsumer.consumer("Item") // Item has been Consumed as input.

     val stringProducer = ShowProducer()
     println(stringProducer.producer()) // We are producing this string without any input.
}