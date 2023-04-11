package advanced.functional

/*
A tuple is a piece of data that cannot be changed after it is created.

In kotlin, we call tuples "pairs", and this I have seen is used often in real world code.
Pair contains two properties called first and second.
Pairs are immutable, which is a core concept of functional programming.

 */
fun main() {

    // creating a pair
    val pair = "a" to 1

    // destructing a pair using destructive declaration
    val (key, value) = pair
    println("$key, $value") // a, 1

    val anotherPair = Pair("one" to 1, "two" to 2)
    val (one, two) = anotherPair
    println("$one and $two") // (one, 1) and (two, 2)

    /*
    There is also a triple tuple that we can work with in Kotlin and other languages that
    encompasses the concept of immutability.
     */
    val thisTriplePair = Triple("a", "b ", "c")
    println(thisTriplePair.toList()) // [a, b , c]


    /*
    Another destructuring example with data classes which act as tuples as well if using values.
    Below we create a data class acting as a Triple.
     */
    data class TupleExample(val first: Int, val second: Int, val third: Int)

    val tupleExample = TupleExample(1, 2, 3)

    val (first, second, third) = tupleExample
    println("$first, $second, $third") // 1, 2, 3


}