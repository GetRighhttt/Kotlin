package advancedkotlin.functional

/** Pair and Triple group values; their val properties do not make nested objects immutable. */
fun main() {
    val pair = "a" to 1
    val (key, value) = pair // Destructuring, not destruction of the original value.
    println("Printing a key-value pair: $key, $value") // a, 1
    val anotherPair = Pair("one" to 1, "two" to 2)
    val (one, two) = anotherPair
    println("This object prints like: $one and $two")
    println("The keys are: ${one.first} and ${two.first}")
    println("The values are: ${one.second} and ${two.second}")

    val triple = Triple("a" to 11, "b" to 12, "c" to 13)
    val (a, b, c) = triple
    println("The key-value pairs are: $a | $b | $c")

    // A named data class gives the components more descriptive names than first/second/third.
    data class Coordinate(val x: Int, val y: Int, val z: Int)
    val (x, y, z) = Coordinate(1, 2, 3)
    println("x=$x, y=$y, z=$z")
    fun returnTriple(): Triple<Int, Int, Int> = Triple(1, 2, 3)
    fun passingInTriple(value: Triple<Int, Int, Int>): Int = value.toList().fold(0) { total, n -> total + n }
    println(returnTriple().toList()) // [1, 2, 3]
    println(passingInTriple(Triple(2, 4, 5))) // 11
}
