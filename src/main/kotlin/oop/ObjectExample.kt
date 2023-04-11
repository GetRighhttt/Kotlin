package oop

import kotlin.concurrent.thread

/*
In Kotlin, we do not use the word "static" like we did in Java. So, in order for us
to create singletons, and declare static variables, we use the keywords "object" and
"companion object".

Objects behave just like classes and can have properties, methods, and initializers,
but they cannot be instantiated.
 */
object Customer {
    private var count: Int = 0 // behaves as static variable

    init {
        println("\nCustomer object has been created...")
        println("Initializing count...\n")
        println("Determining customer type...")

        count = 205
    }

    fun returnCount(): Int = count
    fun typeOfCustomer() = println("American")
}

class Person {

    /*
    Companion objects work just like objects except are held within classes.
     */
    companion object { // behaves like singleton object
        var newName = ""
        private var age = 0

        init {
            println("\nCompanion object has been created.")
            println("Determining name and age...\n")

            newName = "Bob"
            age = 30
        }

        @JvmStatic // makes it behave like a static method and can be used in java file. (Optional here)
        fun getName() = newName

        fun returnAge() = age
    }

    fun notInTheCompanionObject() = println("Not apart of the companion object...")
}

fun main() {
    /*
    SO in order for us to use these static methods and variables, instead of us instantiating a class,
    we just use dot notation. Kotlin by default creates an instance for us.
     */
    println(Customer.returnCount()) // 100
    Customer.typeOfCustomer() // American

    println(Person.getName())
    println(Person.returnAge())

    /*
    Below we show what happens in regular classes when you don't use a companion object or declare an object
    by itself. Must create an instance and then call that instance method using dot notation.
     */
    println("Declaring a regular object of the companion object demonstration..")
    Thread.sleep(2000)
    val notCompanion = Person()
    println(notCompanion.notInTheCompanionObject())
}
