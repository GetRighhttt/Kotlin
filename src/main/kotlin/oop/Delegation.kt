package oop

/** by forwards interface members to another object unless we override them. */
interface DelegationExample {
    fun returnDelegateBase()
    val message: String
}

class DelegateBase(val label: String) : DelegationExample {
    override val message: String = "Here is the message from the base class."
    override fun returnDelegateBase() { println("$label: $message") }
}

class DerivedDelegate(base: DelegationExample) : DelegationExample by base {
    // This member is overridden locally, rather than forwarded to base.
    override val message: String = "Here is the message from the Derived Delegate class."
}

fun main() {
    val delegationObject = DelegateBase("Starting")
    val delegationResult = DerivedDelegate(delegationObject)
    println(delegationResult.message) // The override in DerivedDelegate.
    delegationResult.returnDelegateBase() // Forwarded to DelegateBase.
    // The delegate's implementation reads its own message, not the wrapper's override.
    println(delegationResult.message.uppercase()) // String conversion returns a new value.
}
