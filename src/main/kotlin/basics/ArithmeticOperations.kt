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

    // division: 30/70 = 0
    val division = a / b
    println(division)

    // modulus(remainder): 70/30 = 68 remainder 2; so 2
    val modulus = b / a
    println(modulus)

    println("The addition equation is : $a + $b")
    println("The addition result is: ${a + b}")

    val age = 30f // float
    val newAge = 40.0 // double values are more accurate than float
    println(age)

    // pow used to raise a number to a value
    println(newAge.pow(2))

    // convert to Integer, and there's more conversions like this
    println(age.toInt())

    // compare the numbers, and returns 0 if equal to, more negative than,
    // or greater than
    println(age.compareTo(newAge))

    // decrements the value by one
    println(age.dec())

    // returns the positive value of a number
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
     * 2
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