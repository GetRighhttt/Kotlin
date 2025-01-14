package datastructures

/**
 * A set represents a collection of unique elements.
 * Sets don't provide indexes access, and also elements of a set can only exist once.
 */

fun main() {

    val basketballChamps = setOf("Bucks", "Clippers", "Lakers", "Bulls")

    println(basketballChamps) // [Bucks, Clippers, Lakers, Bulls]

    /**
     * Sets are usually used when looking to distinguish individual elements.
     */

    println("Suns" in basketballChamps) // false
    println("Bulls" in basketballChamps) // true

    for (element in basketballChamps) println(element) // prints in sequence

    /**
     * Difference: Sequence not guaranteed.
     */
    val hashSetExample = hashSetOf(3, 4, 6, 1, 10, 2, 6)
    for (element in hashSetExample) println(element) // prints out of sequence

    /**
     * [Bucks, Clippers, Lakers, Bulls]
     * false
     * true
     * Bucks
     * Clippers
     * Lakers
     * Bulls
     * 1
     * 2
     * 3
     * 4
     * 6
     * 10
     */
}
