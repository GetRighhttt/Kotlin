package coroutines.flows

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.RuntimeException

/*
Flows are streams of data that can be computed asynchronously.
"A cold, asynchronous stream and is an implementation of the Observable design pattern."
Cold = starts when user subscribes to it, starts anew for each new subscriber.
Hot = continuously emits results.

Observable design pattern has two methods - subscribe() and publish() btw.
With Flows emit() = subscribe() and collect() = publish().
Produces(data sources/repositories) emit data to the flow, that can then be collected(ui layer) by the UI.

Flows are suspending but not concurrent, are cold, and use backpressure: resisting flow of data.
 */

// must be marked as suspend to say it is a coroutine function
suspend fun main() {

    // We can create a flow using a flow builder:
    val numberFlow: Flow<Int> = flow {
        (0..10).forEach {
            println("Sending $it")
            emit(it) // subscribes
            if (it == 11) throw RuntimeException() // throws exception if reaches 10.
        }
    }

    try {
        numberFlow.collect {// publishes
            println("Received: $it")
        }
    } catch (e: InterruptedException) {
        println("${e.message}")
    }
}
