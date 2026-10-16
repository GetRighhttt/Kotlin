import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.dsl.KotlinVersion

plugins {
    kotlin("jvm") version "2.4.21"
}

repositories {
    mavenCentral()
}

kotlin {
    jvmToolchain(21)
    compilerOptions {
        languageVersion = KotlinVersion.KOTLIN_2_4
        apiVersion = KotlinVersion.KOTLIN_2_4
        jvmTarget = JvmTarget.JVM_1_8
        allWarningsAsErrors = true
    }
}

// Match Kotlin's bytecode target while using JDK 21 for compilation and tests.
java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.14.4"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.test {
    useJUnitPlatform()
    // Examples run in separate processes so their input and singleton state stay isolated.
    systemProperty("examples.classpath", sourceSets.main.get().runtimeClasspath.asPath)
    inputs.dir("src/main/kotlin")
}

// There are many entry points; choose one rather than treating the repo as one app.
tasks.register<JavaExec>("run") {
    group = "application"
    description = "Run an example: -Pexample=basics.HelloWorldKt"
    classpath = sourceSets.main.get().runtimeClasspath
    mainClass = providers.gradleProperty("example").orElse("basics.HelloWorldKt")
    standardInput = System.`in`
    javaLauncher = javaToolchains.launcherFor {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

tasks.register("examples") {
    group = "application"
    description = "List the examples available to run."
    doLast {
        fileTree("src/main/kotlin") { include("**/*.kt") }.sortedBy { it.path }.forEach { source ->
            val text = source.readText()
            if (Regex("""(?m)^fun main\(\)""").containsMatchIn(text)) {
                val packageName = Regex("""(?m)^package ([\w.]+)""").find(text)!!.groupValues[1]
                println("$packageName.${source.nameWithoutExtension}Kt")
            }
        }
    }
}
