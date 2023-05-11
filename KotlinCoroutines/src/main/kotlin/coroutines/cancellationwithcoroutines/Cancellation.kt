package coroutines.cancellationwithcoroutines

import kotlinx.coroutines.*

/**
 * Why cancel a coroutine?
 *
 * Result no longer needed;
 * Taking too long to perform a tasks.
 * Etc.
 */

fun main() = runBlocking {

    println("Start of main program: ${Thread .currentThread().name}")

    /**
     * Coroutine must be cooperative to cancel.
     *
     * Cooperative?
     * Must invoke/use a suspending function that checks for cancellation - delay(), withContext(), etc.
     * in the coroutine.
     *
     * We can also use the boolean isActive flag to check if the cancellation status of the coroutine.
     */
    val job: Job = launch {
        for (i in 0..500) {
            print(" $i ")
            /*
            Yields the current thread or thread pool of the current coroutine dispatcher so other coroutines
            can run.
            Usually ends up speeding functionality.
             */
            yield()
        }
    }

    delay(7)
    job.cancelAndJoin() // cancels the coroutine.

    print("\n")

    val job2: Job = launch(Dispatchers.Default) {
        // try catch block for cancellation exception handling with coroutines.
        try {
            for (i in 0..500) {
                if (!isActive) {
                    break
                } // another way to make coroutine cooperative
                print(" $i ")
            }
        } catch (e: CancellationException) {
            println("Exception caught safely.")
        } finally {
            withContext(NonCancellable) {
                println("job: I'm running finally")
                delay(1000L)
                println("job: And I've just delayed for 1 sec because I'm non-cancellable")
            }
        }
    }

    delay(5)
    job2.cancel("My own crash message.")
    job2.join()

    println("\nEnd of main program: ${Thread.currentThread().name}")

}