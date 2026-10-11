package advancedkotlin.valuecl

/**
 * A value class wraps a value with a distinct type. On the JVM, @JvmInline allows
 * an unboxed representation in some contexts. Generic, nullable, or interface
 * uses can require boxing, so “never allocates an object” would be incorrect.
 */
@JvmInline
value class Name(val name: String = "Joe Smiley") {
    init {
        require(name.isNotBlank()) { "A name must not be blank." }
    }
    fun printNameReversed(): String = name.reversed()

    companion object {
        private const val FIRST_NAME = "Stefan"
        private const val LAST_NAME = "Buddy"
        override fun toString(): String = "$FIRST_NAME $LAST_NAME"
    }
}

fun main() {
    val name = Name()
    println(name.printNameReversed().uppercase()) // YELIMS EOJ
    println(name.printNameReversed().lowercase()) // yelims eoj
    println(Name.toString()) // Stefan Buddy: access to the companion object
    println(Name("Stefan") == Name("Stefan")) // true: value equality
    // Equal hash codes do not establish that two values are the same object.
    val boxed: Any = name
    println(boxed) // Name(name=Joe Smiley); using Any requires a boxed representation.
}
