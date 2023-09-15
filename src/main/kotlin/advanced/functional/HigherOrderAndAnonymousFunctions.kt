package advanced.functional

/*
Higher-Order functions are known as functions that take in other functions as arguments or parameters, returns a
function, or does both.
Lambdas are anonymous functions passed as an expression without a declaration.

a lambda expression: { a, b -> a + b },

an anonymous function: fun(s: String): Int { return s.toIntOrNull() ?: 0 }
 */
fun main(args: Array<String>) {

    /*
    Below is an example of a higher-order function that returns a lambda expression with code blocks that demonstrates
    how an anonymous function is declared.

    " fun example(): (String) -> String { // Ex. } " == a function that takes in a string and returns a string.

    The syntax before the code block is a lambda return expression broken down.
     */
    fun generateDivision(): (Int) -> Int { // takes in an int and returns an int

        // anonymous function: "fun(y: Int): Int { }" == no name for the function
        return fun(y: Int): Int {
            return y * 10
        }
    }

    /*
    Below are two higher-order function that returns a lambda expression in short syntax without code blocks.
     */
    fun generateAddition(): (Int, Double) -> Double = { x: Int, y: Double -> x + y }

    /*
    The params return can be omitted to just show the lambda expression.
    " fun omit:() -> Return " == omitted .
     */
    fun generateMultiplication() = { x: Double, z: Double -> (x * x) * z }

    /*
    Functions assigned to variables are called LITERAL functions.
     */
    val division by lazy { generateDivision() }
    println(division(20)) // 200

    val exampleLambdaAddition by lazy { generateAddition() }
    println(exampleLambdaAddition(5, 20.0)) // 25.0

    val multiplication by lazy { generateMultiplication() }
    println(multiplication(30.0, 10.0)) // 9000.0

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
        .forEach { println(it) } // outputs 1 , 4 , 9 , 16 on different lines.

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
            .filter { it * 2 >= 105 }
    })
}

/*
49
50
51
52
53
[53]
 */