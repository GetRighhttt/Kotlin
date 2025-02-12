package datastructures

import java.util.stream.Collectors

fun main() {
    /**
     * List are like arrays except with list, the values in the list cannot be changed at run time whereas in arrays
     * they can. Also, list are more flexible and easier to use. They also have a sequence and streams collection
     * that is built in to Java. List are very easy to add to, delete or update, but it doesn't provide
     * random access to elements in the list.
     */

    // we can perform more operations on a list due to its flexibility
    val myNewList = listOf(2, 3, 4, 5, 6, 1, 9, 3, 8, 7, 10)
    println(myNewList.stream()
        .filter { a -> a >= 4 }
        .map { a -> a * 4 }
        .collect(Collectors.toList())) // [16, 20, 24, 36, 32, 28, 40]

    /** Here we can also group items in a list based on a condition.
     * Below that condition is if the element is greater than or equal to 3.
     * */
    val x = myNewList.groupBy { a -> a >= 3 }
    println(x.toString()) // {false=[2, 1], true=[3, 4, 5, 6, 9, 3, 8, 7, 10]}

    val newInt = myNewList.find { it % 3 == 0 }
    println(newInt.toString()) // finds the first element that fits the condition
    /** List by default are immutable - elements in the list cannot change. To declare a list that can be changed,
     *  we need to create a mutable list.
     */

    // this is how we create an empty mutable list
    val thisMutableList = mutableListOf<Int>()

    println("Enter in 5 numbers:")
    // now we will read user input and add them to the list
    for (element in 1..5) {
        val num = readlnOrNull()?.toInt()
        if (num != null) {
            thisMutableList.add(num)
        }
    }
    // here we print the list in reverse order and sorted
    println(
        thisMutableList
            .sorted()
            .also { // scope function used here and continues collection afterward
                println(it)
            }
            .asReversed()
    )

    /**
     * [16, 20, 24, 36, 32, 28, 40]
     * {false=[2, 1], true=[3, 4, 5, 6, 9, 3, 8, 7, 10]}
     * 3
     * Enter in 5 numbers:
     * 3
     * 4
     * 5
     * 6
     * 7
     * [3, 4, 5, 6, 7]
     * [7, 6, 5, 4, 3]
     */
}