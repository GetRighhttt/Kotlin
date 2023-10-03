package advancedkotlin.functional.morefunctions

/*
Infix - allows for functions to be called without brackets or periods; this aids in readability and allows for ease
of use.
Infix functions must be defined inside a class or an extension function to an existing class.
 */

infix fun String.name(name: String): String = "My name is $name"
infix fun Int.ageTimesThree(age: () -> Int): Int = age()

fun main() {
    // created a variable with no initial name
    val tempName = ""

    // example of using infix function to assign name and age times three
    val actualName = tempName name "Stefan"
    val theirAge = 12 ageTimesThree {
        36
    }
    println("$actualName and my age times three is $theirAge.")
}

/*
My name is Stefan  and my age times three is 36.
 */