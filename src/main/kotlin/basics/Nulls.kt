package basics

/**
 * null means there is no value. It is different from zero or an empty string.
 * A nullable type ends in ?, such as String?.
 *
 * Kotlin checks nullable access at compile time. We can still cause a null pointer
 * exception with !! or through Java interop, so how we handle null matters.
 */
fun main() {
    val name: String? = null

    // This equals extension accepts a nullable receiver.
    println(name.equals("Stefan")) // false

    // A safe call (?.) skips the property access when the receiver is null.
    println(name?.length) // null

    // Elvis (?:) supplies a fallback when the expression on the left is null.
    val length = name?.length ?: 0
    println(length) // 0; length has non-null type Int

    // An ordinary null check lets the compiler smart-cast a local val.
    val friend: String? = listOf("Stefan").firstOrNull()
    if (friend != null) {
        println(friend.length) // 6
    }

    // ?.let runs the block only when a value is present.
    name?.let { println("This will not print: $it") }
    friend?.let { println(it.uppercase()) } // STEFAN

    // !! asserts that a nullable value is present. It throws if the value is null.
    println(friend!!.length) // 6
    // println(name!!.length) // Uncomment to see a NullPointerException.

    // A safe cast (as?) returns null when the value is not the requested type.
    val value: Any = 3
    val text = value as? String
    println(text) // null
    println(value as? Int) // 3
}
