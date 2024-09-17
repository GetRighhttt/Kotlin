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
const val TAG = "MAIN"
fun main(args: Array<String>) {
    /*
    Var = mutable(able to be changed) while Val = immutable(not able to be changed).
     */
    val thisVariableIsChangeable: String = "Mutable Variable."
    val thisVariableIsNotChangeable: String = "Immutable Variable."
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
    println("Now we're going to print the primtive types and their data types: ")
    /*
    This is how we can declare primitive types in Kotlin.
    Primitive types: Byte, Short, Int, Long, Float, Double, Boolean
    Non-Primitive Types: Char, String
     */
    val myByteAge: Byte = 22 // isn't inferred automatically by compiler
    val myNumber: Short = 325 // isn't inferred automatically by compiler
    val newAge: Int = 34
    val newLongNumber: Long = 78L
    val newFloatNumber: Float = 3.0F
    val newDoubleNumber: Double = 3.5
    val newCharacter: Char = 'W'
    val newString: String = "This is a new string."

    // variable::class.simpleName prints the type of the variable
    println("$myByteAge type is: " + myByteAge::class.simpleName)
    println("$myNumber type is: " + myNumber::class.simpleName)
    println("$newAge type is: " + newAge::class.simpleName)
    println("$newLongNumber type is: " + newLongNumber::class.simpleName)
    println("$newFloatNumber type is: " + newFloatNumber::class.simpleName)
    println("$newDoubleNumber type is: " + newDoubleNumber::class.simpleName)
    println("$newCharacter type is: " + newCharacter::class.simpleName)
    println("$newString type is: " + newString::class.simpleName)
}