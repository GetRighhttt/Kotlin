package basics

/*
Now we will go over types in Kotlin.
 */

/*
val is known at runtime whereas const val is known at compile time, so before the code is executed.
Contents are immutable whereas val contents are mutable.
Must be declared in top level or companion object.
Only primitive or strings can be const.
*/
fun main() {
    /*
    Var = mutable(able to be changed) while Val = immutable(not able to be changed).
     */
    val thisVariableIsChangeable = "Mutable Variable."
    val thisVariableIsNotChangeable = "Immutable Variable."
    val myAge = 22

    println("Here are the strings and Age: ")
    /*
    printing the strings using Kotlin String concatenation and template.

    "$" are used for Strings in Kotlin and in Java sometimes.
     */
    println("$thisVariableIsChangeable $thisVariableIsNotChangeable $myAge")
    /*
    Output:

    Here are the strings and Age:
    Mutable Variable. Immutable Variable. 22
    */

    println("-----------------------------------------------------------------")
    println("Now we're going to print the primitive types and their data types: ")
    /*
    This is how we can declare primitive types in Kotlin.
    Primitive types: Byte, Short, Int, Long, Float, Double, Boolean
    Non-Primitive Types: Char, String
     */
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

    /*
    Output:

    -----------------------------------------------------------------
    Now we're going to print the primitive types and their data types:
    22 type is: Byte
    325 type is: Short
    34 type is: Int
    78 type is: Long
    3.0 type is: Float
    3.5 type is: Double
    W type is: Char
    This is a new string. type is: String
     */

    println("-----------------------------------------------------------------")
    println("Now we're going to print some unicode characters: ")

    val newR = '\u00ae' // ®
    val newLatinCapitalAE = '\u00c6'
    println(newR)
    println(newLatinCapitalAE)

    /*
    Output:

    -----------------------------------------------------------------
    Now we're going to print some unicode characters:
    ®
    Æ
     */
}