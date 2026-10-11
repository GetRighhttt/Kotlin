package advancedkotlin.functional

/** A higher-order function takes a function, returns a function, or both. */
fun higherOrderOperation(a: Int, b: Int, operation: (Int, Int) -> Int): Int = operation(a, b)

// Returning an anonymous function. The name now matches the operation.
fun generateDivision(): (Int) -> Int = fun(number: Int): Int {
    return number / 10
}
fun generateAddition(): (Int, Double) -> Double = { x, y -> x + y }
fun generateMultiplication(): (Double, Double) -> Double = { x, y -> x * y }
inline fun generateNewName(returnName: () -> String): String = returnName()

fun main() {
    println(higherOrderOperation(10, 20) { a, b -> a + b }) // 30
    println(higherOrderOperation(100, 20) { a, b -> a / b }) // 5
    println(higherOrderOperation(20, 30) { a, b -> a * b }) // 600

    // An extension can pass its receiver to a supplied transformation.
    fun String.transformName(transform: (String) -> String): String = transform(this)
    println("Stefan".transformName { it.uppercase() }) // STEFAN
    println("Bayne".transformName { it.lowercase() }) // bayne

    val division = generateDivision()
    println(division(20)) // 2
    println(generateAddition()(5, 20.0)) // 25.0
    println(generateMultiplication()(30.0, 10.0)) // 300.0

    val newList = (1..10).toList()
    println(newList) // [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
    val evenNumbers = newList.filter { it % 2 == 0 }
    println(evenNumbers) // [2, 4, 6, 8, 10]
    println(evenNumbers.dropLastWhile { it != 2 }) // [2]

    // forEach performs an action and returns Unit. onEach returns the collection.
    (1..6).map { it * it }.filter { it < 20 }.forEach(::println) // 1, 4, 9, 16
    val observedNumbers = listOf(1, 2, 3).onEach { println("Observed $it") }
    println(observedNumbers) // [1, 2, 3]

    // reduce starts with the first element and requires a non-empty collection.
    println((1..100).reduce { total, number -> total + number }) // 5050
    // fold accepts an initial value and also works on an empty collection.
    println(emptyList<Int>().fold(0) { total, number -> total + number }) // 0
    println(listOf("Stefan", "Bayne").flatMap { it.toList() })
    // [S, t, e, f, a, n, B, a, y, n, e]

    val name = generateNewName { "Stefan Bayne" }
    val words = name.uppercase().split(" ")
    println("Name generated is -> $words") // [STEFAN, BAYNE]
}
