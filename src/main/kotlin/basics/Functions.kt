package basics

/**
 * Functions give a name to a piece of logic so we can call it again.
 * Keep each function focused on one task so its name tells us what to expect.
 *
 * These examples are local functions: they can only be used inside main().
 * Kotlin also supports top-level functions, as shown in VarArgDefaultNames.kt.
 */
fun main() {
    // A block body uses return to send a result back to the caller.
    fun addDigits(x: Int, y: Int): Int {
        return x + y
    }

    // A function that only prints has return type Unit. We can omit : Unit.
    fun printThisLine() {
        println("This function prints a line.")
    }

    fun doSomeCalculations(x: Int, y: Int) {
        println(x + y)
    }

    // An expression body uses =. The compiler infers String as the return type.
    fun getName(name: String) = "My name is: $name"
    println(getName("Stefan")) // My name is: Stefan

    // :: creates a function reference. Storing it does not call the function.
    val printLine = ::printThisLine
    printLine() // This function prints a line.

    // Parentheses and invoke() both call a function reference.
    val calculate = ::doSomeCalculations
    calculate.invoke(10, 20) // 30

    val add = ::addDigits
    println(add(5, 8)) // 13
    println(add.invoke(10, 4)) // 14

    // Once we have the returned Int, we can call other Int methods on it.
    println(add(5, 8).minus(5)) // 8
    println(add(10, 4).plus(20)) // 34
    println(add(80, 200).compareTo(180)) // 1: 280 is greater than 180
}
