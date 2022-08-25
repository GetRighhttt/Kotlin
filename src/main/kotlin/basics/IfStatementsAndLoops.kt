package basics

fun main(args: Array<String>) {

    /**
     * This is going to be a basic example of if
     * statements in Kotlin.
     *
     * for loops are for iterating through collections
     *
     * while loops execute while a condition is met
     *
     * do-while loops do some logic while the condition is met. They
     * always run at least one time.
     */
    val y = 10
    val x = 10

    if(x == y) {
        println("This is true.")
    }
    else if(x == 11) {
        println("This is not true.")
    }

    /*
    We can also assign values to if statements as well
     */
    val z = if(x <= y) 3 else 4

    val newAnswer = if (y == 10) println(y) else println(y + 1)

    println(newAnswer)
    println(z)

    // for loop
    var count = 0
    for (i in 0..10) {
        println(count++)
    }

    // while loop
    while (count < x) {
        count++
        println("This is a while loop.")
    }

    // do-while
    do {
        println("This is a do while loop.")
    } while (y > x)

    /*
    When statements are like switch statements except they
    come with more functionality than switch statements.
     */
    when(x) {
        in 1..10 -> println("In between 1 and 10")
        in 10..20 -> println("In between 10 and 20")
        else -> println("Above 20.")
    }

}