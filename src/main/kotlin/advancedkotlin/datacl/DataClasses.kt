package advancedkotlin.datacl

/**
 * data generates equals, hashCode, toString, copy, and componentN functions from
 * the primary constructor properties. A copy is shallow, not a deep clone.
 * Regular Kotlin classes are also final by default.
 */
data class Person(
    val name: String,
    val age: Int,
    val height: String,
    val weight: Double,
    val job: String
)
val stefan = Person("Stefan", 27, "5'10", 169.30, "Software Engineer")
fun getStefanName(): String = stefan.name
fun getStefanCredentials(): String = """
    |${stefan.name} is ${stefan.age} years old.
    |He weighs ${stefan.weight} lbs and is ${stefan.height} tall!
    |Stefan works as a ${stefan.job}!
""".trimMargin()

data class Human(val title: String, val age: Int, val userName: String, val career: String)
data class Basketball(val circumference: Double, val radius: Double, val weight: Double)
typealias Bball = Basketball

fun main() {
    println(getStefanName()) // Stefan
    println(getStefanCredentials())
    val person = Human("Sir", 22, "Stefan", "Engineer")
    // Destructuring calls component1(), component2(), etc., in constructor order.
    val (title, age, userName, career) = person
    println("$title $userName is $age and works as an $career.")

    val myBasketball = Bball(100.0, 30.0, 20.0) // Arbitrary values for syntax practice.
    val (circumference, radius, weight) = myBasketball
    println("$userName has a basketball: circumference=$circumference, radius=$radius, weight=$weight.")

    val personCopy = person.copy(title = "Ma'am", age = 30, userName = "Woman", career = "Nurse")
    println(personCopy) // Human(title=Ma'am, age=30, userName=Woman, career=Nurse)
    println(person == personCopy) // false: constructor properties differ.
    println(person == person.copy()) // true: equal values in separate instances.
    println(person === person.copy()) // false: not the same instance.
    val newPersonCopy = person.copy(title = "Shawn", age = 20, userName = "ShawnPDiddy", career = "Business")
    println(newPersonCopy)
}
