# Scope functions

I distinguish scope functions by how the block refers to its object and what
comes back from the call.

| Function | Access inside the block | Result |
| --- | --- | --- |
| let | it | Last expression |
| run (extension) | this | Last expression |
| with | this; object passed as an argument | Last expression |
| apply | this | Original object |
| also | it | Original object |

Use apply to configure an object and also for an extra action such as logging.
let and run are useful when producing a result from an object. with groups work
on an object passed as an argument. The non-extension run form groups expressions
without supplying a receiver.

`value?.let { ... }` skips the block when value is null. let itself does not add a
null check. Avoid nesting several scope functions when naming a variable would
make the code easier to follow.

- [Runnable examples](../src/main/kotlin/advancedkotlin/scopefunctions/ScopeFunctions.kt)
- [Kotlin scope function documentation](https://kotlinlang.org/docs/scope-functions.html)
- [Earlier reference image 1](images/scope-functions-1.png)
- [Earlier reference image 2](images/scope-functions-2.png)
