# Kotlin basics

Start with the topic you need. Each file has a main() function and comments showing
what to expect. The examples still use the names and sample data from my earlier
practice; the explanations are being reviewed as I revisit them.

- [Hello world](../src/main/kotlin/basics/HelloWorld.kt): entry points and printing.
- [Variables and types](../src/main/kotlin/basics/VariableTypesKotlin.kt): val, var,
  const val, numeric types, and Unicode escapes.
- [Arithmetic](../src/main/kotlin/basics/ArithmeticOperations.kt): integer division,
  remainder, conversions, and numeric methods.
- [Strings](../src/main/kotlin/basics/StringsExample.kt): interpolation, slicing,
  case conversion, multiline text, and splitting.
- [Comparisons](../src/main/kotlin/basics/IfLogicalComparisonEtc.kt): Boolean values,
  logical operators, and if expressions.
- [Control flow](../src/main/kotlin/basics/UnderstandingControl.kt): ranges, loops,
  when, and expression bodies.
- [Functions](../src/main/kotlin/basics/Functions.kt): local functions, return values,
  Unit, and function references.
- [Arguments](../src/main/kotlin/basics/VarArgDefaultNames.kt): vararg, the spread
  operator, named arguments, and defaults. getMinNumber requires at least one number.
- [Nulls](../src/main/kotlin/basics/Nulls.kt): nullable types, safe calls, Elvis,
  smart casts, let, assertions, and safe casts.
- [User input](../src/main/kotlin/basics/ReadingUserInput.kt): reading lines,
  parsing numbers, and handling invalid input or end-of-input.

## Running a file

From the repository root, with the Kotlin command-line tools and a JDK installed:

```sh
mkdir -p build
kotlinc src/main/kotlin -d build/examples.jar
kotlin -classpath build/examples.jar basics.FunctionsKt
```

Use the package name plus the filename without .kt, followed by Kt. For example,
ReadingUserInput.kt runs as basics.ReadingUserInputKt. In IntelliJ, use the run
button beside main().

## Details I want to remember

A val cannot be reassigned, but an object referenced by a val can still be mutable.
A function that only performs an action returns Unit. Printing that return value
will print kotlin.Unit, so call printing functions directly.

Integer division drops the fractional part. The % operator gives the remainder.
A safe call handles a null receiver; !! throws when its receiver is null.

## Kotlin documentation

- [Basic syntax](https://kotlinlang.org/docs/basic-syntax.html)
- [Functions](https://kotlinlang.org/docs/functions.html)
- [Null safety](https://kotlinlang.org/docs/null-safety.html)
- [Strings](https://kotlinlang.org/docs/strings.html)
