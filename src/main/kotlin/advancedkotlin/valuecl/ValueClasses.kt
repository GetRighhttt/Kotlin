package advancedkotlin.valuecl

/*
In programming and development, we want to allocate memory as efficiently as possible.
When working with classes, data classes, etc., often we are creating new objects when sometimes we don't need
to, and in return we are taking up more space in memory than necessary.

When we are working with single values, Kotlin has introduced a new concept called value classes,
which allows us to create values as a class without having to create a new memory instance or object in the
heap. This allows us to allocate resources more efficiently.

Value classes essentially work the same as regular classes, except they do not create objects in memory.
They also can only have one parameter in their constructor because they are literally only for
one value.
 */

// annotation necessary for value classes
@JvmInline
value class Name(val name: String = "Joe Smiley") {

    // value classes can have init blocks
    init {
        println("Value class created efficiently.")
        Thread.sleep(2000)
    }

    fun printNameReversed() = name.reversed()

    // we can also create companion objects in value classes
    companion object {
        private const val firstName: String = "Stefan"
        private const val lastName: String = "Buddy"

        private fun returnName() = "$firstName $lastName"
        override fun toString(): String = returnName()
    }
}

fun main() {

    // calls init block and prints name reversed and creates new object
    val nameReversedUppercase = Name().printNameReversed().uppercase()
    println(nameReversedUppercase)
    println(nameReversedUppercase.hashCode())
    println("\n")

    // creating new object
    val nameReversedLowercase = Name().printNameReversed().lowercase()
    println(nameReversedLowercase)
    println(nameReversedLowercase.hashCode())
    println("\n")

    // when calling a class without the (), we call the companion object of the class.
    println(Name.hashCode())

    // calls companion object toString() method
    println(Name.toString())

    // prints hashcode
    println(Name.hashCode())
    println(Name().name.hashCode())
    println(Name().name.hashCode())

    /*\
    We can see in the output that all hashcodes align for the companion object meaning that
    we did not create a new object each time we called the companion object.

    Also, the hashcodes when just calling the name parameter itself is the same when called both
    times meaning the value has not changed.

    Value class created efficiently.
    YELIMS EOJ
    1484838447


    Value class created efficiently.
    yelims eoj
    998792783


    1023892928
    Stefan Buddy
    1023892928
    Value class created efficiently.
    324569873
    Value class created efficiently.
    324569873
     */
}