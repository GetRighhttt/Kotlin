package datastructures

/**
 * A Map associates unique keys with values. Different keys can share a value.
 * Map offers read-only access; MutableMap also offers write operations.
 */
fun main() {
    val basketballGOATPyramid = mapOf(
        1 to "Michael Jordan",
        2 to "Kobe",
        3 to "Hakeem Olajuwon",
        4 to "Kareem Abdul-Jabbar",
        5 to "Magic Johnson"
    )

    // keys is a Set; values is a Collection. Neither property is necessarily a List.
    println(basketballGOATPyramid.values)
    println(basketballGOATPyramid.keys) // [1, 2, 3, 4, 5]
    println(basketballGOATPyramid)

    // [] looks up a key. A missing key returns null.
    println("Looks like the GOAT of basketball is: ${basketballGOATPyramid[1]}.")
    println(basketballGOATPyramid[6]) // null
    println(6 in basketballGOATPyramid) // false: in checks keys
    println("Kobe" in basketballGOATPyramid.values) // true

    // to is an infix function that creates a Pair. Pair(...) is the explicit form.
    val anotherMap = mapOf(Pair(1, 30), Pair(2, 40), Pair(3, 50))
    println(anotherMap.values) // [30, 40, 50]
    for ((key, value) in anotherMap) {
        println("$key=$value")
    }

    // HashMap is one mutable implementation. Its iteration order is unspecified.
    val myMap = HashMap<Int, String>()
    myMap[2] = "Deuce"
    myMap[3] = "Tres"
    myMap[4] = "Quarto"
    myMap.put(5, "Cinco") // put() is another way to assign a key/value pair.
    myMap[6] = "Seis"

    myMap.replace(2, "Two") // Replaces the existing value without adding another key.
    println(myMap.size) // 5
    println(myMap.isEmpty()) // false

    // toMap() makes a shallow copy, rather than a live read-only view of myMap.
    val mapCopy = myMap.toMap()
    myMap[2] = "Deux"
    println(mapCopy[2]) // Two
    println(myMap[2]) // Deux

    // Sort explicitly when we want predictable output from a HashMap.
    for ((key, value) in myMap.toSortedMap()) {
        println("Element at Key: $key = $value")
    }
    println(mapCopy.toSortedMap()) // {2=Two, 3=Tres, 4=Quarto, 5=Cinco, 6=Seis}
}
