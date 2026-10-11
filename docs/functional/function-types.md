What are function types?

Kotlin's functions are first-class, which means they can be stored in variables and data structures. This is one
of the most significant features Kotlin has to offer in my opinion, because when used correctly, it can aid
tremendously in abstraction.

Kotlin is statically typed, meaning that every variable must have a type upon compile time.
For this reason, it makes sense that functions also have types, since they are first-class, and are essentially used
like variables in a lot of Kotlin's features. Function types are used for declarations that deal with functions:
(Int) -> String ... val showMessage: (String) -> String = ...

These "types" are known as function types. "Function Type" is really just "syntactic sugar" that refers to an interface
that cannot be used explicitly. We can use function types like interfaces by implementing them or by using them as type
arguments. Here are a few examples:

(InputType) -> Return Type
" () -> Unit " - function type that returns nothing useful and has no arguments.
" (String) -> String " - type that returns String and takes in a String argument.
" () -> () -> Unit "  - type that returns another function that returns nothing useful. Both have no arguments.

// Implementing with a class
class functionTypeClassEx: () -> Unit { // example }

// declared as a type argument
val doWork: () -> Unit
val moreWork: (String) -> String
val tooMuchWork: (Int) -> (Int) -> Int

"Function Literal" is a special notation used to simplify how a function is defined. There are two types in Kotlin:
Lambdas, and anonymous functions. Literals in most programming languages are used to represent a value, and these
function literals represent function types. Here are some examples:

Lambda
{ a,b -> a + b }

Anonymous function
fun(a: Int, b: Int): Int { return a + b }

Closures are the entire scope of variables accessible in the body of a function. Most people just think of closures
as a function body but really it's more so about the variables rather than the actual logic.

fun showClosure(
a: Int,
b: Int,
c: (Int) -> Int // function type
): Int {
return c(a,b) // closure
}

showClosure (
a = 10,
b = 20,
c = { a,b -> a + b } // lambda
)

In closing just remember this if it is still confusing for you ->

FUNCTION TYPES are DECLARATIONS
FUNCTION LITERALS(lambdas and anonymous functions) are DEFINITIONS