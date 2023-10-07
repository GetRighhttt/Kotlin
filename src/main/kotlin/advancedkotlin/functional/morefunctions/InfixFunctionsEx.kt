package advancedkotlin.functional.morefunctions

import javax.naming.Context
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/*
Infix - allows for functions to be called without brackets or periods; this aids in readability and allows for ease
of use.
Infix functions must be defined inside a class or an extension function to an existing class.
You don't generally see infix functions used in a lot of android projects but it is a cool feature to know.
 */

// declaring extension functions
infix fun String.newName(name: String): String = name
infix fun Int.multipliedByThree(age: () -> Int): Int = age() // function type that returns an Int
infix fun String.setMiddleName(name: String): String = newName(name)
infix fun Int.setNumberOfChildren(children: () -> Int): Int = children()

fun main() {
    // created a variable with no initial name
    val tempName = ""

    // example of using infix function to assign name and age times three
    val actualName = tempName newName "Stefan"

    val theirAge = 12 multipliedByThree {
        36
    }

    println("$actualName is my name and my age times three is $theirAge.")

    // using let with also scope functions to assign middle name
    actualName.let {
        it setMiddleName "John"
    }.also {
        println("My middle name is $it.")
    }

    // using let scope function to multiply it once again by 3
    theirAge.let {
        it multipliedByThree {
            it * 3
        }
    }.also {
        println("If I multiply my age again by 3, it is $it.")
    }

    val childrenNum = 1
    childrenNum.let {
        it setNumberOfChildren {
            it + 2
        } compareInts {num ->
            num + 10
        }
    }.also {
        println("I have $it kids.")
    } testFunction {
        val increment = it.inc().times(2)
        println("This incremented value by 1 times 2 is: $increment") // 8
    }
}

/*
We can also have inline infix functions like the one below which is actually the same type of function in the
standard library for the "let" scope function.
 */
@OptIn(ExperimentalContracts::class)
inline infix fun <T,R> T.testFunction(param: (T) -> R): R {
    contract {
        callsInPlace(param, InvocationKind.EXACTLY_ONCE)
    }
    return param(this)
}

@OptIn(ExperimentalContracts::class)
inline infix fun <T: Comparable<T>, R> T.compareInts(other: (T) -> R): R {
    contract {
        callsInPlace(other, InvocationKind.EXACTLY_ONCE)
    }
   return other(this)
}

/*
Stefan is my name and my age times three is 36.
My middle name is John.
If I multiply my age again by 3, it is 108.
I have 3 kids.
 */