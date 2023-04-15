package advanced.sealedenum

import basics.printThisLine
import java.lang.Exception

/**
 * So how are sealed classes different than enums?
 *
 * Enums only support constant values while sealed classes can support values
 * that can change in the future. Constants cannot change.
 *
 * Sealed classes are more flexible than enum classes but are still restricted,
 * and cannot be instantiated.
 *
 * By default, sealed class constructors are private also.
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
    data class Addition(var firstNumber: Int, var secondNumber: Int) : Mathematics()
    data class Subtraction(var firstNumber: Int, var secondNumber: Int) : Mathematics()
    data class Division(var firstNumber: Int, var secondNumber: Int) : Mathematics()
    data class Multiplication(var firstNumber: Int, var secondNumber: Int) : Mathematics()
    object NotMathematics : Mathematics()
    object Calculus : Mathematics()
// we can also nest sealed classes in sealed classes
//    object Modulus : Mathematics()
//    sealed class Calculus: Mathematics()
//    sealed interface Geometry
}

fun checkMathematics(mathematics: Mathematics) = when (mathematics) {
    is Mathematics.Addition -> println("${mathematics.firstNumber + mathematics.secondNumber} ")
    is Mathematics.Subtraction -> println("${mathematics.firstNumber - mathematics.secondNumber} ")
    is Mathematics.Multiplication -> println("${mathematics.firstNumber * mathematics.secondNumber} ")
    is Mathematics.Division -> println("${mathematics.firstNumber / mathematics.secondNumber} ")
    is Mathematics.Calculus -> println("Calculus ehh? Pretty smart guy.")
    is Mathematics.NotMathematics -> println("Not a mathematical operation...")
}

/*
Below we will show typically how sealed classes are used for state changes.

The class below could be used as a basic state representation for an API call.
 */
sealed class Result {
    data class Success(val successMsg: String = "Success") : Result()
    data class Failure(val errorMsg: String = "Failure") : Result()
    data class Canceled(val canceledMsg: String = "Canceled") : Result()
    object Loading : Result()
}

fun checkResult(result: Result) = when (result) {
    is Result.Success -> println(result.successMsg)
    is Result.Canceled -> println(result.canceledMsg)
    is Result.Failure -> println(result.errorMsg)
    Result.Loading -> Unit
}

/*
we can also use sealed interfaces with sealed classes.
 */
sealed interface Error {
    fun returnErrorMsg(): String
}

sealed class Exceptions {
    sealed class RunTimeError(private val runTimeException: String) : Error {
        override fun returnErrorMsg(): String = "Run time exception: $runTimeException"
    }

    sealed class CompileTimeError(private val compileTimeException: String) : Error {
        override fun returnErrorMsg(): String = "Compile time exception: $compileTimeException"
    }
}

fun showException(e: Error) = when (e) {
    is Exceptions.CompileTimeError -> println(e.returnErrorMsg())
    is Exceptions.RunTimeError -> println(e.returnErrorMsg())
    else -> { Unit }
}

fun main() {

    val addition = Mathematics.Addition(2, 5)
    val subtraction = Mathematics.Subtraction(3, 1)
    val division = Mathematics.Division(10, 5)
    val multiplication = Mathematics.Multiplication(10, 2)
    val calculus = Mathematics.Calculus
    val notMath = Mathematics.NotMathematics

    checkMathematics(addition)
    checkMathematics(subtraction)
    checkMathematics(division)
    checkMathematics(multiplication)
    checkMathematics(calculus)
    checkMathematics(notMath)

    val successResult = Result.Success()
    checkResult(successResult)
}
