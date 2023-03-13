package oop

/*
In Kotlin, when we pass in values and variables in the primary constructor, getters and setters
are automatically generated in the compiler for us to use in main.

To allow a class to be inherited from, in Kotlin we have to use the open keyword. And that goes
for properties of classes as well.
 */
open class Student(open val name: String, var age: Int)

/*
If we want to pass in a mutable value not in the primary constructor, we declare it in the class
body, and we must provide an initial value.
 */
class Teacher(val name: String) {
    var age: Int = 0
}

/*
If we want to have a mutable property with some validations like making sure the score is above 0,
we can define an explicit setter for this.

Here we inherit from the Student class because a new player is still a student. Since the name parameter
has the same name as the student, we have to override it so that it can be used. We could also just
change the parameter to a different name but for demo purposes, we won't.
 */
class MyNewPlayer(override val name: String) : Student(name, 30) {

    var score: Int = 0
        set(value) {
            field = if (value >= 0) {
                value
            } else {
                0
            }
        }
}

/*
In Kotlin, we use interfaces to define behavior, and they can also have default methods if those methods
do not hold state.

Interfaces are meant to be inherited, and we do so in Kotlin with colons.

Ex: class BasketballPlayer(val name: String) : BallRoller {
    // some logic
}
 */
interface BallRoller {
    fun rollBall(): Int
}

fun main() {

    val myStudent = Student("John", 25)
    val yourStudent = Student("Stefan", 28)
    val thisNewPlayer = MyNewPlayer("Bobby")
    thisNewPlayer.score = 20

    val thisTeacher = Teacher("Ayesha")
    thisTeacher.age = 80
}