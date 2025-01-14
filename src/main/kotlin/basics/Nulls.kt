package basics

/**
 * What is null? What is a null pointer exception?
 *
 * Null - the absence of a value; not equal to 0, but can hold 0 as a value, and is not an empty string.
 *
 * One of the most key reasons as to why we should use Kotlin for Android dev over Java, is the fact Kotlin handles
 * nulls safely. In Kotlin, null values are checked by the compiler at compile time, meaning if there is a NPE,
 * null pointer exception, the program won't run at all, and that will have to be resolved.
 */

fun main() {

    /**
     * Kotlin handles null safety in a few ways:
     *
     * 1. Safe operator
     * 2. Elvis operator
     * 3. Nullable types
     * 4. Not-Null Assertion operator
     * 5. Nullable receiver
     * 6. Let scope function
     * 7. Safe casts
     *
     * Safe casts aren't generally used often but are an approach that we can use.
     */

    // Nullable types & null receiver - variables have the option to be nullable
    val name: String? = null
    println(name.equals("Stefan")) // false

    // safe operator - check if null or not
    println(name?.length) // null

    // elvis operator - if/then conditional check
    val newLength = name?.length ?: 0
    println(newLength) // 0

    // not null - ensures the value is not null
    println(newLength!!) // 0

    // let - scope function that allows us to manipulate null values
    println(newLength.let {
        it == it.plus(10) // false
    })

    // safe casts
    val myCastNumber = 3
    val newCasts: String? = myCastNumber as? String
    println(newCasts) // null

    /**
     * false
     * null
     * 0
     * 0
     * false
     * null
     */
}
