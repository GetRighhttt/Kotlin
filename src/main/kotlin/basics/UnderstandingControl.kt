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

    if (!(x == y) && y >= 10) println(message = "This is true.") else if (x == 15 || y != x) {
        println("This is not true.")
    }

    /*
    We can also assign values to if statements as well
     */
    val z = if (x <= y) 3 else 4

    val newAnswer = if (y == 10) println(y) else println(y + 1) // short notation

    println(newAnswer)
    println(z)

    // for loop - usually used with the range operator in Kotln.
    var count = 0
    for (i in 0..3) println(count++) // inclusive of all numbers in range


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

    /*
    When statements are like switch statements except they
    come with more functionality than switch statements.
     */
    when (x) {
        in 1..10 -> println("In between 1 and 10")
        in 10..20 -> println("In between 10 and 20")
        else -> println("Above 20.")
    }

    /*
    When statements are also very powerful and can be used with enums, functions, etc. to
    return some values.

    When trying to choose between if and when, you generally want to use when statements when you
    are working with more than two values.
     */
    fun getNewNumber(x: Int) = when (x) {
        2 -> println("Dos")
        3 -> println("Tres")
        4 -> println("Quatro")
        else -> println("Not in the range of 2-4...")
    }
    println(getNewNumber(5)) // prints Not in the range of 2-4...

    /*
    In Kotlin, "if" is an expression, meaning it returns a value.
    So in more complex cases and when working with more professional code bases, often
    if we be used with short syntax.

    We don't need to declare a specific variable or use much syntax to provide a value here.

    Single-line functions and statements in Kotlin are cool, but we should use them with caution, as
    it can become very confusing.
     */

    fun getName(a: Boolean): String = if (a) "Stefan" else "Bob"
    println(getName(true)) // prints Stefan
}