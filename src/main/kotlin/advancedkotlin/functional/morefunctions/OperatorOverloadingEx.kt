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

infix fun Int.exchangeNumberToNewNumber(total: () -> Int): Int = total()
infix fun Int.setNewNumber(newNumber: () -> Int): Int = newNumber()

// using type aliases to declare a shorter name for the class
typealias Oper = OperationValues

// neat operator method to invoke anything and print in
operator fun Any.invoke(): Any = println(this)

// infix operator extension method on string values
infix operator fun Any.invoke(block: () -> Any) = block

fun main() {

    val numOfOperations = Oper(10)

    /*
    Using infix methods with function types to add numbers to operations (just for practice)
     */
    val additionalOperations = 11
    val addedNum = additionalOperations.let { it exchangeNumberToNewNumber { it + 30 } }
    val subtractedOperations = 3
    val subtractedNum = subtractedOperations.let { it exchangeNumberToNewNumber { it - 5 } }
    val dividedNum = 12 setNewNumber  { 30 }
    println(dividedNum) // 30

    /*
    We can now just use the " plus " sign to add together the operations.
     */
    println(numOfOperations + addedNum) // OperationValues(totalNumberOfOperations=51)
    println(numOfOperations - subtractedNum) // OperationValues(totalNumberOfOperations=12)

    // using invoke method we do not have to add an operator and can just add parentheses
    // should be 10 + 11 + 3 -> exchanges to 10
    val newOperations = numOfOperations() + additionalOperations + subtractedOperations.let { it exchangeNumberToNewNumber { 10 } }
    println(newOperations) // OperationValues(totalNumberOfOperations=31)

    // prints invoke method
    ""()
    ""()
    "Now we are going to print some methods to the console using the invoke operator method"()
    true.invoke()
    1()
    "You can also invoke methods with `.invoke()`".invoke()

    // here I'm demoing how we can add infix operators with operator overloading and extension methods
    val name = "Stefan"

    // string produces a block() then also prints the result
    name {
        if(name.isBlank()) "blank name".invoke() else "name is ok".invoke()
    }.invoke()

    /*
    Now we are going to print some methods to the console using the invoke operator method
    true
    1
    You can also invoke methods with `.invoke()`
    name is ok
     */
}