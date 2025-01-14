package datastructures

import java.util.Arrays

fun main() {
    /**
     * Arrays are a data structure that serves as a container for elements that
     * have the same type.

     * Fixed size, random access, direct memory allocation,
     * In Kotlin, we can declare arrays a number of ways:
     */
    val thisArray = intArrayOf(2, 3, 4, 5)
    val newArray = booleanArrayOf(true, false, true, false, false)
    val myArray = arrayOf(3.4, 4.8, 1.3, 6.9)

    /**
     * We can access elements in the array with the index operator as follows:
     */
    thisArray[0]
    println(thisArray[0]) // 2
    println(newArray[0]) // true
    println(myArray[0]) // 3.4

    /**
     * So when we try to print arrays, it will not print the elements
     * It prints their memory locations
     *
     * The println method doesn't allow us to print array elements without iterating
     * through the elements, typically in a for loop, so we use the contentToString() method
     */
    println(thisArray.contentToString())
    println(newArray.contentToString())
    println(myArray.contentToString())

    /**
     * Here we are going to loop through the array to find the largest number
     */
    var max = thisArray[0]
    for (i in thisArray) {
        if (i > max) {
            max = i
        }
    }
    println(max.toFloat()) // converted to a float number = 5.0

    /**
     * Difference between array and arraylist.
     * ArrayList can grow in size. That's the only difference.
     */

    println("Let's print values from an array and filter out a sorted array:")
    val newArrayList = arrayListOf<Int>()
    newArrayList.add(1)
    newArrayList.add(83)
    newArrayList.add(51)
    newArrayList.add(47)
    newArrayList.add(99)
    newArrayList.add(221)
    newArrayList.add(23)
    newArrayList.add(25)
    newArrayList.add(35)
    newArrayList.add(65)
    newArrayList.add(25)
    newArrayList.add(25)
    val sortedAndFiltered = newArrayList
        .filter { it > 25 }
        .sorted()
        .onEach(::println)
        .contains(99)
        .toString()
    println(sortedAndFiltered) // true

    /**
     * 2
     * true
     * 3.4
     * [2, 3, 4, 5]
     * [true, false, true, false, false]
     * [3.4, 4.8, 1.3, 6.9]
     * 5.0
     * Let's print values from an array and filter out a sorted array:
     * 35
     * 47
     * 51
     * 65
     * 83
     * 99
     * 221
     * true
     *
     */
}