package advancedkotlin.functional.morefunctions

/*
Infix - allows for functions to be called without brackets or periods; this aids in readability and allows for ease
of use.
Infix functions must be defined inside a class or an extension function to an existing class.
 */

// declaring extension functions
infix fun String.newName(name: String): String = "My name is $name"
infix fun Int.theirAgeTimesThree(age: () -> Int): Int = age() // function type that returns an Int

fun main() {
    // created a variable with no initial name
    val tempName = ""

    // example of using infix function to assign name and age times three
    val actualName = tempName newName "Stefan"
    val theirAge = 12 theirAgeTimesThree {
        36
    }
    println("$actualName and my age times three is $theirAge.")
}

/*
My name is Stefan  and my age times three is 36.
 */