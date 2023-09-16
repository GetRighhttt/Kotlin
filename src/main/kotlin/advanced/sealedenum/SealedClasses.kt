package advanced.sealedenum

/**
 * So how are sealed classes different from enums?
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

We also use named parameters for the sake of an example.
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
we can also use sealed interfaces when we need a simpler restricted set of objects, methods, etc.

In this example, we are declaring a method in the interface, so we would have to override any object in the
interface with this method.
 */
sealed interface Error {
    fun returnErrorMsg(): String
}

/*
Below is an example without a method and just shows a group of singleton objects that extend the
sealed interface.
 */
sealed interface HttpError {
    object Authorized : HttpError
    object UnAuthorized : HttpError
    object NotFound : HttpError
    object Forbidden : HttpError

}

fun getHttpError(error: HttpError) = when (error) {
    HttpError.Authorized -> println("Authorized")
    HttpError.Forbidden -> println("Forbidden")
    HttpError.NotFound -> println("NotFound")
    HttpError.UnAuthorized -> println("UnAuthorized")
}

sealed class Exceptions {
    open class RunTimeError(private val runTimeException: String) : Error {
        override fun returnErrorMsg(): String = "Run time exception: $runTimeException"
        override fun toString(): String = runTimeException
    }

    open class CompileTimeError(private val compileTimeException: String) : Error {
        override fun returnErrorMsg(): String = "Compile time exception: $compileTimeException"
        override fun toString(): String = compileTimeException
    }

    object UnknownError : Error {
        override fun returnErrorMsg(): String = "Unknown error"
        override fun toString(): String = "******"
    }
}

fun showException(e: Error) = when (e) {
    is Exceptions.CompileTimeError -> println(e.returnErrorMsg())
    is Exceptions.RunTimeError -> println(e.returnErrorMsg())
    is Exceptions.UnknownError -> println(e.returnErrorMsg())
}

/*
We can also use extension functions with interfaces, classes, or objects that we create. This is one
of the best language features that Kotlin has to offer. They extend the functionality of an object.

Because we created an extension method below with type "Any", any object has the ability to use
this method.
 */
fun Any.reverseAMessage(message: String): String = message.reversed()
fun HttpError.printErrorMessage(e: HttpError): String = "An HttpError: $e has occurred...."

fun Error.printUnknownMessage(e: String): String =
    "Unknown $e...  Consider consulting Kotlin documentation..."

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

    /*
    7
    2
    2
    20
    Calculus ehh? Pretty smart guy.
    Not a mathematical operation...
     */

    // Result example with sealed class
    val successResult = Result.Success()
    checkResult(successResult)

    val failureResult = Result.Failure()
    checkResult(failureResult)

    /*
    Success
    Failure
     */

    /*
    Below we will show how we can get the same result by calling the override method,
    and by calling the method we created using a when statement for Exceptions.
     */

    val runTimeExceptions = Exceptions.RunTimeError("#402321")
    showException(runTimeExceptions) // method
    println(runTimeExceptions.returnErrorMsg()) // override

    val compileTimeException = Exceptions.CompileTimeError("#213021")
    showException(compileTimeException) // method
    println(compileTimeException.returnErrorMsg()) // override

    /*
    Output is the same:
    Run time exception: #402321
    Run time exception: #402321
    Compile time exception: #213021
    Compile time exception: #213021
     */

    /*
    Below we show how we can call values of a sealed interface and display them to the screen
    in the same way we do for sealed classes.

    Here we are using lazy delegation just for performance. Lazy delegation only initializes when the method is called
     */
    val sealedAuthorized by lazy {
        HttpError.Authorized
    }
    getHttpError(sealedAuthorized)

    val sealedUnAuthorized by lazy {
        HttpError.UnAuthorized
    }
    getHttpError(sealedUnAuthorized)
    /*
   Authorized
   UnAuthorized
    */

    /*
   Below we use the extension function we created that prints the unknown error message for the object
    */
    println("----------------------------------------------------------------")
    println("Printing messages using extension functions.")
    println("----------------------------------------------------------------")
    val unknownError = Exceptions.UnknownError
    println(unknownError.printUnknownMessage(unknownError.toString()))
    println(runTimeExceptions.printUnknownMessage(runTimeExceptions.toString()))
    println(compileTimeException.printUnknownMessage(compileTimeException.toString()))

    // using extension function
    println(sealedUnAuthorized.printErrorMessage(sealedUnAuthorized))
    println(HttpError.NotFound.printErrorMessage(HttpError.NotFound))

    /*
    Using extension method with any type to reverse messages from various classes
     */
    val canceledResult = Result.Canceled()
    println(successResult.reverseAMessage(successResult.successMsg))
    println(failureResult.reverseAMessage(failureResult.errorMsg))
    println(canceledResult.reverseAMessage(canceledResult.canceledMsg))
    println(compileTimeException.reverseAMessage(compileTimeException.returnErrorMsg()))
    println(runTimeExceptions.reverseAMessage(runTimeExceptions.returnErrorMsg()))
    /*
    sseccuS
    eruliaF
    delecnaC
    120312# :noitpecxe emit elipmoC
    123204# :noitpecxe emit nuR
     */
}
