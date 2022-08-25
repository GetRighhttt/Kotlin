package basics

fun main(args: Array<String>) {
    /*
    Functions make it easier for us to create logic and code in cleaner ways.

    Functions serve the purpose of acting as a container for logic that we can
    call in our main function that executes that logic.

    Typically, functions are created to do one thing. Having multiple use cases for
    one function is not good practice.
     */

    // here is how we can call a function in main with a minus method on the end
    println(addDigits(5, 8).minus(5)) // returns 5
    println(addDigits(10, 4).plus(20)) // returns 24
    println(addDigits(80, 200).compareTo(180)) // returns -1 for false
    println(addDigits(30, 40)) // returns 40
}

// here we create our first function that returns an integer
fun addDigits(x: Int, y: Int) : Int {
    return if(x > y) y else x * 2
}