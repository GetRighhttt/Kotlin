package advanced

fun main(args: Array<String>) {
    /*
    In Kotlin, we have the capability to extend functions when we want to apply
    a built-in function to a variable.

    This is a unique feature that Kotlin has allowed us to use.
     */

    println("Please enter a number:")
    val newNumber = readLine()?.toInt()

    // null check is always necessary for readLine values
    if(newNumber != null) {
        if(newNumber.isPrime())
            println("is a prime number") else println("not prime")
    }

}

/*
This is how we can use an extension function to check and see if a number is Prime
 */
fun Int.isPrime(): Boolean {
    for (i in 2 until this - 1) {
        if(this % i == 0) false
    }
    return true
}