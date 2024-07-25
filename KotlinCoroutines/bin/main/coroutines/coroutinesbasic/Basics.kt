package coroutines.coroutinesbasic

import kotlinx.coroutines.*
import kotlin.concurrent.thread

/**
 * Coroutines allow us to run thousands of long operations on the background thread.
 *
 * Essentially, they are lightweight threads that run on the background thread which allows
 * us to free up the main thread and not cause any blocks to the main thread.
 *
 * This is crucial as it prevents application not responding errors in Android.
 *
 * DelicateCoroutinesApi means it shouldn't be used unless you're aware of how it works under the hood.
 * Necessary when running global scope because it's not recommended for real projects.
 */

@OptIn(DelicateCoroutinesApi::class)
fun main() { // executes in main thread

    println("Starting on the main thread: ${Thread.currentThread().name}")

    /**
     * Declaring a background thread without coroutines...
     */
    thread {  // executes on background/worker thread

        /**
         * Demonstrating how background threads work.
         *
         * We set the thread to sleep for 2, and then 3 seconds to show separations.
         *
         * Background threads do not block the main thread. They run in parallel.
         *
         * The application waits for the background thread to be finished before it closes
         * the application.
         *
         * sleep() blocks the background thread for a while before it starts
         */
        Thread.sleep(2000)
        println("Starting background thread: ${Thread.currentThread().name}")
        Thread.sleep(3000)
        println("Ending background thread: ${Thread.currentThread().name}")

    }

    /**
     * Coroutines follow the concept of Structured Concurrency, which essentially means that each coroutine
     * should be launched in a defined Coroutine Scope, which delimits the life of that coroutine. It helps to
     * prevent resource and memory leakage. This is why we use GlobalScope to launch this coroutine below.
     *
     * An outer scope cannot complete until all the children have completed.
     *
     * Declaring a Coroutine which operates IN a background thread...
     *
     * launch, async, and runblocking are coroutine builders that essentially just create coroutines.
     * launch = standalone
     * async = deferred
     * runblocking = blocks the main
     *
     * Coroutines have scopes in which they launch their lightweight threads(Structured Concurrency):
     *
     * GlobalScope launches for the whole application lifetime.
     * Lifecycle launches and dies when the activity dies. (Activity/Fragment)
     * ViewModel launches and dies when the view-model is no longer needed.(ViewModels)
     * Coroutine wraps the given context. Allows you to create your own scope.
     *
     * In Android, we have launch, launchWhenStarted, launchWhenResumed, etc. and these allow us to further manage
     * our jobs.
     */
    GlobalScope.launch {

        /**
         * Demonstrating how Coroutines work.
         *
         * By default, coroutines do not wait for the application to finish it's work.
         *
         * delay() doesn't block the thread like sleep does. It suspends if for a while.
         *
         * We use the "suspend" keyword in android to suspend coroutines until long tasks are complete.
         * Suspending functions are only allowed to be called inside a coroutine or from another suspend function.
         */
        delay(2000)

        /**
         * Coroutines have their own context that can be inherited from parent coroutine.
         *
         * Context have two objects, a job, and a dispatcher.
         *
         * When we run a coroutine using Global Scope, it launches on a DefaultDispatcher, which is a thread pool for
         * short-lived coroutines.
         * We can specify a dispatcher, which is usually the best approach, by adding (Dispatchers.IO/Main/etc.) after
         * async or launch.
         * Dispatchers that define the thread of the coroutine.
         *
         * Main = main thread. Usually for UI related tasks.
         * IO = input/output. Usually long-running tasks.
         * Default = default. Used by all standard coroutine builders.
         * Unconfined = not confined to any thread.
         */
        withContext(Dispatchers.IO) {
            println("Starting Coroutine thread: ${Thread.currentThread().name}")
        }
        delay(1000)
        withContext(Dispatchers.IO) {
            println("Ending Coroutine thread: ${Thread.currentThread().name}")
        }
    }

    /**
     * Runblocking creates a coroutine thread that blocks the current main thread and allows the
     * coroutine to finish, but this is not a good approach.
     */
    runBlocking {
        delay(1000)
    }

    println("Ending on the main thread: ${Thread.currentThread().name}")
}