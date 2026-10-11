package advancedkotlin.functional

/** Lambdas and anonymous functions are two ways to create function values. */
fun main() {
    // Function type on the left, lambda expression on the right.
    val friend: (String) -> String = { name -> name.lowercase() }
    println(friend("Bobby")) // bobby

    val justTheArgumentsAndBody = { a: Int, b: Int -> a + b }
    println(justTheArgumentsAndBody.invoke(3, 4)) // 7
    println("${friend("Stefan")} is ${justTheArgumentsAndBody(10, 18)} years old!")

    // it is the implicit name of a single lambda parameter.
    val squareShortSyntax: (Int) -> Int = { it * it }
    println(squareShortSyntax(12)) // 144
    val superSquare: (Double, Double) -> Int = { a, b -> (a * b).toInt() }
    println(superSquare(10.12, 11.20)) // 113

    data class Person(val name: String, val age: Int)
    // Person.() supplies a receiver accessed through this, name, and age.
    val printPerson: Person.() -> Person = {
        val person = copy(name = name.uppercase(), age = age * 2)
        val (upperCaseName, ageTimesTwo) = person
        println(upperCaseName) // STEFAN
        println(ageTimesTwo) // 60
        repeat(2) { println(upperCaseName) }
        person // The last expression is the result; this would return the original.
    }
    println(Person("Stefan", 30).printPerson()) // Person(name=STEFAN, age=60)

    val numSquare: (Int) -> Int = fun(number: Int): Int {
        return number * number
    }
    println(numSquare(400)) // 160000
    val numTimesThree: (Double) -> Double = fun(number: Double): Double {
        return number * 3
    }
    println(numTimesThree(400.0)) // 1200.0

    // The callback needs to return Int because we use its result as a count.
    fun rollDice(callback: () -> Int): String = "Dice rolled ${callback()} times."
    // A final function parameter can be supplied as a trailing lambda.
    println(rollDice { justTheArgumentsAndBody(3, 10) }) // Dice rolled 13 times.
}
