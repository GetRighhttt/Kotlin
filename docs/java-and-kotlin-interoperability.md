# Java and Kotlin interoperability

On the JVM, Kotlin and Java source compile to JVM bytecode. They are not
“decompiled” into class files. A project can contain both languages, and Kotlin
can call Java classes such as java.util.HashMap.

Java references can appear as platform types when nullability information is
missing. Those need care: Kotlin's nullable types do not prevent every exception
at an interop boundary.

Kotlin properties commonly appear as Java getters and setters. @JvmStatic can
expose a companion or object function as a Java static method; @JvmName can change
a generated JVM name. Those annotations change the Java-facing API.

- [Calling Java from Kotlin](https://kotlinlang.org/docs/java-interop.html)
- [Calling Kotlin from Java](https://kotlinlang.org/docs/java-to-kotlin-interop.html)
- [HashMap example](../src/main/kotlin/datastructures/Maps.kt)
