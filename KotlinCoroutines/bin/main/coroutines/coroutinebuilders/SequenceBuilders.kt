package coroutines.coroutinebuilders

/*
Coroutines have sequence builders built into their library. A sequence is similar to a collection except sequences
happen lazily - on demand. We can pair sequences with the yield() method to produce a result it is called or
instantiated. This is the main difference between sequences and collections in coroutines.

In the sequence, we will see that the print method is called first, and after the yield method is called. What's
happening under the hood is that the execution is jumping from the print method, back to the spot where the
last yield method is called to retrieve the other result. This is made possible due to the suspension that happens
automatically in coroutine builders. It's not possible otherwise to stop a function in the middle and jump back to
the place that you left it without suspension in some aspect.

Sequences also should not be used without yielding operations, otherwise, we should probably just use Flows due
to their flexibility.
 */
val sequenceOne = sequence {
    println("Generating first sequence")
    yield("Sequence one built...")
    println("Generating second sequence")
    yield("Sequence two built...")
    println("Generating third sequence")
    yield("Sequence three built...")
}

fun main() {
        for (i in sequenceOne) println(i)
    /*
    Generating first sequence
    Sequence one built...
    Generating second sequence
    Sequence two built...
    Generating third sequence
    Sequence three built...
     */
}