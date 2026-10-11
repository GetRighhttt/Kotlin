package advancedkotlin.functional.morefunctions

/** operator gives named functions syntax such as +, -, and (). */
data class OperationValues(val totalNumberOfOperations: Int) {
    operator fun plus(addOperation: Int): OperationValues =
        OperationValues(totalNumberOfOperations + addOperation)
    operator fun minus(subtractOperation: Int): OperationValues =
        OperationValues(totalNumberOfOperations - subtractOperation)
    operator fun invoke(): OperationValues = copy()
}

typealias Oper = OperationValues

// This printing shorthand is a syntax experiment. Restrict it to String so it
// does not make every object (including Unit) look callable throughout the project.
operator fun String.invoke() { println(this) }
operator fun String.invoke(block: (String) -> String): String = block(this)

fun main() {
    val numOfOperations = Oper(10)
    println(numOfOperations + 41) // OperationValues(totalNumberOfOperations=51)
    println(numOfOperations - 3) // OperationValues(totalNumberOfOperations=7)
    println(numOfOperations() + 11 + 10) // OperationValues(totalNumberOfOperations=31)
    println(numOfOperations) // Still 10: these operators return new instances.

    "You can print a string using the invoke operator"()
    "You can also write .invoke()".invoke()
    val name = "Stefan"
    val message = name { if (it.isBlank()) "blank name" else "name is ok" }
    println(message) // name is ok; this overload calls the block immediately.
}
