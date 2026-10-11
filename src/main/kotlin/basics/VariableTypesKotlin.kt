package basics

// const val is a compile-time constant. It belongs at top level or in an object.
// Its value must be a String or primitive value known at compile time.
private const val WELCOME_MESSAGE = "Kotlin variable types"

fun main() {
    println(WELCOME_MESSAGE)

    // var can be reassigned. A local val cannot be reassigned after initialization.
    var thisVariableIsChangeable = "Mutable variable."
    val thisVariableIsNotChangeable = "Read-only variable."
    val myAge = 22
    println("$thisVariableIsChangeable $thisVariableIsNotChangeable $myAge")

    thisVariableIsChangeable = "The var now holds a different string."
    println(thisVariableIsChangeable)
    // thisVariableIsNotChangeable = "Another string" // This does not compile.

    // val fixes the reference; a mutable object held by that reference can change.
    val names = mutableListOf("Stefan")
    names.add("Bob")
    println(names) // [Stefan, Bob]

    // A val with a custom getter can compute a new result on each access.
    // It still has no setter. See BackingProperty.kt for property accessors.

    println("Now we're going to print some basic types:")
    val myByteAge: Byte = 22 // Without the explicit type, 22 is inferred as Int.
    val myNumber: Short = 325
    val newAge = 34
    val newLongNumber = 78L
    val newFloatNumber = 3.0F
    val newDoubleNumber = 3.5
    val newCharacter = 'W'
    val newString = "This is a new string."

    // ::class.simpleName shows the Kotlin type name.
    println("$myByteAge type is: ${myByteAge::class.simpleName}") // Byte
    println("$myNumber type is: ${myNumber::class.simpleName}") // Short
    println("$newAge type is: ${newAge::class.simpleName}") // Int
    println("$newLongNumber type is: ${newLongNumber::class.simpleName}") // Long
    println("$newFloatNumber type is: ${newFloatNumber::class.simpleName}") // Float
    println("$newDoubleNumber type is: ${newDoubleNumber::class.simpleName}") // Double
    println("$newCharacter type is: ${newCharacter::class.simpleName}") // Char
    println("$newString type is: ${newString::class.simpleName}") // String

    println("Now we're going to print some Unicode characters:")
    val registeredTrademark = '\u00ae'
    val latinCapitalAE = '\u00c6'
    println(registeredTrademark) // ®
    println(latinCapitalAE) // Æ
}
