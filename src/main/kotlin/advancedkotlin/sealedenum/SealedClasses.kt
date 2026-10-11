package advancedkotlin.sealedenum

/**
 * A sealed hierarchy restricts direct subclasses to the same package and module.
 * Its default constructor visibility is protected; private constructors are also allowed.
 * Subclasses can carry data. An exhaustive when can cover every direct case.
 */
sealed class Mathematics {
    data class Addition(val firstNumber: Int, val secondNumber: Int) : Mathematics()
    data class Subtraction(val firstNumber: Int, val secondNumber: Int) : Mathematics()
    data class Division(val firstNumber: Int, val secondNumber: Int) : Mathematics()
    data class Multiplication(val firstNumber: Int, val secondNumber: Int) : Mathematics()
    object NotMathematics : Mathematics()
    object Calculus : Mathematics()
}
fun checkMathematics(mathematics: Mathematics) {
    val message = when (mathematics) {
        is Mathematics.Addition -> (mathematics.firstNumber + mathematics.secondNumber).toString()
        is Mathematics.Subtraction -> (mathematics.firstNumber - mathematics.secondNumber).toString()
        is Mathematics.Multiplication -> (mathematics.firstNumber * mathematics.secondNumber).toString()
        is Mathematics.Division -> {
            require(mathematics.secondNumber != 0) { "Cannot divide by zero." }
            (mathematics.firstNumber / mathematics.secondNumber).toString()
        }
        Mathematics.Calculus -> "Calculus ehh? Pretty smart guy."
        Mathematics.NotMathematics -> "Not a mathematical operation..."
    }
    println(message)
}

sealed class Result {
    data class Success(val successMsg: String = "Success") : Result()
    data class Failure(val errorMsg: String = "Failure") : Result()
    data class Canceled(val canceledMsg: String = "Canceled") : Result()
    object Loading : Result()
}
fun checkResult(result: Result) {
    println(when (result) {
        is Result.Success -> result.successMsg
        is Result.Failure -> result.errorMsg
        is Result.Canceled -> result.canceledMsg
        Result.Loading -> "Loading"
    })
}

// Authorization success is not an error, so name the whole hierarchy HttpStatus.
sealed interface HttpStatus {
    object Authorized : HttpStatus
    object Unauthorized : HttpStatus
    object NotFound : HttpStatus
    object Forbidden : HttpStatus
}
fun getHttpStatus(status: HttpStatus) {
    println(when (status) {
        HttpStatus.Authorized -> "Authorized"
        HttpStatus.Unauthorized -> "Unauthorized"
        HttpStatus.NotFound -> "NotFound"
        HttpStatus.Forbidden -> "Forbidden"
    })
}

sealed interface Error { fun returnErrorMsg(): String }
// An object groups these declarations; Error is the hierarchy they actually implement.
object Exceptions {
    data class RunTimeError(val description: String) : Error {
        override fun returnErrorMsg(): String = "Run time exception: $description"
    }
    data class CompileTimeError(val description: String) : Error {
        override fun returnErrorMsg(): String = "Compile time exception: $description"
    }
    object UnknownError : Error {
        override fun returnErrorMsg(): String = "Unknown error"
    }
}
fun showException(error: Error) { println(error.returnErrorMsg()) }
fun String.reverseAMessage(): String = reversed()
fun HttpStatus.printStatusMessage(): String = "HTTP status: ${this::class.simpleName}"

fun main() {
    checkMathematics(Mathematics.Addition(2, 5)) // 7
    checkMathematics(Mathematics.Subtraction(3, 1)) // 2
    checkMathematics(Mathematics.Division(10, 5)) // 2
    checkMathematics(Mathematics.Multiplication(10, 2)) // 20
    checkMathematics(Mathematics.Calculus)
    checkMathematics(Mathematics.NotMathematics)
    checkResult(Result.Success())
    checkResult(Result.Failure())
    checkResult(Result.Canceled())
    checkResult(Result.Loading)
    showException(Exceptions.RunTimeError("#402321"))
    showException(Exceptions.CompileTimeError("#213021"))
    showException(Exceptions.UnknownError)
    getHttpStatus(HttpStatus.Authorized)
    getHttpStatus(HttpStatus.Unauthorized)
    println(HttpStatus.NotFound.printStatusMessage()) // HTTP status: NotFound
    println(Result.Success().successMsg.reverseAMessage()) // sseccuS
}
