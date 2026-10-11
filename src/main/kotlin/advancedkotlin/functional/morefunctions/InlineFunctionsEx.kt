package advancedkotlin.functional.morefunctions

/**
 * inline lets the compiler insert a function's body and eligible lambda bodies at
 * the call site. It can avoid function-object overhead, but can also increase code size.
 * Ordinary function declarations do not each require a function object.
 */
class Example {
    inline fun getExample(message: () -> Unit) { message() }
}
inline fun runTime(message: () -> Unit, time: () -> Long) {
    message()
    println("They ran in ${time()} seconds.")
}
inline fun multiplyTime(time: () -> Long): Long = time() * 2

// noinline keeps a lambda as a value, so we can store or return it.
inline fun runAndKeep(immediate: () -> Unit, noinline later: () -> Unit): () -> Unit {
    immediate()
    return later
}

fun main() {
    runTime(
        message = { println("This is how fast he ran the lap") },
        time = { multiplyTime { 20L } }
    ) // They ran in 40 seconds.

    Example().getExample { println("Example") } // Returns Unit; do not invoke that result.
    val later = runAndKeep({ println("Run now") }, { println("Run later") })
    later()
}
