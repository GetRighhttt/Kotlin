package datastructures

/**
 * Arrays have a fixed size. We can replace an element, but growing the array
 * requires a new array. Indices start at zero.
 */
fun main() {
    val thisArray = intArrayOf(2, 3, 4, 5) // IntArray stores primitive Int values.
    val newArray = booleanArrayOf(true, false, true, false, false)
    val myArray = arrayOf(3.4, 4.8, 1.3, 6.9) // Array<Double> on the JVM uses boxed values.

    println(thisArray[0]) // 2
    println(newArray[0]) // true
    println(myArray[0]) // 3.4

    // contentToString() displays the elements. The default array toString() on
    // the JVM shows a type and identity hash, not a reliable memory address.
    println(thisArray.contentToString()) // [2, 3, 4, 5]
    println(newArray.contentToString()) // [true, false, true, false, false]
    println(myArray.contentToString()) // [3.4, 4.8, 1.3, 6.9]

    // A manual maximum search. This array is known to be non-empty.
    var max = thisArray[0]
    for (number in thisArray) {
        if (number > max) {
            max = number
        }
    }
    println(max.toFloat()) // 5.0

    // maxOrNull() also handles an empty array.
    println(intArrayOf().maxOrNull()) // null

    // val prevents reassignment of thisArray, but its elements can still change.
    thisArray[0] = 10
    println(thisArray.contentToString()) // [10, 3, 4, 5]

    val copiedArray = thisArray.copyOf()
    // Arrays use reference equality for ==; === makes that intent explicit.
    println(thisArray === copiedArray) // false: different array instances
    println(thisArray.contentEquals(copiedArray)) // true: matching elements

    // An ArrayList can grow. It also supports indexed access.
    val newArrayList = arrayListOf(1, 83, 51, 47, 99, 221, 23, 25, 35, 65, 25)
    newArrayList.add(25)

    // filter and sorted return new lists. They leave newArrayList unchanged.
    val sortedAndFiltered = newArrayList.filter { it > 25 }.sorted()
    println(sortedAndFiltered) // [35, 47, 51, 65, 83, 99, 221]
    println(99 in sortedAndFiltered) // true
}
