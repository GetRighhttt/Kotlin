# Kotlin reference and learning notes

A collection of Kotlin examples and notes I built over years while teaching myself
the language. The comments, experiments, and explanations are part of the learning
material. This repository explores Kotlin syntax and features that can help simplify
Android development.

I enjoy learning and discussing Kotlin. Teach me what you know, and I’ll share what
I know.

## Explore the examples

Each topic lives under `src/main/kotlin/`. Many files have their own `main()` function
so you can run an example individually. Start with the [basics guide](docs/basics.md)
for a quick lookup by syntax.

| Topic | Examples |
| --- | --- |
| Basics | [Variables, strings, nulls, functions, and control flow](src/main/kotlin/basics/) |
| Data structures | [Arrays, lists, maps, and sets](src/main/kotlin/datastructures/) |
| Object-oriented programming | [Classes, constructors, objects, delegation, and type aliases](src/main/kotlin/oop/) |
| Generics | [Generic types and variance](src/main/kotlin/oop/generics/) |
| Functional programming | [Function types, lambdas, extensions, and higher-order functions](src/main/kotlin/advancedkotlin/functional/) |
| More functions | [Infix, inline, local functions, and operator overloading](src/main/kotlin/advancedkotlin/functional/morefunctions/) |
| Data classes | [Data classes and copying](src/main/kotlin/advancedkotlin/datacl/) |
| Scope functions | [Scope function examples](src/main/kotlin/advancedkotlin/scopefunctions/) |
| Sealed classes and enums | [Sealed hierarchies and enums](src/main/kotlin/advancedkotlin/sealedenum/) |
| Value classes | [Value class examples](src/main/kotlin/advancedkotlin/valuecl/) |
| Android-related concepts | [Backing fields and properties](src/main/kotlin/androidconcepts/) |

The written explanations and reference images are collected in [docs/](docs/README.md).
The [learning history](docs/learning-history.md) points to earlier versions and
explains how the repository grew. The basics have been reviewed in this cleanup;
the remaining topics and historical notes still need a review.

## Run an example

### IntelliJ IDEA

1. Open this repository in IntelliJ IDEA with Kotlin support enabled.
2. Configure an installed JDK as the Project SDK. The checked-in module is `KotlinBasics`.
3. Open an example such as `src/main/kotlin/basics/HelloWorld.kt`.
4. Run its `main()` function using the gutter run button.

### Command line

With a JDK and the Kotlin command-line tools installed, run from the repository root:

```sh
mkdir -p build
kotlinc src/main/kotlin -d build/examples.jar
kotlin -classpath build/examples.jar basics.HelloWorldKt
```

Compile the full source directory: some examples reference declarations from other
files. Change the final class name to run another example (for example,
`datastructures.ArraysKt`). Input-reading examples need an interactive terminal.
Some examples contain deliberate placeholders or experiments, so inspect the file
before running it.

This project currently uses IntelliJ module configuration rather than a Gradle or
Maven build. Generated output belongs in `out/` or `build/` and is ignored by Git.
