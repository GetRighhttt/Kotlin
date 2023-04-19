package oop

class PersonExample(
    // private variables is a good practice and an OOP conceptual best practice
    private val name: String,
    private var age: Int,
    private val isHappy: Boolean
) {

    private val nickName: String

    /*
    Runs code when instances of the class are created.

    Used extensively in the real world.
     */
    init {
        val smiley = if (isHappy) ":)" else ":("
        nickName = "$name $smiley"
    }

    fun description(): String {
        return "Name: $nickName age: $age"
    }

    fun hadBirthday() {
        age += 1
    }
}

fun main() {
    // using namedArgument for isHappy boolean to be specific and for readability
    val brandon = PersonExample("Bob", 41, isHappy = true)

    // get description and birthday
    println(brandon.description())

    brandon.hadBirthday()
    println(brandon.description())
}