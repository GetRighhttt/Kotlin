package advanced.scopefunctions

import advanced.functional.isPrime

class Being {
    var name: String = "Stefan"
    var age: Int = 27
}

// another example of the "also" scope function that adds functionality to methods and objects
fun addCounterTogether(counter: Int): Int = (counter + counter).also { println(it) }


fun main() {

    val thisPerson = Being()


    /**
     * With allows us to pass in an object and use its values. Good for when we have multiple properties and
     * methods for one class.
     *
     * Or if we need to change some data within the class. It returns the lambda result.
     * And operate on a non-null object.
     */
    val agePlusTwo: Int = with(thisPerson) {
        println(this.name)
        println(this.age)
        age + 2
    }
    println(agePlusTwo)

    val ageMinusTen: Double = with(thisPerson) {
        age - 10.0
    }
    println(ageMinusTen)

    val addLastName: String = with(thisPerson) {
        "$name Bayne"
    }
    println(addLastName)

    /**
     * Apply allows us to apply a context of an object to other properties. We normally see this
     * used a lot in android with binding:
     * binding.apply { }
     *
     * Good if you want to initialize or configure an object.
     */
    val applyPerson = Being()
    applyPerson.apply {
        this.name = "John"
    }
    println(applyPerson.name)

    applyPerson.apply {
        val newAge: Int = with(applyPerson) {
            age + 3
        }
        val newerAge = newAge + 10
        println(newerAge)
    }

    /**
     * Also is usually used to perform an extra method on an object after it has been initialized.
     *
     * Good for additional object configuration.
     *
     * Also is very useful when we want to add a method to another method as well.
     */
    val alsoPerson = Being()
    alsoPerson.also {
        println(it.age + 10)
        it.name = "Bob"
        println(it.name)
    }.also {
        it.name = "Stefan"
        println(it.name)
    }

    // using the method we created above main()
    addCounterTogether(3)

    /**
     * The let function has a lot of use cases, but we usually use it to avoid null pointers.
     *
     * Good if you want to execute on a nullable object and avoid null pointer exception.
     */
    val letName: String? = "Henry"

    // must use safe call operator (?.) with let function - execute if not null
    letName?.let {
        println(it.reversed())
        println(it.length)
        it.length
        it.reversed()
    }.run {
        this?.length?.isPrime()
    }

    /**
     * Run is actually a combo of the with and let methods.
     * We use this when we need to pass in an object and use its values and execute on a nullable object.
     */
    Being().run {
        age + 2
        name = "Bayne"
        println(this.name)
        println(this.age)
    }

    Being().run {
        println(this.name.reversed())
        println(this.name.repeat(4))
        val nameSplit = this.name.split("")
        println(nameSplit) // [, S, t, e, f, a, n, ]
    }
}