package basics

fun main() {

    /**
     * This is going to be a basic example of if
     * statements in Kotlin.
     *
     * for loops are for iterating through collections
     *
     * while loops execute while a condition is met
     *
     * do-while loops do some logic while the condition is met. They
     * always run at least one time.
     */
    val y = 9
    val x = 13

    if (x != y && y >= 10) {
        println("This is true.")
    } else if (x == 15 || y != x) {
        println("This is not true.")
    }

    /**
     * We can also assign values to if statements as well
     */
    val z = if (x <= y) 3 else 4
    if (y == 10) println(y) else println(y + 1) // short notation
    println(z)

    // for loop - usually used with the range operator in Kotlin.
    for (i in 0..3) println(i) // includes both 0 and 3
    var count = 4 // Continue the while example from where the range ended.

    for (i in 0 until 5) println(i) // excludes last number

    // for-each loop - usually used when you want to loop through each element
    for (letter in "Stefan") println(letter.toString().uppercase())

    // while loop
    while (count < x) {
        count++
        println("This is a while loop.")
    }

    // do-while
    do {
        println("This is a do while loop.")
    } while (y > x)

    /**
     * When statements are like switch statements except they
     * come with more functionality than switch statements.
     */
    when (x) {
        in 1..10 -> println("In between 1 and 10")
        in 11..20 -> println("In between 11 and 20")
        else -> println("Outside 1 through 20.")
    }

    /**
     * when can match values, ranges, and types.
     * Each matching branch here prints a message, so getNewNumber returns Unit.
     */
    fun getNewNumber(x: Int) = when (x) {
        2 -> println("Dos")
        3 -> println("Tres")
        4 -> println("Quarto")
        else -> println("Not in the range of 2-4...")
    }
    getNewNumber(5) // prints Not in the range of 2-4...

    /**
     * if is an expression: the chosen branch supplies its result.
     * A short expression body works well when both branches are easy to read.
     */

    fun getName(a: Boolean): String = if (a) "Stefan" else "Bob"
    println(getName(true)) // prints Stefan

    /**
     * This is not true.
     * 10
     * 4
     * 0
     * 1
     * 2
     * 3
     * 0
     * 1
     * 2
     * 3
     * 4
     * S
     * T
     * E
     * F
     * A
     * N
     * This is a while loop.
     * This is a while loop.
     * This is a while loop.
     * This is a while loop.
     * This is a while loop.
     * This is a while loop.
     * This is a while loop.
     * This is a while loop.
     * This is a while loop.
     * This is a do while loop.
     * In between 11 and 20
     * Not in the range of 2-4...
     * Stefan
     */
}
