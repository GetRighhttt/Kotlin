package advanced

/*
Functions without a name are called anonymous functions, and if those functions use short syntax,
they are then called Lambda functions.
 */
fun main(args: Array<String>) {

    /*
    Example of a lambda function and its syntax:
     */
    fun generateAddition(): (Int) -> Int {
        return {x: Int ->
            x + 1
        }
    }
    /*
    Functions assigned to variables are called literal functions.
     */
    val exampleLambdaAddition = generateAddition()
    println(exampleLambdaAddition(5)) // 6
    /*
    Higher order functions are functions that take one or more functions as arguments
     */
    var newList = (1..10).sorted().toList()
    println("Here is the regular list: ")
    println(newList)
    newList = newList.filter { it % 2 == 0 }
    println("Numbers divisible by 2: ")
    println(newList)

    newList = newList.dropLastWhile { it != 2 }
    println("Drop method for elements in list not equal to 2: ")
    println(newList)

    /*
    Here is the regular list:
    [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
    Numbers divisible by 2:
    [2, 4, 6, 8, 10]
    Drop last method for list not equal to 2:
    [2]
     */

}