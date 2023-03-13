package basics

/*
One of the most key reasons as to why we should use Kotlin for Android dev over Java, is the
fact Kotlin handles nulls safely.

In Kotlin, null values are checked by the compiler at compile time, meaning if there is a NPE,
null pointer exception, the program won't run at all, and that will have to be resolved.
 */
fun main() {

    // causes an error that wont compile
    // printNumber(null)

    printNumber(5) // prints 5
}

fun printNumber(number: Int) = println("\n $number") // \n is for a new line.