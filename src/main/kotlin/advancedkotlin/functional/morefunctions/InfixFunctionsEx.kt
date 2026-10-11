package advancedkotlin.functional.morefunctions

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

// An infix function is a member or extension with one non-vararg parameter,
// without a default. Its calls can omit the dot and parentheses.
infix fun String.newName(name: String): String = name // Returns a new name; does not mutate String.
infix fun Int.multipliedBy(factor: Int): Int = this * factor
infix fun <T : Comparable<T>> T.isGreaterThan(other: T): Boolean = this > other

// Like let, this passes the receiver to the block and returns the block's result.
@OptIn(ExperimentalContracts::class)
inline infix fun <T, R> T.allowFor(block: (T) -> R): R {
    contract { callsInPlace(block, InvocationKind.EXACTLY_ONCE) }
    return block(this)
}

// A contract describes a promise to the compiler; it does not perform a runtime check.
@OptIn(ExperimentalContracts::class)
fun String?.hasText(): Boolean {
    contract { returns(true) implies (this@hasText != null) }
    return !isNullOrBlank()
}

abstract class TextInfix(var text: String) {
    abstract infix fun isRemoving(part: String)
    abstract infix fun isSetting(value: String)
}

class SampleText : TextInfix("Sample") {
    override infix fun isRemoving(part: String) {
        text = text.replace(part, "")
    }
    override infix fun isSetting(value: String) {
        text = value
    }
    fun isStarting(prefix: String): Boolean = text.startsWith(prefix)
}

fun main() {
    val actualName = "" newName "Stefan"
    val theirAge = 12 multipliedBy 3
    println("$actualName is my name and my age times three is $theirAge.")
    println("If I multiply my age again by 3, it is ${theirAge multipliedBy 3}.") // 108
    println(theirAge isGreaterThan 30) // true

    val children = 1 allowFor { it + 2 }
    println("I have $children kids.") // 3
    children allowFor { println("This incremented value by 1 times 2 is: ${(it + 1) * 2}") } // 8

    val sample = SampleText()
    sample isSetting "Sample text"
    sample isRemoving "Sample "
    println(sample.text) // text
    println(sample.isStarting("te")) // true

    val name: String? = listOf("Stefan").firstOrNull()
    if (name.hasText()) println(name.length) // 6: contract enables the smart cast.
    // The old SimpleEffect cast experiment is preserved in commit 7e6620d.
}
