package oop

// What is a typealias? A typealias is abbreviating a large name for a type into a smaller name.
// TypeAliases can make the code more concise and more readable. Could save on time as well.

data class SuperLargeNameThatIWontWriteAgain(val disaster: String)
data class ExampleTypeAlias(val example: String)

typealias longName = SuperLargeNameThatIWontWriteAgain
typealias newExample = ExampleTypeAlias

fun main() {

    // allows us to create an object with the abbreviation
    val theName = longName("terrible disaster")
    println(theName)

    val thisExample = newExample("this is an example of another typealias").also(::println)
    println(thisExample.toString().uppercase())

    /*
    SuperLargeNameThatIWontWriteAgain(disaster=terrible disaster)
    ExampleTypeAlias(example=this is an example of another typealias)
    EXAMPLETYPEALIAS(EXAMPLE=THIS IS AN EXAMPLE OF ANOTHER TYPEALIAS)
     */
}