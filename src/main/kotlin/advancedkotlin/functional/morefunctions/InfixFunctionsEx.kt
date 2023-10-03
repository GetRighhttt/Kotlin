package advancedkotlin.functional.morefunctions

/*
Infix - allows for functions to be called without brackets or periods; this aids in readability and allows for ease
of use.
Infix functions must be defined inside a class or an extension function to an existing class.
 */

// declaring extension functions
infix fun String.newName(name: String): String = name
infix fun Int.theirAgeTimesThree(age: () -> Int): Int = age() // function type that returns an Int
infix fun String.getMiddleName(name: String): String = newName(name)

fun main() {
    // created a variable with no initial name
    val tempName = ""

    // example of using infix function to assign name and age times three
    val actualName = tempName newName "Stefan"

    val theirAge = 12 theirAgeTimesThree {
        36
    }

    println("$actualName is my name and my age times three is $theirAge.")

    // using let with also scope functions to assign middle name
    actualName.let {
        it getMiddleName "John"
    }.also {
        println("My middle name is $it.")
    }

    // using let scope function to multiply it once again by 3
    theirAge.let {
        it theirAgeTimesThree {
            it * 3
        }
    }.also {
        println("If I multiple my age again by 3, it is $it.")
    }
}

/*
My name is Stefan  and my age times three is 36.
108
 */