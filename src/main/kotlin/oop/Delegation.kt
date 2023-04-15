package oop

import basics.printNumber

/*
Delegation is the concept of extending responsibility of a class to another class or an object.

Below we use an interface as an abstract base, and then create an open class overriding the method
we created, then demonstrate how delegation works in Kotlin by using the "by" keyword to delegate the method to
print another message.
 */
interface DelegationExample {
    fun returnDelegateBase()
    val message: String
}

open class DelegateBase(var a: String) : DelegationExample {
    init {
        println("Delegate base class has been extended..") // called first
    }

    override val message: String = "Here is the abstract delegate message" // called third
    override fun returnDelegateBase() {
        println("Delegate Base")
    }
}

class DerivedDelegate(base: DelegationExample) : DelegationExample by base {
    init {
        println("Beginning Delegation..") // called second
    }
    override fun returnDelegateBase() {
        println("Delegation has been achieved...") // called last, and shows delegation
    }
}

fun main() {
    val delegationObject = DelegateBase("Starting...")
    val delegationResult = DerivedDelegate(delegationObject)
    println(delegationResult.message)
    println(delegationResult.returnDelegateBase()) // here is where we show the delegation for the return method.
}

/*
Delegate base class has been extended..
Beginning Delegation..
Here is the abstract delegate message
Delegation has been achieved...
 */