package advanced.functional

/*
Here we discuss Functions as Values, which means passing functions as arguments, returning functions, storing
functions, etc.

Functions without a name are called anonymous functions, and if those functions use short syntax,
they are then called Lambda functions.
 */
fun main(args: Array<String>) {

    /*
    Example of a function that returns another function without a name - anonymous function
     */
    fun generateDivision(): (Int) -> Int {
        // anonymous below
        return fun(y: Int): Int {
            return y * 10
        }
    }

    /*
    Example of anonymous and lambda function and its syntax:
     */
    fun generateAddition(): (Int) -> Int {
        // lambda below - short syntax
        return { x: Int ->
            x + 1
        }
    }

    fun generateMultiplication(): (Double) -> Double {
        return { x: Double ->
            x * x
        }
    }
    /*
    Functions assigned to variables are called LITERAL functions.
     */

    val division by lazy { generateDivision() }
    println(division(20)) // 200

    val exampleLambdaAddition by lazy { generateAddition() }
    println(exampleLambdaAddition(5)) // 6

    val multiplication by lazy { generateMultiplication() }
    println(multiplication(30.0)) // 900.0

    /*
    Higher order functions are functions that take one or more functions as arguments and return a function
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

    /*
    Above, most of the functions we used all return a stream of elements, but that isn't the case for
    all higher order functions that work on collections.

    Terminator functions are functions that return a value, or return something else other than a new collection.
    You can't chain their results together. They "terminate" the chain.

    forEach is an example, as well as forEachIndexed which returns the index and value.
     */
    val numbers = (1..6)
    numbers.map { it * it }
        .filter { it < 20 }
        .forEach { println(it) } // outputs 1 , 4 , 9 , 16 on new lines.

    /*
    reduce() is another example and transforms a collection into a single result starting from left to right.
     */
    val reduced = (1..100).reduce { a, i -> i + a }
    println(reduced) // 5050

    /*
    Flatmap is used to transform a collection into another collection.
    "Returns a single sequence of all elements from results of transform function being
    invoked on each element of original sequence."

    Basically transforms a list of one type to another list of another type.
     */
    val list by lazy { listOf("Stefan", "Bayne") }
    println(list.flatMap { it.toList() }) // [S, t, e, f, a, n, B, a, y, n, e]

    /*
    Using the "onEach" method, unlike forEach, it can continue a collection.
     */
    val intListExample by lazy { listOf(1, 2, 3, 4, 5) }
    println(intListExample.flatMap { it ->
        it.toString()
            .toList()
            .map { it.code }
            .onEach { println(it) }
            .filter { it * 2 >= 30 }
    })
}