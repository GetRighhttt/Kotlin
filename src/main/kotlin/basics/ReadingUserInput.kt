package basics

import java.util.*

fun main() {
    /*
    We can read user input in the string in a few ways:

    readLine() always returns a string, and we must make sure
    it's not null with a ?.

    Scanner class in java reads in any input
     */
    println("Enter some text you want reversed:")
    val userInput = readlnOrNull()
    println(userInput?.reversed())

    val scanner = Scanner(System.`in`)
    println("Enter a number: ")
    val num = scanner.nextInt()
    println("This is the number minus 10: ${num - 10}")

    /**
     *
     * Output:
     *
     * Enter some text you want reversed:
    Multiversus is a great game
    emag taerg a si susrevitluM
    Enter a number:
    304
    This is the number minus 10: 294
     */
}