package oop

/** object declares a singleton. A companion object is associated with a class. */
object Customer {
    private val count = 205
    init { println("Customer object has been created.") }
    fun returnCount(): Int = count
    fun typeOfCustomer() { println("American") }
}

open class Person {
    init { println("Person instance created.") } // Runs for each new instance.
    fun notInTheCompanionObject() { println("An instance method.") }
    fun getName(): String = newName
    fun returnAge(): Int = age

    companion object {
        const val TAG = "PERSON"
        private val newName = "Bob"
        private val age = 30
        init { println("Person companion initialized.") } // Class initialization, not each instance.
        fun sharedDescription(): String = "$newName: $age"
    }
}

abstract class NewObjectExample {
    open fun getObject(name: String): String = name
}

abstract class OldObjectExample(val newName: String) {
    var newAge: Int = 0
        private set
    // A secondary constructor delegates to the primary constructor.
    constructor(newName: String, newAge: Int) : this(newName) { this.newAge = newAge }
}

fun main() {
    println(Customer.returnCount()) // 205
    Customer.typeOfCustomer() // American
    println(Customer === Customer) // true: same singleton instance

    println(Person.sharedDescription()) // Bob: 30; no Person instance needed.
    val person = Person()
    println(person.getName()) // Bob; this accessor is an instance method.
    println(person.returnAge()) // 30
    person.notInTheCompanionObject()
    println(Person.TAG) // PERSON

    // An object expression creates an anonymous subclass.
    val newObject = object : NewObjectExample() {
        override fun getObject(name: String): String = name.uppercase()
    }
    println(newObject.getObject("New Object")) // NEW OBJECT
    val oldObject = object : OldObjectExample("Old Object", 30) {}
    println("${oldObject.newName}: ${oldObject.newAge}") // Old Object: 30

    // A local anonymous object's members remain accessible through its inferred type.
    val objectExpressionNew = object {
        val firstName = "Bob"
        val lastName = "Marley"
        override fun toString(): String = "$firstName $lastName"
        fun printObject(): String = "Object Expression"
    }
    println(objectExpressionNew) // Bob Marley
    println(objectExpressionNew.printObject()) // Object Expression
    val sameObject = objectExpressionNew
    println(sameObject === objectExpressionNew) // true: reference identity
}
