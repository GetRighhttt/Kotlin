package advancedkotlin.functional

/**
 * A tuple is a piece of data that cannot be changed after it is created.
 *
 * In kotlin, we call tuples "pairs", and this I have seen is used often in real world code.
 * Pair contains two properties called first and second.
 * Pairs are immutable, which is a core concept of functional programming.
 *
 */
fun main() {

    // creating a pair
    val pair = "a" to 1

    // destructing a pair using destructive declaration
    val (key, value) = pair
    println("Printing a key-value pair: $key, $value") // a, 1

    val anotherPair = Pair("one" to 1, "two" to 2)
    val (one, two) = anotherPair
    println("This object prints like : $one and $two") // (one, 1) and (two, 2) - objects

    println("The keys are: ${one.first} and ${two.first} ") // "one and two" - keys
    println("The values are: ${one.second} and ${two.second} ") // "1 and 2" - values

    /**
    There is also a triple tuple that we can work with in Kotlin and other languages that
    encompasses the concept of immutability.
     */
    val thisTriplePair = Triple("a" to 11, "b " to 12, "c" to 13)
    val (a, b, c) = thisTriplePair
    println("The key-value pairs are: (${a.first}, ${a.second}) | (${b.first}, ${b.second}) | (${c.first}, ${c.second})")


    /**
    Another destructuring example with data classes which act as tuples as well if using values.
    Below we create a data class acting as a Triple.
     */
    data class TupleExample(val first: String, val second: String, val third: String)

    val tupleExample = TupleExample("first", "second", "third")
    val (first, second, third) = tupleExample
    println("$first, $second, $third")

//    Printing a key-value pair: a, 1
//    This object prints like : (one, 1) and (two, 2)
//    The keys are: one and two
//    The values are: 1 and 2
//    The key-value pairs are: (a, 11) | (b , 12) | (c, 13)
//    first, second, third

    // we can return pairs and triples from functions
    fun returnTriple(): Triple<Int, Int, Int> {
        val firstOne = 1
        val secondOne = 2
        val thirdOne = 3
        return Triple(firstOne, secondOne, thirdOne)
    }
    println(returnTriple().toList()) // [1, 2, 3]

    // we can also pass in pairs and triples into functions
    fun passingInTriple(thisTriple: Triple<Int, Int, Int>): Int {
        return thisTriple.toList().fold(0) { a, b -> a + b } // accumulates values into one
    }
    println(passingInTriple(Triple(2, 4, 5))) // 11
}