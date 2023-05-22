package advanced.functional

/*
Kotlin has a variety of ways in which we can declare functions as objects. This improves code readability, helps
to loosen architecture, and provides easier ways to handle data.
 */

val integerFunction: (Int, Int) -> Int = { a, b -> a * b } // lambda : passing function as expression (short syntax)
val alpha: (Int) -> Int = { i: Int -> i + 1 }
val beta: (Int) -> Unit = { } // returns nothing
fun main() {

    // we can either use invoke() to call the parameters of the function types
    val addition = alpha.invoke(10) + integerFunction.invoke(20, 20)

    // or we can use parentheses
    println(integerFunction(10, 12))
    println(addition)
    println(beta.invoke(100)) // can invoke an int
}