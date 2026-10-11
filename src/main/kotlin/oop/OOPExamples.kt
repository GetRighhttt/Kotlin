package oop

import advancedkotlin.functional.repeatName

// val and var in a constructor declare properties. A plain parameter does not.
// Classes and overridable members need open unless they are abstract.
open class Student(val name: String, var age: Int) {
    override fun toString(): String = "$name is $age years old"

    fun printSomeData(data: String) {
        // A local class is only visible within this function.
        class NewData(val someData: String) {
            fun result(): String = if (someData.length < 3) "Data too short." else someData.uppercase()
        }
        println(NewData(data).result())
    }
}

open class Teacher(val name: String) {
    // Composition: a teacher has a student. lazy creates it on first access.
    // Deferring work is useful in some contexts, but is not automatically faster.
    private val newStudent by lazy { Student("Zion", 5) }
    fun printStudentName(): String = newStudent.name
    fun printStudentAge(): Int = newStudent.age
}

class MyNewPlayer(name: String, age: Int) : Student(name, age), BallRoller {
    // These are nested classes: no outer MyNewPlayer instance is needed.
    class OldPlayer(val name: String) { fun returnOldName(): String = name.uppercase() }
    class ClassicPlayer(val name: String) { fun returnClassicName(): List<Char> = name.repeatName() }

    // inner gives access to this particular player's name.
    inner class TeamMate(val teammateName: String) {
        fun pairing(): String = "$name and $teammateName"
    }

    var score: Int = 20
        set(value) { field = value.coerceAtLeast(0) }
}

// Interfaces can contain implementations, but cannot store state in backing fields.
interface BallRoller {
    fun rollBall(times: Int): Int {
        require(times >= 0) { "The count must not be negative." }
        return times
    }
}

data class TeacherIDs(val id: List<Int>)
object NewTeacher : Teacher("New Teacher") {
    val teacherIds by lazy { TeacherIDs((1..9).toList()) }
}

fun main() {
    val myStudent = Student("DJ", 25)
    val yourStudent = Student("Stefan", 26)
    val thisNewPlayer = MyNewPlayer("Luther", 10)
    val thisTeacher = Teacher("Ayesha")
    // Inheritance: MyNewPlayer is a Student, so it fits in List<Student>.
    val theseStudents: List<Student> = listOf(myStudent, yourStudent, thisNewPlayer)
    theseStudents.filter { it.age >= 5 }.sortedBy { it.age }.forEach(::println)
    println("${yourStudent.name} and ${myStudent.name} have been friends for over 10 years.")
    println("Luther rolled the ball ${thisNewPlayer.rollBall(10)} times for ${thisNewPlayer.score} points.")
    println("${thisTeacher.printStudentName()} is in ${thisTeacher.name}'s Math class.")
    println("${thisTeacher.printStudentName()} is ${thisTeacher.printStudentAge()} years old.")
    println(NewTeacher.name) // New Teacher
    println(NewTeacher.teacherIds) // TeacherIDs(id=[1, 2, 3, 4, 5, 6, 7, 8, 9])

    println(MyNewPlayer.OldPlayer("Stefan").returnOldName()) // STEFAN
    println(MyNewPlayer.ClassicPlayer("George").returnClassicName())
    println(thisNewPlayer.TeamMate("DJ").pairing()) // Luther and DJ
    myStudent.printSomeData("hi") // Data too short.
    myStudent.printSomeData("Kotlin") // KOTLIN
    thisNewPlayer.score = -5
    println(thisNewPlayer.score) // 0: the setter clamps negative scores.
}
