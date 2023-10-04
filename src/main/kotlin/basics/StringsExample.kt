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
    println(thisIsAString.reversed()) // .SDOHTEM omed ot esu ot gniog era ew taht gnirts EHT SI SIHT

    // returns the count of all the characters in the string
    println(thisIsAString.chars().count()) // 60

    // only keeps the indices of the ranges in the string
    println(thisIsAString.slice(24..40)) // we are going to u

    // returns the length of the string
    println(thisIsAString.length) // 60

    // returns a string with first parameter characters removed
    println(thisIsAString.drop(12)) // string that we are going to use to demo METHODS.

    // returns a string of all lowercase characters
    println(thisIsAString.lowercase()) // this is the string that we are going to use to demo methods.

    // uppercase characters
    println(thisIsAString.uppercase()) // THIS IS THE STRING THAT WE ARE GOING TO USE TO DEMO METHODS.

    /*
    This is an example of chaining methods:

    convert the string to a list of characters, and
    if the character is uppercase, then we return print it in a list.
     */
    println(thisIsAString.toList()
        .stream().filter
        { a -> a.isUpperCase() } // if the character is uppercase
        .collect(Collectors.toList()))

    println(
        "This is also how we can reverse a string with interpolation\n" +
                "${thisIsAString.reversed()}"
    ) // This is also how we can reverse a string with interpolation.
      // SDOHTEM omed ot esu ot gniog era ew taht gnirts EHT SI SIHT

    /*
    In Kotlin, multiline strings are supported using string concatenation, or using
    triple quotes.
     */
    println(
        """This is the day the lord has made!
        |Let us rejoice and be glad in it!
        |I thank everybody for coming out today, and 
        |I had a blast!
        |This was a joyous occasion. Thanks again!
    """.trimMargin()
    )
    /*
    This is the day the lord has made!
    Let us rejoice and be glad in it!
    I thank everybody for coming out today, and
    I had a blast!
    This was a joyous occasion. Thanks again!
     */

    // splitting a string with delimiters and a limit
    val splitStringExample = "Here is the string that we are going to split with delimiters.".split("", ignoreCase = false, limit = 10)
    println(splitStringExample) // [, H, e, r, e,  , i, s,  , the string that we are going to split with delimiters.]

    // splitting a string using lines() method
    val lineSplitExample: String = "This is the line\nthat we are going to split\nusing the line method."
    val lines = lineSplitExample.lines()
    lines.forEach(::println)
    /*
    This is the line
    that we are going to split
    using the line method.
     */

    // returning a sequence of chars of a string given the range or start and end indexes
    val newString: String = "This is a test string"
    println(newString.subSequence(0, 12)) // This is a te
    println(newString.subSequence(0..5)) // This i

    // splitting the string into chunks
    println(splitStringExample.chunked(4)) // [[, H, e, r], [e,  , i, s], [ , the string that we are going to split with delimiters.]]

    // finding the first character in a string that matches the given predicate
    println(newString.find {
        it.isUpperCase()
    }) // T
}