package oop

import advancedkotlin.functional.repeatName

/*
In Kotlin, when we pass in values and variables in the primary constructor, getters and setters
are automatically generated in the compiler for us to use in main.

To allow a class to be inherited from, in Kotlin we have to use the open keyword. And that goes
for properties of classes as well.
 */
open class Student(open val name: String, open var age: Int) {
    override fun toString(): String {
        return "$name is $age years old"
    }
}

/*
If we want to pass in a mutable value not in the primary constructor, we declare it in the class
body, and we must provide an initial value.
 */
open class Teacher(open val name: String) {
    private var studentName: String = "Zion"
    private var studentAge: Int = 5

    /*
    Below we instantiate a student in the teacher's class, because a teacher has students.
    this is how Composition works.
    Composition is another OOP concept that demonstrates a "has-a" relationship, while inheritance demonstrates
    an "is-a" relationship. It allows for more loosely coupled coding.
     */
    private val newStudent by lazy {
        Student(
            studentName,
            studentAge
        )
    } // an example of composition "has-a" relationship.

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

    /*
    Nested classes are good for having a specific source about a class.
    */
    class OldPlayer(val name: String) { fun returnOldName() = name.uppercase() }
    class ClassicPlayer(val name: String) { fun returnClassicName() = name.repeatName() }

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

/*
Data classes are used for holding data and have some methods generated.
 */
data class TeacherIDs(val id: List<Int>)

/*
Objects are usually used for Singletons.
 */
object NewTeacher : Teacher(name = "New Teacher") {
    init {
        println("$name created successfully.")
    }

    val teacherIds by lazy { TeacherIDs(listOf(1, 2, 3, 4, 5, 6, 7, 8, 9)) }

    @JvmName("getTeacherIds1")
    fun getTeacherIds() = teacherIds
}

fun main() {

    // lazy delegation improves performance
    val myStudent by lazy { Student("DJ", 25) }
    val yourStudent by lazy { Student("Stefan", 26) }
    val thisNewPlayer by lazy { MyNewPlayer("Luther", 10) }
    val thisTeacher by lazy { Teacher("Ayesha") }

    // nested class initialization
    val oldPlayer by lazy { MyNewPlayer.OldPlayer("Stefan") }
    val classicPlayer by lazy { MyNewPlayer.ClassicPlayer("George") }

    /*
    Below we are creating a list of all the students, and because thisNewPlayer inherits from Student,
    it still doesn't cause an error in the list although its of type MyNewPlayer.
     */
    val theseStudents by lazy { mutableListOf(myStudent, yourStudent, thisNewPlayer) }
    theseStudents.filter { it.age >= 5 }
        .sortedBy { it.age }
        .forEach(::println)
        .toString()

    /*
    Below we show different ways to print multiple lines of strings again while displaying sentences
    using the classes and interfaces we created above.
     */
    println("\n")
    println(
        """
        |${yourStudent.name} and ${myStudent.name} have been friends for over 10 years.
        |${yourStudent.name} is ${yourStudent.age} while ${myStudent.name} is ${myStudent.age}!
        |""".trimMargin()
    )
    println(
        "${thisNewPlayer.name} is ${thisNewPlayer.age} years old! ${thisNewPlayer.name}" +
                " rolled the ball ${thisNewPlayer.rollBall(10)} times for a score of" +
                " ${thisNewPlayer.score} points!\n"
    )
    /*
    Below we display how composition can be used to display the student declared in the
    teacher's class with the methods we created in the teacher's class also.
     */
    println(
        """${thisTeacher.printStudentName()} is in ${thisTeacher.name}'s 
            |Math class, and is ${thisTeacher.printStudentAge()} years old!
            |${thisTeacher.printStudentName()} has been a great student! 
            |Keep up the great work ${thisTeacher.printStudentName()}!""".trimMargin()
    )

    /*
    We can also use objects and extend classes from them as well, which technically isn't best practice, but it
    can be done.
    We should see the init block output before this when we run the program.
     */
    println("${NewTeacher.name} is the name of the object created.")
    val teacherIDList = NewTeacher.teacherIds.id.size
    println(teacherIDList.toString())
    println(NewTeacher.getTeacherIds())

    println("This is the old player name from the nested class ${ oldPlayer.returnOldName() }.")
    println("This is the classic player name from the nested class ${ classicPlayer.returnClassicName() }.")
}

/*
Luther is 10 years old
DJ is 25 years old
Stefan is 26 years old


Stefan and DJ have been friends for over 10 years.
Stefan is 26 while DJ is 25!

Luther is 10 years old! Luther rolled the ball 10 times for a score of 20 points!

Zion is in Ayesha's
Math class, and is 5 years old!
Zion has been a great student!
Keep up the great work Zion!
New Teacher created successfully.
New Teacher is the name of the object created.
9
TeacherIDs(id=[1, 2, 3, 4, 5, 6, 7, 8, 9])
This is the old player name from the nested class STEFAN.
This is the classic player name from the nested class [G, e, o, r, g, e, G, e, o, r, g, e, G, e, o, r, g, e].
 */