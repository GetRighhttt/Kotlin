package advancedkotlin.scopefunctions

import advancedkotlin.functional.isPrime

class Being {
    var name: String = "Stefan"
    var age: Int = 27
}

fun addCounterTogether(counter: Int): Int = (counter + counter).also { println(it) }

fun main() {
    val thisPerson = Being()
    // with takes the object as an argument, uses this, and returns the lambda result.
    val agePlusTwo = with(thisPerson) { age + 2 }
    println(agePlusTwo) // 29; thisPerson.age is still 27.
    println(with(thisPerson) { "$name Bayne" }) // Stefan Bayne

    // apply uses this and returns the receiver, so it suits object configuration.
    val applyPerson = Being().apply {
        name = "John"
        age += 3
    }
    println("${applyPerson.name}: ${applyPerson.age}") // John: 30

    // also uses it and returns the receiver. Here it adds a logging action.
    val alsoPerson = Being().also { println("Created ${it.name}") }
    println(alsoPerson.name) // Stefan
    addCounterTogether(3) // 6

    // let uses it and returns the final expression. ?. provides the null check.
    val letName: String? = "Henry"
    val nameLength = letName?.let { it.length }
    println(nameLength) // 5
    println("Henry".let { it.reversed() }) // yrneH; let also works on non-null values.

    // run uses this and returns the final expression, not the receiver.
    val runPerson = Being()
    val description = runPerson.run {
        name = "Bayne"
        age += 2
        "$name: $age"
    }
    println(description) // Bayne: 29
    println("Henry".run { length.isPrime() }) // true

    // The non-extension run form groups expressions without a receiver.
    val doubled = run {
        val number = 3
        number * 2
    }
    println(doubled) // 6
}
