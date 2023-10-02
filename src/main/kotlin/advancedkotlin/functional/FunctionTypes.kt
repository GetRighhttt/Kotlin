package advancedkotlin.functional

/*
Function type examples with lambdas.

Closure -> scope of variables accessible in the body of a function.
 */

val integerFunction: (Int, Int) -> Int = { a, b -> a * b } // lambda : passing function as expression (short syntax)
val beta: (Int) -> Unit = { } // returns nothing
val alpha: (Int) -> Int = { i: Int -> i + 1 }
val delta: (Int, Int) -> Int = { x, y -> x / y }
val multiplyNum: (Double) -> Double = { x -> x * 10 }

// we can also use function types in higher order functions
fun divideNumb(
    a: Double,
    v: Double,
    c: (Double, Double) -> Double
): Double {
    return c(a, v)
}

val convertNumToDouble by lazy { readlnOrNull()?.toInt() }

fun main() {

    // we can either use invoke() to call the parameters of the function types
    val addition = alpha.invoke(10) + integerFunction.invoke(20, 20)

    val divider = divideNumb(
        10.0,
        12.0,
        c = { a, v -> a / v }
    )

    // or we can use parentheses
    println(convertNumToDouble?.let { alpha.invoke(it) })
    println(integerFunction(10, 12))
    println(addition)
    println(alpha(30)) // output should be 31
    println(beta.invoke(100)) // returns nothing
    println(delta.invoke(20, 2)) // output should be 10
    println(divider) // 0.8333333333333334

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