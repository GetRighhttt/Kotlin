package coroutines

import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

/*
Here we aim to demonstrate how suspension works with Kotlin coroutines.

Usually in Development with Coroutines, we suspend methods when we are making some sort of network call, or
fetching data. This is where suspension plays a key role. Suspension allows us the main thread to continue its work
while the network call is being made, and then after the Coroutine is finished, it returns at the spot it left off
at. It doesn't block the main thread, or take up any additional resources.
It's like when you are doing group work, and you are asked to go create another layer for the project, but the group
still needs to finish their work, so you go about doing your tasks while they are still working, and come back where
you left off to show your finished work, and combine with there's. That's one of they best examples I can give for
suspension.
 */

suspend fun main() {

    println("Starting")

    /*
    suspendCoroutine allows us to suspend the coroutine and call resume to continue the coroutine after its
    suspension. This demonstrates how suspension works.
     */
    suspendCoroutine { continuation ->
        println("This is the first suspension block.")
        continuation.resume(Unit)
    }

    println("Continuing after first suspended Block. Now will suspend again.")

    val printContinuingString = suspendCoroutine<String> { continuation ->
        continuation.resume("This is the second suspension block.")
    }

    println(printContinuingString)
    println("Finishing")
}