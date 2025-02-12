package oop

/**
 * In Kotlin, we do not use the word "static" like we did in Java. So, in order for us
 * to create singletons, and declare static variables, we use the keywords "object" and
 * "companion object".
 *
 * Objects behave just like classes and can have properties, methods, and initializers,
 * but they cannot be instantiated.
 *
 * When creating a singleton or creating our own object class, it is called OBJECT DECLARATION.
 *
 * Companion objects should also be at the bottom of the class according to Kotlin standard documentation.
 * https://kotlinlang.org/docs/coding-conventions.html
 */
object Customer {
    private var count: Int = 0 // behaves as static variable

    init {
        println("\nCustomer object has been created...")
        println("Initializing count...\n")
        println("Determining customer type...")

        count = 205
    }

    fun returnCount(): Int = count
    fun typeOfCustomer() = println("American")
}

open class Person {
    init {
        println("Regular class init block started.")
        Thread.sleep(1000)
        println("This block is called right before the object is created in main...")
        Thread.sleep(1000)
            .also { println("The name of the thread we are on is: ${Thread.currentThread().name}") }
    }

    fun notInTheCompanionObject() = println("Not apart of the companion object...")

    init {
        println("\nCompanion object has been created.")
        println("Determining name and age...\n")

        newName = "Bob"
        age = 30
    }

    fun getName() = newName
    fun returnAge() = age

    /**
   Companion objects work just like objects except are held within classes.

   Their most common use cases:

   1. Property needed at class level and not a specific instance level(one variable shared across all objects or
   methods of the class - static).
   2. Factory pattern: perform extra work before an object can be used, or to create objects.
   3. Static variables and methods can be accessed by directly calling the class name also.
    */
    companion object { // behaves like singleton object at a class level

        const val TAG = "PERSON" // this can be used for log statements
        private var newName = ""
        private var age = 0
    }

}

/**
 * Will be used for main object declaration with an abstract class.
 * abstract classes are meant for extension but cannot be instantiated. They're like interfaces
 * but with more capabilities.
 */
abstract class NewObjectExample {
    open fun getObject(name: String): String = name
}

// primary constructor
abstract class OldObjectExample(val newName: String) {
    open fun getObject(name: String): String = name

    // secondary constructor & constructor overloading
    constructor(newName: String, newAge: Int) : this(newName)
}
fun main() {
    /**
    SO in order for us to use these static methods and variables, instead of us instantiating a class,
    we just use dot notation. Kotlin by default creates an instance for us.
     */
    println(Customer.returnCount()) // 100
    Customer.typeOfCustomer() // American

    println(Person().getName())
    println(Person().returnAge())

    /**
    Below we show what happens in regular classes when you don't use a companion object or declare an object
    by itself. Must create an instance and then call that instance method using dot notation.
     */
    println("Declaring a regular object of the companion object demonstration..")
    Thread.sleep(2000)

    // should be created after init block is created in class.
    val notCompanion by lazy { Person() }
    println(notCompanion.notInTheCompanionObject())

    /**
    Below we show how we can declare an object and override instances of that object in main using
    the object keyword.

    This is called object expression.

    OBJECT EXPRESSIONS are used when you want to modify a class without creating a subclass for it. SO
    below we extend the new object example class and add some modifications to it.
     */
    val newObject = object : NewObjectExample() {
        override fun getObject(name: String): String = name
    }
    println(newObject.getObject("New Object"))

    val oldObject = object : NewObjectExample() {
        override fun getObject(name: String): String = name
    }
    println(oldObject.getObject("Old Object"))
    val currentObject = object : NewObjectExample() {
        override fun getObject(name: String): String {
            return super.getObject(name)
        }
    }

    /**
    We can also use object expression using no classes.

    This basically creates an object in main that holds the same characteristics of an
    object created as a class or companion object.

    The return type of this object would be Any, basically saying this object is an
    ANONYMOUS object.
     */
    val objectExpressionNew = object {
        val firstName by lazy { "Bob" }
        val lastName by lazy { "Marley" }
        override fun toString(): String = "$firstName $lastName"

        fun printObject() = "Object Expression"
    }
    println(objectExpressionNew.toString())
    println(objectExpressionNew.printObject())

    println(Person.TAG) // PERSON

    // passed values by reference - these are the same object and have the same hashcode().
    println(objectExpressionNew.hashCode())
    println(objectExpressionNew.hashCode())
}
