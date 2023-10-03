package advancedkotlin.functional.morefunctions

/*
Infix - allows for functions to be called without brackets or periods; this aids in readability and allows for ease
of use.
Infix functions must be defined inside a class or an extension function to an existing class.
You don't generally see infix functions used in a lot of android projects but it is a cool feature to know.
 */

// declaring extension functions
infix fun String.newName(name: String): String = name
infix fun Int.multipliedByThree(age: () -> Int): Int = age() // function type that returns an Int
infix fun String.setMiddleName(name: String): String = newName(name)

fun main() {
    // created a variable with no initial name
    val tempName = ""

    // example of using infix function to assign name and age times three
    val actualName = tempName newName "Stefan"

    val theirAge = 12 multipliedByThree {
        36
    }

    println("$actualName is my name and my age times three is $theirAge.")

    // using let with also scope functions to assign middle name
    actualName.let {
        it setMiddleName "John"
    }.also {
        println("My middle name is $it.")
    }

    // using let scope function to multiply it once again by 3
    theirAge.let {
        it multipliedByThree {
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