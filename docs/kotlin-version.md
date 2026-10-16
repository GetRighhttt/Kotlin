# Kotlin version and compiler

This repository uses Kotlin **2.4.21**, language/API level **2.4**, and the Kotlin
JVM Gradle plugin. The plugin selects the compiler and matching standard library;
you do not need to install Kotlin command-line tools.

Gradle **9.7.0** is pinned by the wrapper. A **JDK 21** toolchain builds and tests
the project. JVM target **1.8** controls the example bytecode format and does not
replace the JDK requirement for running Gradle and JUnit.

The compiler uses K2, Kotlin's current compiler frontend. Earlier compiler notes
remain in Git history; this page describes the current setup.

Start with `./gradlew run`, or use `./gradlew build` to compile and check everything.
See the [build guide](gradle-and-build-systems.md) for configuration and update steps.

- [Kotlin releases](https://kotlinlang.org/docs/releases.html)
- [Kotlin Gradle plugin](https://kotlinlang.org/docs/gradle-configure-project.html)
