package advanced

fun main(args: Array<String>) {
    /*
    Arrays are a data structure that serves as a container for elements that
    have the same type.

    Fixed size, random access, direct memory allocation,

    In Kotlin, we can declare arrays a number of ways:
     */
    val thisArray = intArrayOf(2, 3, 4, 5)
    val newArray = booleanArrayOf(true, false, true, false, false)
    val myArray = arrayOf(3.4, 4.8, 1.3, 6.9)

    // this is how we can access elements of the array
    thisArray[0]

    // this prints those elements
    println(thisArray[0])
    println(newArray[0])
    println(myArray[0])

    /*
    So when we try to print arrays, it will not print the elements.
    It prints their memory locations.

    The println method doesn't allow us to print array elements without iterating
    through the elements, typically in a for loop.
     */
    println(thisArray.toString())
    println(newArray.toString())
    println(myArray.toString())

    /*
    Here we are going to loop through the array to find the largest number
     */
    var max = thisArray[0]
    for(i in thisArray) {
        if(i > max) max = i
    }
    println(max.toFloat()) // converted to a float number = 5.0

    /**
     * Output:
    2
    true
    3.4
    [I@10f87f48
    [Z@b4c966a
    [Ljava.lang.Double;@2f4d3709
     */
}