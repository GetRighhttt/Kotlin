package advancedkotlin.functional

/**
 * Higher-Order functions are functions that take in other functions as arguments or parameters, returns a
 * function, or does both.
 * Lambdas are anonymous functions are function literals used a ton in higher-order functions.
 */

fun main() {

    /**
     * Ex: Higher-Order function examples below with function types, lambdas, anonymous functions, etc.
     *
     * The below example takes in a function type, and two ints, as an argument.
     * It returns the function that combines the other two arguments.
     */
    fun higherOrderOperation(
        a: Int, b: Int, c: (Int, Int) -> Int // function type
    ): Int {
        return c(a, b)
    }
    higherOrderOperation(10, 20, c = { a, b -> a + b } // lambda (function literal)
    ).also(::println) // 30

    higherOrderOperation(100, 20, c = { a, b -> a / b }).also(::println) // 5

    // short syntax
    higherOrderOperation(20, 30, c = { a, b -> a * b }).also(::println) // 600

    // Extension functions on the String class that returns uppercase & lowercase names with infix for readability
    infix fun String.printNameInUppercaseLetters(
        name: (String) -> String
    ): String {
        return name("".uppercase())
    }

    // condensed format (sometimes confusing) with infix for readability
    infix fun String.printFirstNameInLowercaseLetters(
        name: (String) -> String
    ): String = name("".lowercase())

    // returns a function type and demonstrates anonymous functions
    fun generateDivision(): (Int) -> Int {

        // anonymous function == no name for the function (also function literal)
        return fun(y: Int): Int {
            return y * 10
        }
    }

    // with return function type to lambda
    fun generateAddition(): (Int, Double) -> Double = { // lambda
            x: Int, y: Double ->
        x + y
    }

    fun generateMultiplication() = { // lambda
            x: Double, z: Double ->
        (x * x) * z
    }

    // lambda expressions are also higher-order functions
    val name = ""
    println(name printNameInUppercaseLetters {
        "Stefan"
    }) // STEFAN

    val lastName = ""
    println(
        lastName printFirstNameInLowercaseLetters {
            "Bayne"
        }) // bayne

    val division by lazy { generateDivision() }
    println(division(20)) // 200

    val exampleLambdaAddition by lazy { generateAddition() }
    println(exampleLambdaAddition(5, 20.0)) // 25.0

    val multiplication by lazy { generateMultiplication() }
    println(multiplication(30.0, 10.0)) // 9000.0

    var newList = (1..10).sorted().toList()
    println("Here is the regular list: ")
    println(newList)

    newList = newList.filter { it % 2 == 0 }
    println("Numbers divisible by 2: ")
    println(newList)

    newList = newList.dropLastWhile { it != 2 }
    println("Drop method for elements in list not equal to 2: ")
    println(newList)

    /**
     * Above, most of the functions we used all return a stream of elements, but that isn't the case for
     * all higher order functions that work on collections.
     *
     * Terminator functions are functions that return a value, or return something else other than a new collection.
     * You can't chain their results together. They "terminate" the chain.
     *
     * forEach is an example, as well as forEachIndexed which returns the index and value.
     */
    val numbers = (1..6)
    numbers.map { it * it }.filter { it < 20 }.forEach { println(it) } // outputs 1 , 4 , 9 , 16 on different lines.

    /*
    reduce() is another example and transforms a collection into a single result starting from left to right.
     */
    val reduced = (1..100).reduce { a, i -> i + a }
    println(reduced) // 5050

    val list by lazy { listOf("Stefan", "Bayne") }
    println(list.flatMap { it.toList() }) // [S, t, e, f, a, n, B, a, y, n, e]

    /*
    Using the "onEach" method, unlike forEach, it can continue a collection.
     */
    val intListExample by lazy { listOf(1, 2, 3, 4, 5) }
    println(intListExample.flatMap { it ->
        it.toString().toList().map { it.code }.onEach { println(it) }.filter { it * 2 >= 105 }
    })

    val newNameGenerated = readlnOrNull()?.let {
        generateNewName {
            it
        }
    }.also { theName ->
        print("Name generated is -> ")
        println(theName?.map { theName.uppercase().split(" ", ignoreCase = true, limit = 3) })
    }
}

// declaring an inline higher-order function
inline fun generateNewName(
    returnName: () -> String
): String {
    return returnName()
}

/**
 * 30
 * 5
 * 600
 * Stefan
 * Bayne
 * 200
 * 25.0
 * 9000.0
 * Here is the regular list:
 * [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
 * Numbers divisible by 2:
 * [2, 4, 6, 8, 10]
 * Drop method for elements in list not equal to 2:
 * [2]
 * 1
 * 4
 * 9
 * 16
 * 5050
 * [S, t, e, f, a, n, B, a, y, n, e]
 * 49
 * 50
 * 51
 * 52
 * 53
 * [53]
 */