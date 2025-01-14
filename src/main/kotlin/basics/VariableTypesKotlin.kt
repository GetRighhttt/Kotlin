package basics

fun main() {
    /**
     * Var = mutable(able to be changed)
     * Val = immutable(not able to be changed unless using a custom getter).
     */
    val thisVariableIsChangeable = "Mutable Variable."
    val thisVariableIsNotChangeable = "Immutable Variable."
    val myAge = 22

    println("Here are the strings and Age: ")
    println("$thisVariableIsChangeable $thisVariableIsNotChangeable $myAge")


    println("-----------------------------------------------------------------")
    println("Now we're going to print the primitive types and their data types: ")

    val myByteAge: Byte = 22 // isn't inferred automatically by compiler
    val myNumber: Short = 325 // isn't inferred automatically by compiler
    val newAge = 34
    val newLongNumber = 78L
    val newFloatNumber = 3.0F
    val newDoubleNumber = 3.5
    val newCharacter = 'W'
    val newString = "This is a new string."

    // variable::class.simpleName prints the type of the variable
    println("$myByteAge type is: " + myByteAge::class.simpleName)
    println("$myNumber type is: " + myNumber::class.simpleName)
    println("$newAge type is: " + newAge::class.simpleName)
    println("$newLongNumber type is: " + newLongNumber::class.simpleName)
    println("$newFloatNumber type is: " + newFloatNumber::class.simpleName)
    println("$newDoubleNumber type is: " + newDoubleNumber::class.simpleName)
    println("$newCharacter type is: " + newCharacter::class.simpleName)
    println("$newString type is: " + newString::class.simpleName)

    println("-----------------------------------------------------------------")
    println("Now we're going to print some unicode characters: ")

    val newR = '\u00ae' // ®
    val newLatinCapitalAE = '\u00c6'
    println(newR)
    println(newLatinCapitalAE)

    /**
     * val is known at runtime whereas const val is known at compile time, so before the code is executed.
     * Constants are immutable whereas val contents are mutable.
     * Must be declared in top level or companion object.
     * Only primitive or strings can be const.
     */
}