package advancedkotlin.functional

/*
Lambdas are a type of function literal(a special notation used to simplify function types).
i.e { a, b -> a + b }

             // function type(declaration)         // lambda(definition)
val lambda = (InputType) -> Return Type = { arguments: InputType -> body }

The full syntactic expression for function type to a lambda is as follows:
val add: (Int, Int) -> Int = { a: Int, b: Int -> a + b }

the full syntactic expression for function type to an anonymous function is as follows:
val subtract: (Int, Int) -> Int = fun(a: Int, b: Int): Int { return a - b }

Examples: https://kotlinlang.org/docs/lambdas.html#underscore-for-unused-variables
 */
fun main() {
    /*
    friend = name of lambda
    (String) -> String = function type
     name: String = arguments
     -> name.lowercase() = body

    we usually only use the arguments and body of the lambda.
     */
    val friend: (String) -> String = { name: String -> name.lowercase() }
    println(friend("Bobby")) // bobby

    val justTheArgumentsAndBody = { a: Int, b: Int -> a + b }
    println(justTheArgumentsAndBody.invoke(3, 4)) // 7 (using invoke)
    println(" ${friend("Stefan")} is ${justTheArgumentsAndBody(10, 18)} years old!") //  stefan is 28 years old!

    /*
    Shorthand lambda syntax omits the variables and uses "it". This is optional but is usually
    used in android development and other paradigms. This can only be done with a single argument.
     */
    val squareShortSyntax: (Int) -> Int = { it * it }

    /*
    Reminder of lambda syntax.
     */
    val superSquare: (Double, Double) -> Int = { a,b -> (a * b).toInt() }
    println(superSquare.invoke(10.12, 11.20)) // 113

    /*
    Lambdas can also be used with class extensions
     */
    data class Person(val name: String, val age: Int)

    val printPerson: Person.() -> Person = {
        // creating a person object and destructuring it
        val person = Person(name.uppercase(), age * 2)
        val (upperCaseName, ageTimesTwo) = person
        println(upperCaseName) // STEFAN
        println(ageTimesTwo) // 60
        repeat(2) { println(upperCaseName) } // another way to use a lambda expression
        this
    }
    println(printPerson(Person("Stefan", 30))) // Person(name=STEFAN, age=60)
    println(squareShortSyntax(12)) // 144

    /*
    Anonymous Functions are functions literals without a name.
    function type declaration to anon. function definition
     */
    val numSquare: (Int) -> Int = fun(a: Int): Int {
        return a * a
    }.also {
        println("The square of a is:")
    }
    println(numSquare(400)) // 160000

    // function type declaration to anon. function definition
    val numTimesThree: (Double) -> Double = fun(num: Double): Double {
        return num * 3
    }.also {
        println("Num times three is:")
    }
    println(numTimesThree(400.0)) // 1200.0

    // when lambdas are the last parameter in a function, we can do what is called a "trailing lambda"
    fun rollDice(callback: () -> Unit): String {
        return "Dice Rolled ${callback.invoke()} times."
    }

    println(
        // trailing lambda for function
        rollDice {
            justTheArgumentsAndBody.invoke(3, 10) // Dice Rolled 13 times.
        }
    )
}
