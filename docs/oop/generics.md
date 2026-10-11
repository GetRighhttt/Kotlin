# Generics and variance

A generic declaration uses a type parameter so the same logic can work with
different types while keeping type checking.

`Box<T>` is invariant. Box<String> and Box<Any> are not subtypes of one another,
even though String is a subtype of Any. Otherwise, writing an Int through a
Box<Any> reference could corrupt a box intended to hold Strings.

`Producer<out T>` is covariant: a Producer<String> can be used as Producer<Any>.
It supplies T values.

`Consumer<in T>` is contravariant: a Consumer<Any> can be used as Consumer<String>.
It accepts T values. The restriction concerns where T appears; a consumer may
still return values of other types.

The [runnable example](../../src/main/kotlin/oop/generics/GenericsExamples.kt)
shows both assignments. The commented Box assignment demonstrates the rejected
invariant case.

[Kotlin generics documentation](https://kotlinlang.org/docs/generics.html).
