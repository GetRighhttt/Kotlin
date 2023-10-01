package advancedkotlin.functional

import java.lang.NumberFormatException

/*
Extension function to swap numbers in a mutable list. This is what we are going to use to decipher what letters we are
going to use.
 */
fun MutableList<Int>.switchNumbers(index1: Int, index2: Int) {
    val temp = this[index1]
    this[index1] = this[index2]
    this[index2] = temp
}

fun main() {
    /*
    In Kotlin, we have the capability to extend functions when we want to apply
    a built-in function to a variable, or if we want to extend the functionality of a
    class that is defined as Final.

    This is a unique feature that Kotlin has allowed us to use.
     */

    println("Please enter a number:")
    // Exception handling
    try {
        val newNumber by lazy { readlnOrNull()?.toInt() }

        // null check is always necessary for readLine values
        if (newNumber != null) {
            if (newNumber?.isPrime() == true)
                println("is a prime number") else println("not prime")
        }
    } catch (e: NumberFormatException) {
        println("Exception: $e")
    }


    println("Please enter a name:")
    // Exception Handling
    try {
        val newName by lazy { readlnOrNull() }

        println(newName?.isNice())
        println(newName?.isNotHealthy())
        println(newName?.hideName())
        println(newName?.repeatName())
    } catch (e: RuntimeException) {
        println("Exception: $e")
    }

    val list = mutableListOf(3, 6, 9, 12, 14, 5, 7, 10)
    list.switchNumbers(0, 1)
    list.switchNumbers(1, 2)
    list.switchNumbers(2, 3)
    println(list.toString())

    val doubleToInt = 38.6
    println(doubleToInt.convertToInt())
}

/*
This is how we can use an extension function to check and see if a number is Prime.

We do this by prefixing the function with the name of the class that we would like to extend.
 */
fun Int.isPrime(): Boolean {
    for (i in 2 until this - 1) {
        if (this % i == 0)
            return false
    }
    return true
}

/*
Another example of an extension function that extends the String class.
 */
fun String.isNice(): Boolean {
    this.length > 4
    return true
}
fun String.isNotHealthy(): Boolean {
    this.length < 4 && this.startsWith("s", false)
    return true
}
fun String.hideName() = "*".repeat(this.length)
fun String.repeatName() = this.repeat(3).toList().forEach(::println)
fun Double.convertToInt(): Int = this.toInt()
/*
Please enter a number:
40
is a prime number
Please enter a name:
Stefan
true
******
S
t
e
f
a
n
S
t
e
f
a
n
S
t
e
f
a
n
[6, 9, 12, 3]
 */