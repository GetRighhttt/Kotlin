package datastructures

/**
 * A Set stores unique elements. It has no indexed access operator.
 * MutableSet adds write operations. Iteration order depends on the implementation.
 */
fun main() {
    val basketballChamps = setOf("Bucks", "Clippers", "Lakers", "Bulls")
    println(basketballChamps) // [Bucks, Clippers, Lakers, Bulls]
    println("Suns" in basketballChamps) // false
    println("Bulls" in basketballChamps) // true

    // setOf preserves the supplied order, but Set in general does not promise order.
    for (team in basketballChamps) {
        println(team)
    }

    // The repeated 6 is stored once. HashSet does not promise iteration order.
    val hashSetExample = hashSetOf(3, 4, 6, 1, 10, 2, 6)
    println(hashSetExample.size) // 6
    println(hashSetExample.sorted()) // [1, 2, 3, 4, 6, 10]; sorted() returns a List.

    val favoriteTeams = mutableSetOf("Bucks", "Lakers")
    println(favoriteTeams.add("Bucks")) // false: already present
    println(favoriteTeams.add("Bulls")) // true: added
    println(favoriteTeams.remove("Lakers")) // true: removed
    println(favoriteTeams) // [Bucks, Bulls]

    // Set equality checks membership, regardless of iteration order.
    println(setOf("Bucks", "Bulls") == setOf("Bulls", "Bucks")) // true
}
