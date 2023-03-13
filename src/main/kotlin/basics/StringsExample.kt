package basics

import java.util.stream.Collectors

fun main(args: Array<String>) {
    /*
    Strings are just a group of character values together.

    Kotlin, being built on top of Java provides us with a ton of built-in
    functions to manipulate strings, which we have to do a ton in programming.
     */

    val myName = "Stefan"
    println("My name is $myName") // prints Stefan

    val thisIsAString = "THIS IS THE string that we are going to " +
            "use to demo METHODS."

    // reverses the string
    println(thisIsAString.reversed())

    // returns the count of all the characters in the string
    println(thisIsAString.chars().count())

    // only keeps the indices of the ranges in the string
    println(thisIsAString.slice(24..40))

    // returns the length of the string
    println(thisIsAString.length)

    // returns a string with first parameter characters removed
    println(thisIsAString.drop(30))

    // returns a string of all lowercase characters
    println(thisIsAString.lowercase())

    // uppercase characters
    println(thisIsAString.uppercase())

    /*
    This is an example of chaining methods:

    convert the string to a list of characters, and
    if the character is uppercase, then we return print it in a list.
     */
    println(thisIsAString.toList()
        .stream().filter
        { a -> a.isUpperCase() } // if the character is uppercase
        .collect(Collectors.toList()))

    println("This is also how we can reverse a string with interpolation" +
            " ${thisIsAString.reversed()}")

    /*
    In Kotlin, multiline strings are supported using string concatenation, or using
    triple quotes.
     */
    println("""This is the day the lord has made!
        |Let us rejoice and be glad in it!
        |I thank everybody for coming out today, and 
        |I had a blast!
        |This was a joyous occasion. Thanks again!
    """.trimMargin())

}