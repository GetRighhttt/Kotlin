package advanced.functional

/*
Kotlin's functions are known as first class, which essentially means they can be sorted in variables,
objects, and other data structures, and can be passed as arguments, and returned to other higher order functions.

Lambdas are just anonymous functions used as an expression with no declaration. i.e { a, b -> a + b }

The full syntactic expression for a lambda is as follows:
val add: (Int, Int) -> Int = { a: Int, b: Int -> a + b }

Examples: https://kotlinlang.org/docs/lambdas.html#underscore-for-unused-variables
 */
fun main() {

    /*
    friend = name of lambda
    (String) -> String = type
     name: String = arguments
     -> name.lowercase() = body

    we usually only use the arguments and body of the lambda.
     */
    val friend: (String) -> String = { name: String -> name.lowercase() }
    println(friend("Bobby")) // bobby

    val justTheArgumentsAndBody = { a: Int, b: Int -> a + b }
    println(justTheArgumentsAndBody(3, 4)) // 7
    println(" ${friend("Stefan")} is ${justTheArgumentsAndBody(10, 18)} years old!") //  stefan is 28 years old!


}
