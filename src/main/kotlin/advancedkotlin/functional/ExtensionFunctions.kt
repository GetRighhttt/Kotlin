package advancedkotlin.functional

/**
 * An extension adds callable syntax to a receiver type without changing the class.
 * In fun Int.isPrime(), Int is the receiver type and this is its value.
 * Extensions are selected using the declared type, not runtime polymorphism.
 */
fun Int.isPrime(): Boolean {
    if (this < 2) return false
    var divisor = 2
    // divisor <= this / divisor avoids overflow from divisor * divisor.
    while (divisor <= this / divisor) {
        if (this % divisor == 0) return false
        divisor++
    }
    return true
}

// These are practice predicates, not rules about actual names or health.
fun String.isNice(): Boolean = length > 4
fun String.isNotHealthy(): Boolean = length < 4 && startsWith("s")
fun String.hideName(): String = "*".repeat(length)
fun String.repeatName(): List<Char> = repeat(3).toList()
fun Double.convertToInt(): Int = toInt() // Drops the fractional part toward zero.

fun MutableList<Int>.switchNumbers(index1: Int, index2: Int) {
    require(index1 in indices && index2 in indices) { "Both indices must be in the list." }
    val temp = this[index1]
    this[index1] = this[index2]
    this[index2] = temp
}

fun main() {
    println("Please enter a number:")
    val number = readlnOrNull()?.toIntOrNull()
    if (number == null) {
        println("No valid Int was supplied.")
    } else {
        println(if (number.isPrime()) "is a prime number" else "not prime")
    }

    println("Please enter a name:")
    val name = readlnOrNull()
    if (name == null) {
        println("Input ended.")
    } else {
        println(name.isNice())
        println(name.isNotHealthy())
        println(name.hideName())
        println(name.repeatName())
    }

    val list = mutableListOf(3, 6, 9, 12, 14, 5, 7, 10)
    list.switchNumbers(0, 1)
    list.switchNumbers(1, 2)
    list.switchNumbers(2, 3)
    println(list) // [6, 9, 12, 3, 14, 5, 7, 10]
    println(38.6.convertToInt()) // 38
}
