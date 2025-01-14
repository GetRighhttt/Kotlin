package oop

/**
 * Abstract classes are classes that are meant to be inherited from and cannot be instantiated.
 * Think of them like interfaces but with the functionality of a class.
 *
 * The difference between abstract classes and interfaces is that abstract classes can have everything interfaces can
 * have, but also they can have fields(private and protected properties), can have final methods, and constructors.
 *
 * Abstract classes are sometimes called "incomplete classes" because cannot be instantiated, and act like an interface,
 * whereas an interface is referred to a template of a class.
 */

abstract class Home {

    init {
        println("Abstract class $TAG created.")
    }

    abstract fun cleaHouse()
    abstract fun cleanYard()

    companion object {
        const val TAG = "HOME"
    }
}

// This class was used as a demo to show classes cannot extend numerous abstract classes
abstract class Yard {}

class MyHouse : Home() {
    override fun cleaHouse() {
        println("I have cleaned my house.")
    }

    override fun cleanYard() {
        println("I have cleaned my yard!")
    }
}

fun main() {
    val newHouse = MyHouse()

    println(newHouse.cleaHouse())
    println(newHouse.cleanYard())
}