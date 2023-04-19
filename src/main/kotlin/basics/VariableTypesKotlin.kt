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
    var thisVariableIsChangeable: String = "Mutable Variable."
    val thisVariableIsNotChangeable: String = "Immutable Variable."

    /*
    This is how we can declare primitive types in Kotlin.
     */
    val myAge: Int = 22

    println("Here are the strings and Age: ")
    /*
    printing the strings using Kotlin String concatenation and template.

    "$" are used for Strings in Kotlin and in Java sometimes.
     */
    println("$thisVariableIsChangeable $thisVariableIsNotChangeable $myAge")


}

/*
Output:

Here are the strings and Age:
Mutable Variable. Immutable Variable. 22
 */