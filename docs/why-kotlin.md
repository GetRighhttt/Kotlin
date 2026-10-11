# Why I chose Kotlin

I made this repository to teach myself Kotlin and remember its syntax. I like how
it lets me express common Android tasks with less boilerplate.

Features I wanted to practice include nullable types, top-level functions, type
inference, data classes, sealed hierarchies, extensions, and function values.
The examples show the syntax rather than trying to prove one language is better
at every task.

Null safety helps catch unsafe access, but !! and Java interop can still cause
null pointer exceptions. Coroutines can suspend without blocking a thread at a
suspension point; they are not threads and do not make blocking code non-blocking.
The coroutine examples now live separately from this repo.

Some original notes compared Kotlin with Java features available at the time.
The current notes focus on Kotlin itself; the older comparisons remain in Git.

- [Basics](basics.md)
- [Language history](learning-history.md)
- [Kotlin null safety](https://kotlinlang.org/docs/null-safety.html)
- [Coroutine basics](https://kotlinlang.org/docs/coroutines-basics.html)
