package advanced.datacl

/**
 * Data classes were merely created as data holders and are usually what we
 * use to create JSON objects in android development.
 *
 * Data classes in java were known as plain old java objects, and only has getters, setters, and
 * an implementation or equals(), clone(), or hashcode().
 *
 * Data classes are just like regular classes except they are final by default,
 * meaning no other class can inherit from them.
 */
data class Person(
    val name: String,
    val age: Int,
    val height: String,
    val weight: Double,
    val job: String
)

val stefan: Person = Person("Stefan", 27, "5'10", 169.30, "Software Engineer")
fun getStefanName(): String {
    return stefan.name
}

// below we call the object without destructuring and just using regular dot notation...
fun getStefanCredentials(): String {
    return """${stefan.name} is ${stefan.age} years old. 
        |He weighs ${stefan.weight} lbs, 
        |and is ${stefan.height} tall! 
        |Stefan works as a ${stefan.job}!""".trimMargin()
}

data class Human(
    val title: String,
    val age: Int,
    val userName: String,
    val career: String
)

fun main() {
    println(getStefanName()) // Stefan
    println(getStefanCredentials())
    /*
    Stefan is 27 years old.
    He weighs 169.3 lbs,
    and is 5'10 tall!
    Stefan works as a Software Engineer!
     */

    /*
    Destructuring example of a data class in Kotlin. Destructuring allows us to remove the dot notation
     and just return a value. Reduces the line of code via a component.
     */
    val person = Human("Sir", 22, "Stefan", "Engineer")
    val (title, age, userName, career) = person

    println(title) // instead of: person.title
    println(age) // instead of: person.age
    println(userName) // instead of: person.userName
    println(career) // instead of: person.career

    /*
    Sir
    22
    Stefan
    Engineer
     */

    /*
    We can also copy a data class using the copy() method, and if we want, we can use named parameters
    to change the values.
     */
    val personCopy = person.copy(title = "Ma'am", age = 30, userName = "Woman", career = "Nurse")
    val (titleCopy, ageCopy, userNameCopy, careerCopy) = personCopy
    println("$titleCopy $ageCopy $userNameCopy $careerCopy") // Ma'am 30 Woman Nurse

    val personHashCode = person.hashCode()
    println(personHashCode) // prints hash code for the person object

    val personEquals = person.equals(personCopy)
    println(personEquals) // returns false since they are not equal to each other

}