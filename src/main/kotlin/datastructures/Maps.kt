package datastructures

/**
 * Maps is a collection of key-value pairs in which keys are unique, and is used
 * quite often in real-world applications.
 * The keyword "to" is used to create a pair of two elements. This keyword is actually a special function
 * in the Kotlin language that is built in.
 */

fun main() {

    val basketballGOATPyramid = mapOf(
        1 to "Michael Jordan",
        2 to "Kobe",
        3 to "Hakeem Olajuwon",
        4 to "Kareem Abdul-Jabbar",
        5 to "Magic Johnson"
    )

    println(basketballGOATPyramid.values) // prints the values to a list
    println(basketballGOATPyramid.keys) // prints the ids or keys to a list
    println(basketballGOATPyramid) // in a map

    // here is how we access values in a map
    println("Looks like the GOAT of basketball is: ${basketballGOATPyramid[1]}.") // prints MJ
    println(6 in basketballGOATPyramid) // prints false

    /**
     * Another way to access values in a map is by using Pairs
     */
    val anotherMap = mapOf(
        Pair(1, 30),
        Pair(2, 40),
        Pair(3,50)
    )
    println(anotherMap.values) // [30, 40, 50]
    anotherMap.entries.onEach {
        println("$it ")
    }


    /**
     * HashMaps are a class built in to Java and the difference is the functionality - read and write,
     * and has more functions that can be applied to it.
     */
    val myMap = HashMap<Int, String>()
    myMap[2] = "Deuce"
    myMap[3] = "Tres"
    myMap[4] = "Quarto"

    // we can also add values to the hashmap using "put"
    myMap[5] = "Cinco"
    myMap[6] = "Seis"

    myMap.replace(2, "Two")
    val mapClone = myMap.clone().toString()
    val mapCount = myMap.count()
    val isMapEmpty = myMap.isEmpty()

    for (key in myMap.keys) {
        println("Element at Key: $key = ${myMap[key]}")
    }
    println(mapCount) // 3
    println(mapClone) // clones map
    println(isMapEmpty) // false

    /**
     * [Michael Jordan, Kobe, Hakeem Olajuwon, Kareem Abdul-Jabbar, Magic Johnson]
     * [1, 2, 3, 4, 5]
     * {1=Michael Jordan, 2=Kobe, 3=Hakeem Olajuwon, 4=Kareem Abdul-Jabbar, 5=Magic Johnson}
     * Looks like the GOAT of basketball is: Michael Jordan.
     * false
     * [30, 40, 50]
     * 1=30
     * 2=40
     * 3=50
     * Element at Key: 2 = Two
     * Element at Key: 3 = Tres
     * Element at Key: 4 = Quarto
     * Element at Key: 5 = Cinco
     * Element at Key: 6 = Seis
     * 5
     * {2=Two, 3=Tres, 4=Quarto, 5=Cinco, 6=Seis}
     * false
     */
}