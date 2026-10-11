package datastructures

/**
 * A List keeps elements in order and supports indexed access. Duplicates are allowed.
 * List exposes read-only operations; MutableList also allows adding, replacing,
 * and removing elements. The implementation determines the cost of indexed access.
 */
fun main() {
    val myNewList = listOf(2, 3, 4, 5, 6, 1, 9, 3, 8, 7, 10)
    println(myNewList[0]) // 2

    // Kotlin collection operations do not need a Java stream.
    val filteredAndMultiplied = myNewList.filter { it >= 4 }.map { it * 4 }
    println(filteredAndMultiplied) // [16, 20, 24, 36, 32, 28, 40]

    // groupBy puts elements with the same selector result into a list.
    val groupedByAtLeastThree = myNewList.groupBy { it >= 3 }
    println(groupedByAtLeastThree) // {false=[2, 1], true=[3, 4, 5, 6, 9, 3, 8, 7, 10]}

    println(myNewList.find { it % 3 == 0 }) // 3: the first match
    println(myNewList.find { it > 100 }) // null: no match

    // A read-only view can still observe changes made through a mutable reference.
    val mutableNumbers = mutableListOf(1, 2)
    val readOnlyNumbers: List<Int> = mutableNumbers
    val snapshot = mutableNumbers.toList() // Copies the elements into a separate list.
    mutableNumbers.add(3)
    println(readOnlyNumbers) // [1, 2, 3]
    println(snapshot) // [1, 2]; the copy is shallow if the elements are mutable objects.

    val enteredNumbers = mutableListOf<Int>()
    println("Enter 5 whole numbers:")
    while (enteredNumbers.size < 5) {
        val input = readlnOrNull()
        if (input == null) {
            println("Input ended after ${enteredNumbers.size} numbers.")
            break
        }

        val number = input.toIntOrNull()
        if (number == null) {
            println("Please enter a whole number within the Int range.")
            continue // An invalid entry does not count toward the five numbers.
        }
        enteredNumbers.add(number)
    }

    // sorted() makes a new list. also prints it and returns that same list.
    val sortedNumbers = enteredNumbers.sorted().also { println(it) }
    // asReversed() is a reversed view; reversed() would create a separate list.
    println(sortedNumbers.asReversed())
}

/*
With input 3, 4, 5, 6, 7 on separate lines, the final lists are:
[3, 4, 5, 6, 7]
[7, 6, 5, 4, 3]
*/
