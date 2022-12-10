package advanced.sealedenum

/**
 * So how are sealed classes different than enums?
 *
 * Enums only support constant values while sealed classes can support values
 * that can change in the future. Constants cannot change.
 *
 * Sealed classes are more flexible than enum classes but are still restricted,
 * and cannot be instantiated.
 *
 * Subclasses should be defined in the same file.
 *
 * We can support classes & data classes in sealed classes and declare variables
 * for them that we can use, which we cannot do in enums.
 *
 * We can also declare objects, and nested sealed classes in sealed classes.
 *
 * We also use when statements with sealed classes just like we used enums.
 *
 * Lastly, sealed classes ensure type safety by restricting the set of types
 * at compile time.
 */
sealed class Mathematics {
    class Addition(var firstNumber: Int, var secondNumber: Int) : Mathematics()
    class Subtraction(var firstNumber: Int, var secondNumber: Int) : Mathematics()
    class Division(var firstNumber: Int, var secondNumber: Int) : Mathematics()
    class Multiplication(var firstNumber: Int, var secondNumber: Int) : Mathematics()

//    data class NewMath(var firstNumber: Int, var secondNumber: Int): Mathematics()
//    object Modulus : Mathematics()
//    sealed class Calculus: Mathematics()
//    sealed interface Geometry
}

fun main() {

    val addition = Mathematics.Addition(2,5)
    val subtraction = Mathematics.Subtraction(3,1)
    val division = Mathematics.Division(10,5)
    val multiplication = Mathematics.Multiplication(10,2)

    println("${addition.firstNumber + addition.secondNumber} ")
    println("${subtraction.firstNumber - subtraction.secondNumber} ")
    println("${division.firstNumber / division.secondNumber} ")
    println("${multiplication.firstNumber * multiplication.secondNumber} ")
}