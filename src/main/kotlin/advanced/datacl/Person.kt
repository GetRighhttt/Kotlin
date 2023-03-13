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

fun getStefanCredentials(): String {
    return """${stefan.name} is ${stefan.age} years old. 
        |He weighs ${stefan.weight} lbs, 
        |and is ${stefan.height} tall! 
        |Stefan works as a ${stefan.job}!""".trimMargin()
}
fun main() {
    println(getStefanName()) // Stefan
    println(getStefanCredentials())
    /*
    Stefan is 27 years old.
    He weighs 169.3 lbs,
    and is 5'10 tall!
    Stefan works as a Software Engineer!
     */
}