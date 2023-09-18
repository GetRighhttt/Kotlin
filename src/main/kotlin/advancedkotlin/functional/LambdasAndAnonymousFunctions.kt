package advancedkotlin.functional

/*
Lambdas are a type of function literal(a special notation used to simplify function types).
i.e { a, b -> a + b }

The full syntactic expression for function type to a lambda is as follows:
val add: (Int, Int) -> Int = { a: Int, b: Int -> a + b }

Examples: https://kotlinlang.org/docs/lambdas.html#underscore-for-unused-variables
 */
fun main() {

    /*
    friend = name of lambda
    (String) -> String = type
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
    Lambdas can also be used with class extensions
     */
    data class Person(val name: String, val age: Int)

    val printPerson: Person.() -> Person = {
        // creating a person object and destructuring it
        val person = Person(name.uppercase(), age * 2)
        val (upperCaseName, ageTimesTwo) = person
        println(upperCaseName) // STEFAN
        println(ageTimesTwo) // 60
        this
    }
    println(printPerson(Person("Stefan", 30))) // Person(name=STEFAN, age=60)

    /*
    Anonymous Functions are functions literals without a name.
     */
    val numTimesTwo = fun(a: Int) : Int {
            return a*2
        }
    println(numTimesTwo(20)) // 40
}