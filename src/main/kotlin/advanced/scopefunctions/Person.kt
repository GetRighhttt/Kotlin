package advanced.scopefunctions

class Person {
    var name: String = "Stefan"
    var age: Int = 27
}

fun main() {

    val thisPerson = Person()

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
    val applyPerson = Person()
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
     */
    val alsoPerson = Person()
    alsoPerson.also {
        println(it.age + 10)
        it.name = "Bob"
        println(it.name)
    }.also {
        it.name = "Stefan"
        println(it.name)
    }

    /**
     * The let function has a lot of use cases, but we usually use it to avoid null pointers.
     *
     * Good if you want to execute on a nullable object and avoid null pointer exception.
     */
    val letName: String? = "Henry"

    letName?.let {
        println(it.reversed())
        println(it.length)
        it.length
        it.reversed()
    }

    /**
     * Run is actually a combo of the with and let methods.
     * We use this when we need to pass in an object and use its values and execute on a nullable object.
     */
    Person().run {
        age + 2
        name = "Bayne"
        println(this.name)
        println(this.age)
    }
}