# Gradle and build systems

A build system coordinates tasks such as compiling source, resolving dependencies,
running tests, and packaging output. Gradle is one build system; Maven and Ant are
other examples. “Apache” alone names an organization, not a build tool.

| File | Purpose |
| --- | --- |
| settings.gradle(.kts) | Build name, included projects, and settings |
| build.gradle(.kts) | Plugins, dependencies, and tasks |
| gradle.properties | Configuration properties |
| gradlew / gradlew.bat | Wrapper launch scripts |
| gradle/wrapper/ | Wrapper JAR and properties specifying the Gradle distribution |

The wrapper downloads the configured distribution when needed; the launcher
script does not contain a copy of Gradle itself. Transitive dependencies are
dependencies required by other dependencies.

This repository uses an IntelliJ module and command-line Kotlin tools. It does
not include a Gradle build. See the root README for its compile and check commands.

[Gradle wrapper documentation](https://docs.gradle.org/current/userguide/gradle_wrapper.html).
