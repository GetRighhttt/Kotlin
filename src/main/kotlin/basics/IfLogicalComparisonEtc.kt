package basics

fun main() {
    /**
     * Comparison operators produce Boolean values.
     * Logical operators combine those values into conditions for if and loops.
    */

    val x = 8
    val y = 9

    // checking to see if x is equal to y below
    println(x == y) // false

    // checking to see if x is less than y
    println(x < y) // true

    // checking if x is greater than or equal to y
    println(x >= y) // false

    // checking to see if x is not equal to y
    println(x != y) // true

    /**
     * || = or
     * && = and
     *
     * && has higher precedence than ||. Parentheses make the grouping explicit.
     * Both short-circuit: the right side is evaluated only if it is needed.
     */
    println(x == y || x < y) // true

    // not operator
    println(!(x == y || x < y)) // false because of not operator

    /**
     * If statements in Kotlin are seen as expressions.
     */
    fun returnNumber(x: Int, y: Int): Int = if (x == y) 0 else 10

    val number1 = returnNumber(10, 10)
    println(number1) // 0
}
