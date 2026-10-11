package basics

/**
 * readlnOrNull() reads a line as String?, returning null when input has ended.
 * toIntOrNull() returns null when the text is not a valid Int.
 *
 * Java's Scanner is another option. This example uses one reader for both lines
 * so separate readers do not compete for buffered input from System.in.
 */
fun main() {
    println("Enter some text you want reversed:")
    val userInput = readlnOrNull()
    if (userInput == null) {
        println("Input ended.")
        return
    }
    println(userInput.reversed())

    println("Enter a number:")
    val numberInput = readlnOrNull()
    if (numberInput == null) {
        println("Input ended.")
        return
    }

    val number = numberInput.toIntOrNull()
    if (number == null) {
        println("Please enter a whole number within the Int range.")
        return
    }

    // Convert to Long before subtraction to keep Int.MIN_VALUE from overflowing.
    println("This is the number minus 10: ${number.toLong() - 10}")
}

/*
Sample session (the input lines are typed by the user):
Enter some text you want reversed:
this is a string
gnirts a si siht
Enter a number:
32
This is the number minus 10: 22
*/
