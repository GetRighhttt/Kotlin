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
    init { // called first in output
        println(a)
        println("Delegate Base class has been extended...")
    }

    override val message: String
        get() = """
            Here is the message from the base class before delegation, and
            this is going to be called from the returnDelegateBase method.
        """.trimIndent() // called last

    override fun returnDelegateBase() {
        println(message)
    }
}

class DerivedDelegate(base: DelegationExample) : DelegationExample by base {
    init { // called second in output
        println("Beginning Delegation from Derived Delegate class...")
    }

    /*
    When we call the message in main, this will display as a delegation of the message that we created
    in the class above. We delegated the responsibility of providing a message to this class.
     */
    override val message: String
        get() = "Here is the message from the Derived Delegate class proving that Delegation has been achieved."
}

fun main() {
    val delegationObject = DelegateBase("Starting...")
    val delegationResult = DerivedDelegate(delegationObject)
    println(delegationResult.message) // delegation
    println(delegationResult.returnDelegateBase()) // base class
}

/*
In the output. we see that each init block is called first in order.
Then, when we call the message, we see that the Derived Delegate message is the one being printed because
we DELEGATED the message to that class.

Starting...
Delegate Base class has been extended...
Beginning Delegation from Derived Delegate class...
Here is the message from the Derived Delegate class proving that Delegation has been achieved.
Here is the message from the base class before delegation, and
this is going to be called from the returnDelegateBase method.
 */