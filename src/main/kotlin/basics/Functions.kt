package basics

    /*
   Functions make it easier for us to create logic and code in cleaner ways.

   Functions serve the purpose of acting as a container for logic that we can
   call in our main function that executes that logic.

   Typically, functions are created to do one thing. Having multiple use cases for
   one function is not good practice.

   Note* - these are just the basics, and we will discuss more of Kotlin's advanced functional methods in other sections.
    */

fun main() {

    /*
    In Kotlin, we can use functions without have to explicitly put them in a class like we do in
    Java.

    So these methods below you will see can be called in the main function.
    */

    // here we create our first function that returns an integer
    fun addDigits(x: Int, y: Int): Int = if (x > y) y else x * 2


    // this is a function without any parameters or return type
    fun printThisLine() {
        println("This is the most basic function syntactically however " +
                "it's probably the best approach when working with other devs.")
    }

    // this is a function that takes in two parameters for calculations
    fun doSomeCalculations(y: Int, x: Int) {
        val addition = x + y
        println(addition)
    }

    // if a function is short and doesn't have a return type, we can omit the curly brackets
    fun getName(name: String) = "My name is: $name"

    // gets the name
    println(getName("Stefan"))

    // println() function
    println(printThisLine())


    // calculations function
    println(doSomeCalculations(10, 20))

    // here is how we can call a function in main with a minus method on the end
    println(addDigits(5, 8).minus(5)) // returns 5
    println(addDigits(10, 4).plus(20)) // returns 24
    println(addDigits(80, 200).compareTo(180)) // returns -1 for false
    println(addDigits(30, 40)) // returns 60
}