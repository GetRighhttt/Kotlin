# Kotlin reference and learning notes

A collection of Kotlin examples and notes I built over years while teaching myself
and returning to the language. I made this repo to remember syntax; the
[learning history](docs/learning-history.md) shows how my understanding developed.

Kotlin is a programming language used for Android apps and other software. These
are small console examples: they print results in a terminal, and some ask for
input. You can run them before learning the syntax.

## Run your first example

### IntelliJ IDEA

1. Open the repository folder in IntelliJ IDEA with Kotlin support enabled.
2. Load the Gradle project when prompted. If you already had the project open,
   open `build.gradle.kts` and choose **Load Gradle Project**, then sync Gradle.
3. In **Settings → Build, Execution, Deployment → Build Tools → Gradle**, use the
   **Gradle wrapper** and select **JDK 21** for the Gradle JVM. IntelliJ can download
   a JDK from the JVM selector if you do not have one.
4. Open `src/main/kotlin/basics/HelloWorld.kt` and click the run button beside
   `main()`. Its output appears in the Run window.

The first sync needs internet access to download Gradle, Kotlin, and dependencies.
You do not need to install Gradle or Kotlin separately. There is no Android SDK or
emulator to configure for these console examples.

### Terminal

Install a JDK 21 and check that `java -version` reports version 21. From the
repository folder, run:

```sh
./gradlew run
```

This downloads the required tools, compiles the examples, and prints `Hello world!`.
On Windows PowerShell, use `.\gradlew.bat run` instead. The other commands below
use the same Windows replacement for `./gradlew`.

## Choose another example

List the available entry points, then pass one to `run`:

```sh
./gradlew -q examples
./gradlew run -Pexample=basics.StringsExampleKt
./gradlew run -Pexample=basics.ReadingUserInputKt --console=plain
```

An entry point is the function where an example starts. Here, its name combines
the package, filename, and `Kt`. The `examples` task lists the exact names, so you
can copy one. Examples that ask for input accept text typed into the terminal;
`--console=plain` makes their prompts easier to follow.

## Build and check

```sh
./gradlew build
```

This compiles the project, creates a JAR in `build/libs/`, and runs the tests.
The tests exercise every example with sample input, check missing and invalid
input, and verify the corrected boundary cases. Compiler warnings fail the build.
The JAR contains multiple examples; use `run` to choose which one to execute.

Useful commands:

| Command | Purpose |
| --- | --- |
| `./gradlew run` | Run Hello World |
| `./gradlew -q examples` | List examples |
| `./gradlew test` | Run the checks and write a report to `build/reports/tests/test/index.html` |
| `./gradlew clean build` | Delete generated output, rebuild, and check |
| `./gradlew tasks` | List Gradle tasks |

## Explore the examples

Start with the [basics guide](docs/basics.md) for a lookup by syntax. Each example
has comments describing its behavior and expected results.

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


The [reference notes](docs/README.md) explain the topics in more detail.
My earlier experiments and explanations remain in Git history.

## Build configuration

The project uses **Kotlin 2.4.21**, **Gradle 9.7.0**, and a **JDK 21 toolchain**.
Kotlin language/API level is **2.4**. JVM target **1.8** describes the generated
example bytecode; use JDK 21 to run this build and its tests.

`build.gradle.kts` owns compiler settings, dependencies, tests, and run tasks.
The wrapper pins the Gradle version and verifies its distribution checksum.
Generated files belong in `build/` and are ignored by Git.

See [how the Gradle build works](docs/gradle-and-build-systems.md) for the migration
steps, file responsibilities, and version update instructions.

If setup fails, check `java -version` and IntelliJ's **Gradle JVM** first. If a
first-time download fails, restore internet access and run the command again.
