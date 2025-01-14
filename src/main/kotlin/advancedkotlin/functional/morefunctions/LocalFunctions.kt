package advancedkotlin.functional.morefunctions
/**
 * Local functions - a function defined within the body of another function.
 *
 * Some downfalls:
 * Local functions have reduced readability when used too much, and also they have limited visibility - cannot be used, or
 * accessed outside the code blocks of the function they are defined in. Local functions also have performance overhead -
 * the performance takes a hit when using local functions, and it takes more allocation of memory. There's also an increase
 * in dex files when building android releases. Code duplication is also an issue, and it increases tightly coupled
 * architectures.
 */

// returns a triple of doubles
fun properties(length: Double, width: Double): Triple<Double, Double, Double> {
    fun area(): Double = length * width
    fun perimeter(): Double = 2 * (length * width)
    fun perimeterDoubled(): Double = 2 * perimeter()
    return Triple(area(), perimeter(), perimeterDoubled())
}


fun main() {

    // using local function
    println("Properties: ${properties(12.0, 42.0)}") // Properties: (504.0, 1008.0, 2016.0))
}