package androidconcepts

/**
 * A backing field stores a property's value. Inside an accessor, field refers
 * to that storage. Assigning age inside its own setter would call the setter again.
 * This is Kotlin syntax, even though it is also useful in Android code.
 */
class Human {
    var age: Int = 0
        get() = field
        set(value) {
            require(value >= 0) { "Age must not be negative." }
            field = value
        }

    // Computed properties use age and have no backing fields of their own.
    private val isABaby: Boolean get() = age <= 5
    private val isYoung: Boolean get() = age in 6..30
    private val isMiddleAge: Boolean get() = age in 31..49
    private val isOld: Boolean get() = age >= 50

    fun getAgeFromBackingField(): Int = age
    fun determineAgeBracket() {
        // These ranges are practice classifications, not medical guidance.
        val message = when {
            isABaby -> "You are a baby!"
            isYoung -> "You are young!"
            isMiddleAge -> "You are middle aged!"
            isOld -> "You are old!"
            else -> "Cannot detect age."
        }
        println(message)
    }
}

fun main() {
    val newHuman = Human()
    newHuman.age = 40
    println(newHuman.getAgeFromBackingField()) // 40
    newHuman.age = 25
    println(newHuman.getAgeFromBackingField()) // 25
    newHuman.determineAgeBracket() // You are young!

    println("Enter a non-negative age:")
    val age = readlnOrNull()?.toIntOrNull()
    if (age == null || age < 0) {
        println("No valid age was supplied.")
        return
    }
    newHuman.age = age // Exercise the setter instead of duplicating its logic in main.
    newHuman.determineAgeBracket()
    // The earlier age-offset and thread-delay experiments remain in Git history.
}
