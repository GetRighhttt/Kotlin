# Functional programming notes

Kotlin lets me pass behavior as a value. That is useful when the same operation
needs different calculations, transformations, or callbacks.

A higher-order function accepts a function, returns one, or both. A pure function
returns the same result for the same input and has no observable side effects.
Logging and changing shared state are side effects; a lambda can do either.

Collection operations can express a transformation clearly. A loop can be easier
to read when the task needs several actions or early exits. Neither approach
creates parallel execution automatically.

In the examples, map transforms, filter keeps matching elements, flatMap combines
nested results, and fold accumulates from an initial value. reduce needs a
non-empty collection. forEach returns Unit; onEach returns its receiver.

- [Higher-order functions](../../src/main/kotlin/advancedkotlin/functional/HigherOrderFunctions.kt)
- [Extensions](../../src/main/kotlin/advancedkotlin/functional/ExtensionFunctions.kt)
- [Kotlin function documentation](https://kotlinlang.org/docs/lambdas.html)
- [Collection transformations](https://kotlinlang.org/docs/collection-transformations.html)

Earlier performance claims and my longer list of “commandments” remain in Git
history. These notes focus on what the syntax does.
