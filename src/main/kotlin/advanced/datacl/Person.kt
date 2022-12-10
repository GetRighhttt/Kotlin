package advanced.datacl

/**
 * Data classes were merely created as data holders and are usually what we
 * use to create JSON objects in android development.
 */
data class Person(
    val name: String,
    val age: Int,
    val height: String,
    val weight: Double
)

val stefan: Person = Person("Stefan", 27, "5'10", 169.30)
fun getStefanName(): String {
    return stefan.name
}
fun main() {
    println(getStefanName())
}