package advancedkotlin.functional.morefunctions

/** A local function is visible inside its enclosing function and can capture its values. */
fun properties(length: Double, width: Double): Triple<Double, Double, Double> {
    require(length.isFinite() && width.isFinite() && length >= 0 && width >= 0) {
        "Dimensions must be finite and non-negative."
    }
    fun area(): Double = length * width
    fun perimeter(): Double = 2 * (length + width)
    fun perimeterDoubled(): Double = 2 * perimeter()
    return Triple(area(), perimeter(), perimeterDoubled())
}

fun main() {
    val (area, perimeter, doubledPerimeter) = properties(12.0, 42.0)
    println("Area: $area") // 504.0
    println("Perimeter: $perimeter") // 108.0
    println("Doubled perimeter: $doubledPerimeter") // 216.0
}
