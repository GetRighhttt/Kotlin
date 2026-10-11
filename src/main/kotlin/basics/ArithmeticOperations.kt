package basics

import kotlin.math.absoluteValue
import kotlin.math.pow

fun main() {

    val a = 30
    val b = 70

    // addition: 30 + 70 = 100
    val addition = a + b
    println(addition)

    // subtraction: 30 - 70 = -40
    val subtraction = a - b
    println(subtraction)

    // multiplication: 30 * 70 = 2100
    val multiplication = a * b
    println(multiplication)

    // Integer division drops the fractional part: 30 / 70 = 0.
    val division = a / b
    println(division)

    // Remainder: 70 = 2 * 30 + 10. Use % for the remainder.
    val modulus = b % a
    println(modulus)

    println("The addition equation is : $a + $b")
    println("The addition result is: ${a + b}")

    val age = 30f // float
    val newAge = 40.0 // Double has more precision than Float; both have rounding limits.
    println(age)

    // pow used to raise a number to a value
    println(newAge.pow(2))

    // convert to Integer, and there's more conversions like this
    println(age.toInt())

    // compareTo returns a negative number, zero, or a positive number
    // for less than, equal to, or greater than, respectively.
    println(age.compareTo(newAge))

    // dec() returns a value one smaller; this call does not change age.
    println(age.dec())

    // Absolute value is the distance from zero (zero remains zero).
    println(age.absoluteValue)

    // adds age to the newAge
    println(newAge.plus(age))

    // converts to string
    println(age.toString())

    /**
     * Total Output:
     * 100
     * -40
     * 2100
     * 0
     * 10
     * The addition equation is : 30 + 70
     * The addition result is: 100
     * 30.0
     * 1600.0
     * 30
     * -1
     * 29.0
     * 30.0
     * 70.0
     * 30.0
     */

}
