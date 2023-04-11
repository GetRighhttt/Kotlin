package advanced.functional

fun main(args: Array<String>) {
    /*
    In Kotlin, we have the capability to extend functions when we want to apply
    a built-in function to a variable, or if we want to extend the functionality of a
    class that is defined as Final.

    This is a unique feature that Kotlin has allowed us to use.
     */

    println("Please enter a number:")
    val newNumber = readLine()?.toInt()

    // null check is always necessary for readLine values
    if (newNumber != null) {
        if (newNumber.isPrime())
            println("is a prime number") else println("not prime")
    }


    println("Please enter a name:")
    val newName = readLine()
    println(newName?.isNice())
    println(newName?.hideName())
    println(newName?.repeatName())
}

/*
This is how we can use an extension function to check and see if a number is Prime.

We do this by prefixing the function with the name of the class that we would like to extend.
 */
fun Int.isPrime(): Boolean {
    for (i in 2 until this - 1) {
        if (this % i == 0) false
    }
    return true
}

/*
Another example of an extension function that extends the String class.
 */
fun String.isNice(): Boolean {
    this.length > 4
    return true
}

fun String.hideName() = "*".repeat(this.length)
fun String.repeatName() = this.repeat(3).toList().forEach (::println)

/*
Please enter a number:
40
is a prime number
Please enter a name:
Stefan
true
******
S
t
e
f
a
n
S
t
e
f
a
n
S
t
e
f
a
n
 */