package coroutines.coroutinebuilders

import kotlinx.coroutines.*

/**
 * Coroutine Builders are nothing ;more than functions that we use to create coroutines.
 * Declaring a Coroutine which operates IN a background thread...
 *
 * launch, async, and runblocking are coroutine builders that essentially just create coroutines.
 *
 * launch and async both run concurrently, however async returns a result.
 *
 * runblocking is the only Coroutine builder that cannot be used in Structured Concurrency. It must be used as
 * a root or parent scope.
 *
 * Jobs are essentially the results of running an asynchronous task.
 * "A cancellable thing with a lifecycle that culminates its completion".
 * Kind of like a disposable, and it represents an actual coroutine.
 * Job can be used to execute a number of methods built in to the coroutines api including canceling coroutines.
 */
fun main() = runBlocking { // creates a blocking coroutine that executes in main

    println("Start of main program: ${Thread.currentThread().name}")

    /**
     * launch = standalone: known for fire and forget; launches then forgets essentially and doesn't block thread in which
    * it operates. Also, returns a job object that we can use to manipulate the coroutines.
     *
     * We will launch this on the IO dispatcher.
     */
    val job: Job = launch(Dispatchers.IO) {
        println("Start of launch worker thread: ${Thread.currentThread().name}")
        delay(1000)
        println("End of launch worker thread: ${Thread.currentThread().name}")
    }
    // join() is used to wait for coroutine to finish executing, then next statement will be executed.
    job.join()

    /**
     * async = deferred; doesn't return a job object but instead returns a deferred object which is a subclass of Job.
     * The return type is of a generic type, so we can pass whatever we want into it.
     *
     * Async function is usually used when we want to return some data. It is pretty much the same as launch
     * except it returns a Deferred<T> object of generic type.
     *
     * We will launch this on the default dispatcher.
     */
    val jobDeferred: Deferred<Int> = async(Dispatchers.Default) {
        println("Start of async worker thread: ${Thread.currentThread().name}")
        delay(1000)
        println("End of async worker thread: ${Thread.currentThread().name}")
        22// returns a deferred object and here we pass that object as an int
    }

    val numberFromAsync = jobDeferred.await() // wait for coroutine to finish and retrieve the value from the coroutine.
    println("The value from the async deferred job is: $numberFromAsync !")


    println("End of main program: ${Thread.currentThread().name}")

}