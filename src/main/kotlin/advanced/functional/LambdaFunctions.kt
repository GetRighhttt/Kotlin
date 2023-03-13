package advanced

fun main(args: Array<String>) {
    /*
    Lambda functions are used to pass functions as parameters to other functions.

    filter{} is an example of a lambda function
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