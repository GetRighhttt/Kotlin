package advancedkotlin.functional

/**
 * (Int, Int) -> Int takes two Ints and returns an Int.
 * A function value can be stored, passed to another function, or returned.
 */
val integerMultiplyFunction: (Int, Int) -> Int = { a, b -> a * b }
val beta: (Int) -> Unit = { number -> println("Received $number") }
val alpha: (Int) -> Int = { it + 1 }
val delta: (Int, Int) -> Int = { x, y ->
    require(y != 0) { "Cannot divide by zero." }
    x / y
}
val multiplyNum: (Double) -> Double = { it * 10 }

fun divideNumb(a: Double, b: Double, operation: (Double, Double) -> Double): Double {
    return operation(a, b)
}

fun main() {
    // invoke() and parentheses are two ways to call the same function value.
    println(integerMultiplyFunction.invoke(10, 12)) // 120
    println(alpha(10) + integerMultiplyFunction(20, 20)) // 411
    println(alpha(30)) // 31
    beta(100) // Received 100; call directly because its result is Unit.
    println(delta(20, 2)) // 10
    println(divideNumb(20.0, 4.0) { a, b -> a / b }) // 5.0
    println(multiplyNum(4.0)) // 40.0

    // A closure captures variables from the surrounding scope.
    var increment = 2
    val addIncrement: (Int) -> Int = { it + increment }
    println(addIncrement(10)) // 12
    increment = 5
    println(addIncrement(10)) // 15: the captured variable has changed.
}
