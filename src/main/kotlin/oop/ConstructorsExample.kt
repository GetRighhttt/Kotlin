package oop

class PersonExample(
    private val name: String,
    private var age: Int,
    isHappy: Boolean // Constructor parameter, not a stored property.
) {
    private val nickName: String
    // init runs during construction, after these primary constructor values are available.
    init {
        require(age >= 0) { "Age must not be negative." }
        val smiley = if (isHappy) ":)" else ":("
        nickName = "$name $smiley"
    }
    fun description(): String = "Name: $nickName age: $age"
    fun hadBirthday() { age += 1 }
}

fun main() {
    val bob = PersonExample("Bob", 41, isHappy = true)
    println(bob.description()) // Name: Bob :) age: 41
    bob.hadBirthday()
    println(bob.description()) // Name: Bob :) age: 42
}
