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

    /**
     * Apply allows us to apply a context of an object to other properties. We normally see this
     * used a lot in android with binding:
     * binding.apply { }
     *
     * Good if you want to initialize or configure an object.
     */
    thisPerson.apply {
        this.name = "John"
    }
    println(thisPerson.name)

    /**
     * Also is usually used to perform an extra method on an object after it has been initialized.
     *
     * Good for additional object configuration.
     */
    thisPerson.also {
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
    val name: String? = "Henry"

    name?.let {
        println(it.reversed())
        println(it.length)
        it.length
        it.reversed()
    }

    /**
     * Run is actually a combo of the with and let methods.
     * We use this when we need to pass in an object and use its values and execute on a nullable object.
     */
    val person: Person? = null
    person?.run {
        println(this.age)
        age + 2
    }
    println(agePlusTwo)

}