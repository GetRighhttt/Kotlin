package advancedkotlin.functional

/*
Function type examples with lambdas.
 */

val integerFunction: (Int, Int) -> Int = { a, b -> a * b } // lambda : passing function as expression (short syntax)
val beta: (Int) -> Unit = { } // returns nothing
val alpha: (Int) -> Int = { i: Int -> i + 1 }
val delta: (Int, Int) -> Int = { x, y -> x / y }
val multiplyNum: (Double) -> Double = { x -> x * 10 }
fun main() {

    // we can either use invoke() to call the parameters of the function types
    val addition = alpha.invoke(10) + integerFunction.invoke(20, 20)

    // or we can use parentheses
    println(integerFunction(10, 12))
    println(addition)
    println(alpha(30)) // output should be 31
    println(beta.invoke(100)) // returns nothing
    println(delta.invoke(20, 2)) // output should be 10

    // with reading in values and extension function
    val multiplication by lazy { readlnOrNull()?.toDouble() }
    println(multiplication?.let { multiplyNum.invoke(it) }) // takes in a number and multiplies it by 10
}

/*
120
411
31
kotlin.Unit
10
 */