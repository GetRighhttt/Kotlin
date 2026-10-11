package basics

fun main() {
    /**
     * Strings hold text. These methods return new values; they do not change
     * the original string. Indices start at zero.
     */

    val myName = "Stefan"
    println("My name is $myName") // My name is Stefan

    val thisIsAString = "THIS IS THE string that we are going to " +
            "use to demo METHODS."

    // reverses the string
    println(thisIsAString.reversed()) // .SDOHTEM omed ot esu ot gniog era ew taht gnirts EHT SI SIHT

    // count() and length both count UTF-16 code units on the JVM.
    println(thisIsAString.count()) // 60

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

    // filter keeps the uppercase characters; toList makes them easy to inspect.
    val uppercaseCharacters = thisIsAString.filter { it.isUpperCase() }.toList()
    println(uppercaseCharacters) // [T, H, I, S, I, S, T, H, E, M, E, T, H, O, D, S]

    println(
        "This is also how we can reverse a string with interpolation\n${thisIsAString.reversed()}"
    ) // This is also how we can reverse a string with interpolation.
      // SDOHTEM omed ot esu ot gniog era ew taht gnirts EHT SI SIHT

    /**
     * In Kotlin, multiline strings are supported using string concatenation, or using
     * triple quotes.
     */
    println(
        """This is the day the lord has made!
        |Let us rejoice and be glad in it!
        |I thank everybody for coming out today, and
        |I had a blast!
        |This was a joyous occasion. Thanks again!
    """.trimMargin()
    )

    // splitting a string with delimiters and a limit
    val sentence = "Here is the string that we are going to split with delimiters."
    val splitStringExample = sentence.split("", ignoreCase = false, limit = 10)
    println(splitStringExample) // [, H, e, r, e,  , i, s,  , the string that we are going to split with delimiters.]

    // splitting a string using lines() method
    val lineSplitExample = "This is the line\nthat we are going to split\nusing the line method."
    val lines = lineSplitExample.lines()
    lines.forEach(::println)

    // The two-index overload excludes the end index; the range includes its end.
    val newString = "This is a test string"
    println(newString.subSequence(0, 12)) // This is a te
    println(newString.subSequence(0..5)) // This i

    // splitting the string into chunks
    println(splitStringExample.chunked(4)) // [[, H, e, r], [e,  , i, s], [ , the string that we are going to split with delimiters.]]

    // finding the first character in a string that matches the given predicate
    println(newString.find {
        it.isUpperCase()
    }) // T

}
