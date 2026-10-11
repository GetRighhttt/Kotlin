package oop

// A typealias is another name for an existing type, not a new distinct type.
data class SuperLargeNameThatIWontWriteAgain(val disaster: String)
data class ExampleTypeAlias(val example: String)
typealias LongName = SuperLargeNameThatIWontWriteAgain
typealias NewExample = ExampleTypeAlias

fun main() {
    val theName = LongName("terrible disaster")
    println(theName) // SuperLargeNameThatIWontWriteAgain(disaster=terrible disaster)
    val originalType: SuperLargeNameThatIWontWriteAgain = theName // Same type.
    println(originalType == theName) // true
    val thisExample = NewExample("this is an example of another typealias")
    println(thisExample)
    println(thisExample.toString().uppercase())
}
