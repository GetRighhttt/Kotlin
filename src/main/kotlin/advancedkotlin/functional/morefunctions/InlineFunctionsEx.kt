package advancedkotlin.functional.morefunctions

/*
Inline functions - provide a way to decrease performance overhead and memory allocation when using Function Types
in Kotlin. In Kotlin, each function, because they are first-class and treated like variables, are executed as individual
objects in memory, thus increasing performance overhead and memory allocation during compilation.
"Inline" keyword is used as a means to reduce this.

An INLINE FUNCTION will pass the action(s) as part of the execution call stack, therefore reducing overhead and memory.
All the code will act as single lines of code in the code block instead of an object.

All lambdas will be passed as inline as well if declared within the closure of a function, however if you do not want this
to occur, you can mark them with the NOINLINE keyword.
 */

/*
We are going to declare a method that takes in two function type arguments and call them in main.
There really isn't a syntactic difference apart from using the "inline" keyword in front of the function

inline functions also cannot be declared in fun main() {}. This isn't yet supported by Kotlin - 10/04/2023

Mainly used with lambdas.
 */
inline fun runTime(
    message: () -> Unit,
    time: () -> Long
) {
    message()
    println("They ran in ${time()} seconds.")
}

inline fun multiplyTime(time: () -> Long) = time() * 2
fun main() {

    // calling inline method
    runTime(
        // first function type used as the function literal "lambda"
        message = {
            println("This is how fast he ran the lap")
        },
        // second function type used as the function literal "lambda", and multiples it
        time = {
            {
                2000L
            }.let {
                multiplyTime(it)
            }
        }
    )
}

/*
This is how fast he ran the lap
They ran in 4000 seconds.
 */