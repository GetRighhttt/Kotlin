package androidconcepts

import java.util.concurrent.TimeUnit
import kotlin.concurrent.thread

/*
A Backing Field is essentially just the "field" keyword we use when we want to customize
our getters and setters for variables.

field holds the value of the variable that we declare

The backing field is not generated unless required.
 */
class Human {

    init {
        println("----------------------------------------------------\n")
        println("Human class has been instantiated...")
        println("Continue...")
        println("----------------------------------------------------\n")
    }

    var age: Int = 0
        get() {
            return field // returns the age value
        }
        set(value) { // sets age value usually based on a condition
            field = when (value) {
                in 1..10 -> value - 5
                in 11..20 -> value + 20
                in 21..30 -> value + 30
                else -> value + 50
            }
        }

    private val isOld: Boolean // no backing field generated
        get() = age >= 50

    private val isYoung: Boolean // no backing field generated
        get() = age <= 30

    private val isMiddleAge: Boolean // no backing field generated
        get() = age in 31..49

    private val isABaby: Boolean
        get() = age <= 5

    fun getAgeFromBackingField() = age

    fun determineAgeBracket() = when {
            isYoung -> println("You are young!")
            isMiddleAge -> println("You are middle aged!")
            isOld -> println("You are old!")
            isABaby -> println("You are a baby!")
            else -> println("Error: Cannot detect age...")
        }

}

fun main() {

    println("Main Program started...\n")
    println("Enter a number to determine age: ")

    val userInput = readLine()
    val userAge = when (userInput?.toInt()) {
        in 1..10 -> userInput?.plus(10)
        in 11..20 -> userInput?.plus(20)
        in 21..30 -> userInput?.plus(30)
        else -> userInput?.plus(50)
    }

    println("Your age after setter modification is: $userAge\n")
    println("Now let's create a Human object:")

    val newHuman = Human() // Human instantiation

    newHuman.age = 40 // since it's 40, it should add 50 to it based on the custom setter
    println("The value of the backing field after the setter is: ${newHuman.getAgeFromBackingField()}") // 90

    newHuman.age = 25 // should add 30 to it.
    println("The value of the backing field after the setter is: ${newHuman.getAgeFromBackingField()}") // 55

    newHuman.determineAgeBracket() // prints "You are old!" because it's value is 55.

}