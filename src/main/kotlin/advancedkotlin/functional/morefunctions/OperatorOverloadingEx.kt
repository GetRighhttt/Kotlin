package advancedkotlin.functional.morefunctions


/*
Operator Overloading - capability to add custom functionality to operators in Kotlin.
Not particularly used a ton in Android development, but it's very useful when just using Kotlin or developing
libraries.
 */
data class OperationValues(
    val totalNumberOfOperations: Int
) {
    /*
    Declaring operator methods -> plus , minus , divide

    We can also omit the data class extension declaration and just declare the operator also
     */
    operator fun plus(addOperation: Int): OperationValues {
        return OperationValues(this.totalNumberOfOperations + addOperation)
    }

    operator fun minus(subtractOperation: Int): OperationValues {
        return OperationValues(this.totalNumberOfOperations - subtractOperation)
    }
}

fun main() {

    val numOfOperations = OperationValues(10)
    val additionalOperations = 11
    val subtractedOperations = 3

    /*
    We can now just use the " plus " sign to add together the operations.
     */
    println(numOfOperations + additionalOperations) // OperationValues(totalNumberOfOperations=21)
    println(numOfOperations - subtractedOperations) // OperationValues(totalNumberOfOperations=7)
}