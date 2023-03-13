package datastructures

/*
A set represents a collection of unique elements.

Sets don't provide indexes access, and also elements of a set can only exists once.
 */

fun main() {

    val basketballChamps = setOf<String>("Bucks", "Clippers", "Lakers", "Bulls")

    println(basketballChamps) // [Bucks, Clippers, Lakers, Bulls]

    /*
    Sets are usually used when looking to distinguish individual elements.
     */

    println("Suns" in basketballChamps) // false
    println("Bulls" in basketballChamps) // true
}
