package oop

import java.util.stream.Collectors

/*
In Kotlin, when we pass in values and variables in the primary constructor, getters and setters
are automatically generated in the compiler for us to use in main.

To allow a class to be inherited from, in Kotlin we have to use the open keyword. And that goes
for properties of classes as well.
 */
open class Student(open val name: String, open var age: Int)

/*
If we want to pass in a mutable value not in the primary constructor, we declare it in the class
body, and we must provide an initial value.
 */
class Teacher(val name: String) {
    var studentName: String = "Zion"
    var studentAge: Int = 5

    /*
    Below we instantiate a student in the teacher's class, because a teacher has students.
    this is how Composition works.
    Composition is another OOP concept that demonstrates a "has-a" relationship, while inheritance demonstrates
    an "is-a" relationship. It allows for more loosely coupled coding.
     */
    private val newStudent = Student(studentName, studentAge) // an example of composition "has-a" relationship.

    fun printStudentName(): String = newStudent.name
    fun printStudentAge(): Int = newStudent.age
}

/*
If we want to have a mutable property with some validations like making sure the score is above 0,
we can define an explicit setter for this.

Here we inherit from the Student class because a new player is still a student. Since the name parameter
has the same name as the student, we have to override it so that it can be used. We could also just
change the parameter to a different name but for demo purposes, we won't.

We also implement the BallRoller interface and call the rollBall() method in the main function.
 */
class MyNewPlayer(override val name: String, override var age: Int) : Student(name, age), BallRoller {

    var score: Int = 20
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
    fun rollBall(times: Int): Int = times
}

fun main() {

    val myStudent = Student("DJ", 25)
    val yourStudent = Student("Stefan", 26)
    val thisNewPlayer = MyNewPlayer("Luther", 10)
    val thisTeacher = Teacher("Ayesha")

    /*
    Below we are creating a list of all the students, and because thisNewPlayer inherits from Student,
    it still doesn't cause an error in the list although its of type MyNewPlayer.
     */
    val theseStudents = mutableListOf<Student>(myStudent, yourStudent, thisNewPlayer)
    val filterByAge = theseStudents.stream()
        .filter { it.age == 25 }
        .collect(Collectors.toList())
        .sortedBy { it.age }

    /*
    Below we show different ways to print multiple lines of strings again while displaying sentences
    using the classes and interfaces we created above.
     */
    println(
        """
        |${yourStudent.name} and ${myStudent.name} have been friends for over 10 years.
        |${yourStudent.name} is ${yourStudent.age} while ${myStudent.name} is ${myStudent.age}!
        |""".trimMargin()
    )
    println(
        "${thisNewPlayer.name} is ${thisNewPlayer.age} years old! ${thisNewPlayer.name}" +
                " rolled the ball ${thisNewPlayer.rollBall(10)} times for a score of" +
                " ${thisNewPlayer.score} points!"
    )
    /*
    Below we display how composition can be used to display the student declared in the
    teacher's class with the methods we created in the teacher's class also.
     */
    println(
        "${thisTeacher.printStudentName()} is in ${thisTeacher.name}'s " +
                "Math class, and is ${thisTeacher.printStudentAge()} years old!"
    )
}