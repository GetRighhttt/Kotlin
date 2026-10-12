# How this repository grew

I started this repository in August 2022 to teach myself Kotlin and keep examples
of syntax I wanted to remember. I added to it over the years, often experimenting
with a feature and coming back later to explain it.

The commit history keeps that earlier work. The current examples have been cleaned
up so I can use them as a reference without carrying forward incorrect explanations.

- **2022:** variables, arithmetic, strings, control flow, functions, and collections;
  later, enums, sealed classes, data classes, and scope functions.
- **2023:** more OOP examples, backing fields and properties, generics, function types,
  delegation, and experiments with infix functions and contracts.
- **2024–2025:** revisits, additional examples, and cleanup. Coroutines were removed
  from this repository in January 2025.
- **2026:** expanded extension and scope function explanations, reference images,
  the reference cleanup covering all examples and notes, and an upgrade to Kotlin 2.4.21.

A few commits to revisit:

```sh
git show fdfc2c2    # August 2022: the original Hello World example
git show 26278c1    # August 2022: arithmetic operations
git show 7e6620d    # December 2023: experimenting with SimpleEffect
git show 4ba006d    # January 2025: expanding the null examples
git show 6339e53    # June 2026: explaining extension functions
git show 74f1ca5    # June 2026: explaining scope functions
```

To follow one file across renames, use:

```sh
git log --follow -- src/main/kotlin/basics/ArithmeticOperations.kt
```
