package advancedkotlin.functional

/*
Here we are going to dive into some of the more advanced Kotlin functionalities of functions that we usually don't see.
*/

/*
Local functions - a function within a function that is only visible inside that function.
Local functions have reduced readability
 */
fun properties(length: Double, width: Double): Pair<Double, Double> {
    fun area(): Double = length * width
    fun perimeter(): Double = 2 * (length * width)
    return Pair(area(), perimeter())
}
fun main() {
    println(properties(12.0, 42.0)) // (504.0, 1008.0)

}