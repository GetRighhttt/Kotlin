# Idiomatic Kotlin

Idiomatic code uses familiar Kotlin conventions to make intent easy to read.
It does not need to use every language feature.

I use val when reassignment is unnecessary, expression bodies for short functions,
and data classes for records of values. Safe calls and Elvis make nullable cases
visible. Named arguments help explain Boolean parameters.

Extensions are useful when they describe an operation on the receiver. Scope
functions help when the receiver and return value are clear. If a chain gets hard
to follow, intermediate variables are fine.

The [basics](basics.md) and [collections](data-structures.md) guides show these
choices in small examples.

[Kotlin idioms](https://kotlinlang.org/docs/idioms.html).
