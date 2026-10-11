# Function types and function values

A function type describes its inputs and result. A lambda, anonymous function,
or callable reference provides a value of that type.

```kotlin
val add: (Int, Int) -> Int = { a, b -> a + b }
val subtract: (Int, Int) -> Int = fun(a: Int, b: Int): Int { return a - b }
fun greet(name: String): String = "Hello, $name"
val greeting: (String) -> String = ::greet
```

`() -> Unit` takes no arguments and returns Unit. `(Int) -> (Int) -> Int` takes
an Int and returns another function. `Person.() -> String` has a Person receiver.
Calling a function value with parentheses or invoke() executes it.

A closure captures values from the surrounding scope. The function-types example
shows a lambda observing a captured var after it changes.

- [Function types](../../src/main/kotlin/advancedkotlin/functional/FunctionTypes.kt)
- [Lambdas and anonymous functions](../../src/main/kotlin/advancedkotlin/functional/LambdasAndAnonymousFunctions.kt)
- [Kotlin documentation](https://kotlinlang.org/docs/lambdas.html)
