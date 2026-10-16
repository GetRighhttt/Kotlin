# How this Gradle build works

Gradle coordinates compilation, dependencies, tests, and tasks. This repository
uses its Kotlin DSL: the `.gradle.kts` files are Gradle configuration written in
Kotlin. The source examples still live in their original folders.

## What changed during the migration

1. Added `settings.gradle.kts` to name the project `kotlin-reference`.
2. Added `build.gradle.kts` with the Kotlin JVM plugin at version 2.4.21 and Maven
   Central for dependencies. The plugin supplies the matching standard library.
3. Selected JDK 21 for the toolchain and kept the example bytecode target at JVM
   1.8. Kotlin and Java targets match, so Gradle's compatibility checks agree.
4. Added the Gradle 9.7.0 wrapper, including its distribution SHA-256 checksum.
   Every checkout uses that Gradle version instead of relying on a global install.
5. Moved the existing checks from the Python compiler runner into JUnit tests.
   `test` checks all examples and input cases; `build` includes `test` automatically.
6. Added `run` with Hello World as its default and `examples` to list the other
   entry points. `-Pexample=...` selects an example; standard input reaches it.
7. Removed the old IntelliJ module, compiler settings, and manual library paths.
   IntelliJ now imports that information from Gradle. Generated IDE models are
   ignored, while shared code style settings remain.

## Files to know

| File | Responsibility |
| --- | --- |
| `settings.gradle.kts` | Project name and, if needed later, included subprojects |
| `build.gradle.kts` | Kotlin version, repositories, compiler settings, dependencies, and tasks |
| `gradlew` / `gradlew.bat` | Launch the pinned Gradle version on macOS/Linux or Windows |
| `gradle/wrapper/gradle-wrapper.jar` | Bootstrap code that downloads and starts Gradle |
| `gradle/wrapper/gradle-wrapper.properties` | Distribution URL and checksum |
| `src/main/kotlin/` | Runnable reference examples |
| `src/test/kotlin/` | Boundary checks and example/input tests |
| `build/` | Generated classes, JAR, and test reports; ignored by Git |

The wrapper downloads Gradle on first use and caches it for later runs. Kotlin and
test dependencies are also downloaded and cached. A JDK 21 must be installed;
IntelliJ can download it through its Gradle JVM selector.

## Commands and task flow

```sh
./gradlew run
./gradlew -q examples
./gradlew run -Pexample=datastructures.ArraysKt
./gradlew test
./gradlew clean build
```

On Windows, use `.\gradlew.bat` in place of `./gradlew`.

`run` compiles the main sources when needed, resolves the runtime dependencies,
and starts the selected example. Input-reading examples use your terminal input.

`build` creates the JAR and runs `check`, which runs `test`. Tests compile separately
from the examples. Each smoke test starts its example in a new process, sends
sample input, and checks that it exits successfully. Input tests also cover EOF
and invalid values. A process timeout prevents an input loop from hanging the suite.
Read the HTML report at `build/reports/tests/test/index.html` if a check fails.

## Updating versions

Change `kotlin("jvm") version "2.4.21"` in `build.gradle.kts` to update Kotlin.
The plugin aligns the standard library with that version. For a new language
release, also review `languageVersion` and `apiVersion` in `compilerOptions`.

Before changing Gradle, check the Kotlin plugin's supported Gradle range. Generate
updated wrapper files with the `wrapper` task, passing the intended Gradle version
and its published distribution checksum, then run the wrapper task again through
the updated wrapper to refresh its scripts and JAR. Commit all wrapper files,
including the JAR and executable permission on `gradlew`.

After a version update, run `./gradlew clean build` and `./gradlew run`, sync the
project in IntelliJ, and update the [version note](kotlin-version.md) and README.

## Documentation

- [Kotlin Gradle configuration and compatibility](https://kotlinlang.org/docs/gradle-configure-project.html)
- [Gradle wrapper](https://docs.gradle.org/current/userguide/gradle_wrapper.html)
- [Gradle Java toolchains](https://docs.gradle.org/current/userguide/toolchains.html)
