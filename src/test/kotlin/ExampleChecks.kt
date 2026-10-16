import java.io.File
import java.util.concurrent.TimeUnit
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory

class ExampleChecks {
    private val inputs = mapOf(
        "basics.ReadingUserInputKt" to "hello\n32\n",
        "datastructures.ListKt" to "1\n2\n3\n4\n5\n",
        "advancedkotlin.functional.ExtensionFunctionsKt" to "97\nStefan\n",
        "androidconcepts.BackingFieldKt" to "5\n",
        "androidconcepts.BackingPropertyKt" to "lion\ntiger\nbear\ngiraffe\ncow\n"
    )
    private val expectedOutput = mapOf(
        "basics.ReadingUserInputKt" to listOf("olleh", "This is the number minus 10: 22"),
        "advancedkotlin.functional.ExtensionFunctionsKt" to listOf("is a prime number", "******"),
        "advancedkotlin.functional.morefunctions.LocalFunctionsKt" to listOf("Perimeter: 108.0"),
        "androidconcepts.BackingFieldKt" to listOf("You are a baby!"),
        "androidconcepts.BackingPropertyKt" to listOf("[Cat, Dog, Squirrel]")
    )

    @TestFactory
    fun runnableExamples(): List<DynamicTest> {
        val sources = File("src/main/kotlin").walkTopDown()
            .filter { it.isFile && it.extension == "kt" }
            .sortedBy { it.path }
        val entries = sources.mapNotNull { source ->
            val text = source.readText()
            if (!Regex("""(?m)^fun main\(\)""").containsMatchIn(text)) return@mapNotNull null
            val packageName = Regex("""(?m)^package ([\w.]+)""").find(text)!!.groupValues[1]
            "$packageName.${source.nameWithoutExtension}Kt"
        }.toList()
        check(entries.isNotEmpty()) { "No example entry points were found." }
        return entries.map { entry ->
            DynamicTest.dynamicTest(entry) {
                val output = runExample(entry, inputs[entry].orEmpty())
                for (line in expectedOutput[entry].orEmpty()) {
                    check(line in output.lines()) { "$entry: missing '$line'\n$output" }
                }
            }
        }
    }

    private data class InputCase(val entry: String, val input: String, val expected: String)

    @TestFactory
    fun inputBoundaries(): List<DynamicTest> {
        val cases = inputs.keys.map { InputCase(it, "", "") } + listOf(
            InputCase("basics.ReadingUserInputKt", "hello\nwrong\n", "Please enter a whole number within the Int range."),
            InputCase("basics.ReadingUserInputKt", "hello\n-2147483648\n", "This is the number minus 10: -2147483658"),
            InputCase("datastructures.ListKt", "bad\n\n3\n1\n", "Input ended after 2 numbers."),
            InputCase("advancedkotlin.functional.ExtensionFunctionsKt", "wrong\nStefan\n", "No valid Int was supplied."),
            InputCase("advancedkotlin.functional.ExtensionFunctionsKt", "-7\nsam\n", "not prime"),
            InputCase("androidconcepts.BackingFieldKt", "-1\n", "No valid age was supplied."),
            InputCase("androidconcepts.BackingFieldKt", "wrong\n", "No valid age was supplied."),
            InputCase("androidconcepts.BackingPropertyKt", "\n  Fox  \nq\n", "[Fox]")
        )
        return cases.mapIndexed { index, case ->
            DynamicTest.dynamicTest("input case ${index + 1}: ${case.entry}") {
                val output = runExample(case.entry, case.input)
                check(case.expected.isEmpty() || case.expected in output.lines()) {
                    "${case.entry}: missing '${case.expected}'\n$output"
                }
            }
        }
    }

    private fun runExample(entry: String, input: String): String {
        val javaName = if (System.getProperty("os.name").startsWith("Windows")) "java.exe" else "java"
        val java = File(System.getProperty("java.home"), "bin/$javaName").absolutePath
        val classpath = checkNotNull(System.getProperty("examples.classpath"))
        val outputFile = File.createTempFile("kotlin-example-", ".log")
        var process: Process? = null
        try {
            process = ProcessBuilder(java, "-classpath", classpath, entry)
                .redirectErrorStream(true)
                .redirectOutput(outputFile)
                .start()
            process.outputStream.bufferedWriter().use { it.write(input) }
            check(process.waitFor(15, TimeUnit.SECONDS)) { "$entry did not finish within 15 seconds." }
            val output = outputFile.readText()
            check(process.exitValue() == 0) { "$entry failed:\n$output" }
            return output
        } finally {
            process?.destroyForcibly()
            outputFile.delete()
        }
    }
}
