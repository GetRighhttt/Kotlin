package basics

fun main() {
    /*
    Here we are going to examine functions again except this time we will take a
    look into vararg and default parameters and names.
     */

    // we create a variable to use for the function(optional) and return the int
    val newNumber = getMinNumber(10, 20, 30, 50, 2, 4, 5, 6, 7, 1)
    println(newNumber) // prints 1


    /*
    We can also insert array values into variable arguments.
     */
    val newArray = intArrayOf(3, 4, 5)
    val newVarArg = getMinNumber(*newArray, 7, 8, 9, 110)
    println(newVarArg) // prints 3


    println(searchForString("My name is Stefan"))
    println(searchForString())
}

/*
    VarArg is used when we want to pass a variable number of arguments as a
    function parameter.

    We can treat the numbers we input just like we would treat a LIST.
 */
fun getMinNumber(vararg numbers: Int): Int {
    var min = numbers[0]
    for (number in numbers) {
        if (number < min) min = number
    }
    return min
}

/*
Here we are going to see how we can use default arguments.

Default arguments basically display the result that is defaulted when there is
no value passed as a parameter.
 */
fun searchForString(search: String = "This string"): String {
    return search
}

/*
Output:
1
3
My name is Stefan
This string
 */
