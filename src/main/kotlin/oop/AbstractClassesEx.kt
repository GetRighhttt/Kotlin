package oop

/**
 * An abstract class cannot be instantiated directly. It can have constructors,
 * stored properties, implemented methods, and abstract members.
 */
abstract class Home {
    init { println("Home initialization runs while constructing a subclass.") }
    abstract fun cleanHouse()
    abstract fun cleanYard()
    companion object { const val TAG = "HOME" }
}

// A class has one superclass, but can implement multiple interfaces.
abstract class Yard
class MyHouse : Home() {
    override fun cleanHouse() { println("I have cleaned my house.") }
    override fun cleanYard() { println("I have cleaned my yard!") }
}

fun main() {
    val newHouse = MyHouse()
    newHouse.cleanHouse()
    newHouse.cleanYard()
    println(Home.TAG) // HOME
}
