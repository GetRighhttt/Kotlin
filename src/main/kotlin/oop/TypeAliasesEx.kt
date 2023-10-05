package oop

// What is a typealias? A typealias is abbreviating a large name for a type into a smaller name.
// TypeAliases can make the code more concise and more readable. Could save on time as well.

data class SuperLargeNameThatIWontWriteAgain( val disaster: String)

typealias longName = SuperLargeNameThatIWontWriteAgain
fun main() {

    // allows us to create an object with the abbreviation
    val theName = longName("terrible disaster")
    println(theName)
}