@file:Suppress("KotlinConstantConditions")

package coroutines.flows

import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*

/*
There are a lot of ways to create flows.
Here we will show the majority of those examples.
Flow Builder is the most popular and most used way. When working with Android, we won't usually
have to create our own flows, but this is good to understand flows better.
 */


/*
Flow builder takes a suspend function as a function parameter which allows us to call suspend functions in it.
 */
fun makeFlow(): Flow<Int> = flow {
    repeat(10) {
        delay(400)
        emit(it)
    }
}
    .map { it * 3 }
    .filter { it % 2 == 0 }
    .catch {
        it.printStackTrace()
    } // 0 6 12 18 24

fun fetchUserMessages(): List<String> {
    return listOf("Here we are!", "It's time to party!", "Don't wait up!", "It's going down today!")
}

fun fetchUserNumbers(): MutableList<String> {
    return mutableListOf("1234", "5678")
}

// we can also perform operations on flows as we demonstrate below
fun buildFlow(): Flow<String> = flow {
    var count = 5
    while (count != 0) {
        val userMessages: List<String> = fetchUserMessages()
        delay(500)
        emit(userMessages.joinToString(" "))
        count--
    }
}

fun buildNumberFlow(): Flow<String> = flow {
    var count = 1
    while (count != 5) {
        val userNumbers: List<String> = fetchUserNumbers()
        delay(400)
        emit(userNumbers
            .joinToString(" ") // back to string
            .toList() // converts chars to numbers
            .map { it.code } // converts char to Number
            .filter { it % 2 == 0 } // filters the number by a condition
            .forEach {
                println(it)
            }
            .toString() // sets it back to string
        )
        count++
    }
}

@OptIn(FlowPreview::class)
suspend fun main() {

    /*
    FLOW BUILDER
     */
    makeFlow()
        .collect { println(it) }

    buildFlow()
        .collect { println(it) }

    buildNumberFlow()
        .collect {
            println(it)
        }

    /*
    FLOW RAW VALUES
     */

    // flowOf() - simple and we just define the values.
    flowOf(2, 4, 6, 8)
        .collect { println(it) } // 2468

    // emptyFlow() - flow with no values.
    emptyFlow<Int>().collect { println(it) } // nothing returned

    // asFlow() converts every iterable, iterators, or collections into flows
    val tempList = listOf(1, 2, 3, 4)
        .map { it * 10 }
        .filter { it >= 30 }
        .asFlow()
        .collect() // 30 40

    println(tempList)

    // we can also convert functions to flows
    val newFunction = suspend {
        delay(1000)
        "x"
    }
    newFunction.asFlow()
        .collect { println(it) } // waits a sec, then prints x
}