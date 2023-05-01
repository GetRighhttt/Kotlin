package designpatterns.creational

/*
The prototype method hinges on the idea of copying an object, and extending its functionality so other
objects can be manipulated by that clone. It's best seen when creating a data class, and using the copy
method.
 */
data class Person(
    val name: String,
    val age: Int
)

fun main() {
    val newPerson = Person("Stefan", 22)
    val oldPerson = newPerson.copy(name = "bob", age = 50)

    val (names, ages) = oldPerson
    println(names)
    println(ages)
}