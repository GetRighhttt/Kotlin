package advancedkotlin.datacl

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

val stefan by lazy { Person("Stefan", 27, "5'10", 169.30, "Software Engineer") }
fun getStefanName(): String = stefan.name


// below we call the object without destructuring and just using regular dot notation...
fun getStefanCredentials(): String = """${stefan.name} is ${stefan.age} years old. 
        |He weighs ${stefan.weight} lbs, 
        |and is ${stefan.height} tall! 
        |Stefan works as a ${stefan.job}!""".trimMargin()


data class Human(
    val title: String,
    val age: Int,
    val userName: String,
    val career: String
)

data class Basketball(
    val circumference: Double,
    val radius: Double,
    val weight: Double
)
typealias bball = Basketball

fun main() {
    println(getStefanName()) // Stefan
    println(getStefanCredentials())

    /**
     * Destructuring example of a data class in Kotlin. Destructuring allows us to remove the dot notation
     * and just return a value. Reduces the line of code via a component.
     */
    val person by lazy { Human("Sir", 22, "Stefan", "Engineer") }
    val (title, age, userName, career) = person

    println(title) // instead of: person.title
    println(age) // instead of: person.age
    println(userName) // instead of: person.userName
    println(career) // instead of: person.career

    // creating a basketball object and destructing it using the username we created from our person object
    val myBasketball by lazy { bball(100.0, 30.0, 20.0) }
    val (circumference, radius, weight) = myBasketball // destruction example again
    println(
        """$userName has a basketball with a circumference of $circumference, with a radius of $radius, and a weight of $weight.
    """.trimMargin()
    )

    val personCopy by lazy { person.copy(title = "Ma'am", age = 30, userName = "Woman", career = "Nurse") }
    val (titleCopy, ageCopy, userNameCopy, careerCopy) = personCopy
    println("Printing the copy of the data class below...")
    println("$titleCopy is $ageCopy and has a username of $userNameCopy. She works as a $careerCopy!") // Ma'am 30 Woman Nurse

    val personHashCode = person.hashCode()
    println(personHashCode) // prints hash code for the person object

    val personEquals = person == personCopy
    println(personEquals) // returns false since they are not equal to each other

    val newPersonCopy by lazy { person.copy(title = "Shawn", age = 20, userName = "ShawnPDiddy", career = "Business") }
    val (name, year, user, job) = newPersonCopy
    println("$name is $year and has a username of $user. They works as a $job!") // Ma'am 30 Woman Nurse

}