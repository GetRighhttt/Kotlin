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
    Declaring operator methods -> plus , minus

    We can also omit the data class extension declaration and just declare the operator also.

    Operator overloading is very useful when calling "invoke" operator.
     */
    operator fun plus(addOperation: Int): OperationValues {
        return OperationValues(this.totalNumberOfOperations + addOperation)
    }

    operator fun minus(subtractOperation: Int): OperationValues {
        return OperationValues(this.totalNumberOfOperations - subtractOperation)
    }

    operator fun invoke(): OperationValues = OperationValues(this.totalNumberOfOperations)
}

infix fun Int.addThisNumber(total: () -> Int): Int = total()
infix fun Int.setNewNumber(newNumber: () -> Int): Int = newNumber()

// using type aliases to declare a shorter name for the class
typealias Oper = OperationValues

fun main() {

    val numOfOperations = Oper(10)

    /*
    Using infix methods with function types to add numbers to operations (just for practice)
     */
    val additionalOperations = 11
    val addedNum = additionalOperations.let { it addThisNumber { it + 30 } }
    val subtractedOperations = 3
    val subtractedNum = subtractedOperations.let { it addThisNumber { it - 5 } }
    val dividedNum = 12 setNewNumber  { 30 }
    println(dividedNum) // 30

    /*
    We can now just use the " plus " sign to add together the operations.
     */
    println(numOfOperations + addedNum) // OperationValues(totalNumberOfOperations=51)
    println(numOfOperations - subtractedNum) // OperationValues(totalNumberOfOperations=12)

    // using invoke method we do not have to add an operator and can just add parentheses
    val newOperations = numOfOperations() + additionalOperations + subtractedOperations.let { it addThisNumber { 10 } }
    println(newOperations) // OperationValues(totalNumberOfOperations=31)
}