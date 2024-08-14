package basics

fun main() {
    /*
    So comparison and logical operators are essentially how we work
    with loops in kotlin and are the foundational building blocks of
    programming in general.
    */

    val x = 8
    val y = 9

    /*
    First we examine some comparison operators
     */
    // checking to see if x is equal to y below
    println(x == y) // false

    // checking to se if x is less than y
    println(x < y) // true

    // checking if x is greater than or equal to y
    println(x >= y) // false

    // checking to see if x is not equal to y
    println(x != y) // true

    /*
    Now we can go over logical operators:

    || = or
    && = and

    Also, the and operator is stronger than the or operator with
    order of operations
     */
    println(x == y || x < y) // true

    // not operator
    println(!(x == y || x < y)) // false because of not operator

    /*
    If statements in Kotlin are seen as expressions.
     */
    fun returnNumber(x: Int, y: Int): Int = if (x == y) 0 else 10

    val number1 = returnNumber(10, 10)
    println(number1)

    // 0
}