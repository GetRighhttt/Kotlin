package advancedkotlin.functional

/**
 * Function type examples with lambdas.
 *
 * Closure -> scope of variables accessible in the body of a function.
 */

val integerMultiplyFunction: (Int, Int) -> Int =
    { a, b -> a * b } // lambda : passing function as expression (short syntax)
val beta: (Int) -> Unit = { } // returns nothing as noted by "Unit"
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
    val addition = alpha.invoke(10) + integerMultiplyFunction.invoke(20, 20)

    // showing how to read user input and convert to double also calling a function
    val divider = readlnOrNull()?.toDouble()?.let { firstNumber ->
        readlnOrNull()?.toDouble()?.let { secondNumber ->
            divideNumb(
                a = firstNumber, // read in first number
                v = secondNumber, // read in second number
                c = { a, v -> a / v } // taking in both values and dividing them
            )
        }
    }

    // or we can use parentheses
    println(divider) // takes in two numbers and divides them
    println(convertNumToDouble?.let { alpha.invoke(it) }) // 21
    println(integerMultiplyFunction(10, 12))
    println(addition)
    println(alpha(30)) // output should be 31
    println(beta.invoke(100)) // returns nothing
    println(delta.invoke(20, 2)) // output should be 10

    // with reading in values and extension function
    val multiplication by lazy { readlnOrNull()?.toDouble() }
    multiplication?.let { multiplyNum.invoke(it) } // takes in a number and multiplies it by 10
}

/**
 * 120
 * 411
 * 31
 * kotlin.Unit
 * 10
 */