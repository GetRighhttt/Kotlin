import advancedkotlin.functional.*
import advancedkotlin.functional.morefunctions.*
import advancedkotlin.sealedenum.Mathematics
import advancedkotlin.sealedenum.checkMathematics
import advancedkotlin.valuecl.Name
import androidconcepts.Animal
import androidconcepts.Human
import oop.MyNewPlayer
import oop.generics.*

private fun rejects(block: () -> Unit) {
    try {
        block()
    } catch (_: IllegalArgumentException) {
        return
    }
    error("Expected an IllegalArgumentException")
}

fun main() {
    for (number in listOf(Int.MIN_VALUE, -7, 0, 1, 4, 9, 25, 49)) {
        check(!number.isPrime()) { "$number should not be prime" }
    }
    for (number in listOf(2, 3, 5, 97, Int.MAX_VALUE)) {
        check(number.isPrime()) { "$number should be prime" }
    }
    check(!"four".isNice() && "Stefan".isNice())
    check("sam".isNotHealthy() && !"stefan".isNotHealthy())
    check("Stefan".hideName() == "******")
    val numbers = mutableListOf(1, 2, 3)
    numbers.switchNumbers(0, 2)
    check(numbers == listOf(3, 2, 1))
    rejects { numbers.switchNumbers(0, 3) }
    check(numbers == listOf(3, 2, 1)) // Invalid indices must not partly mutate the list.
    numbers.switchNumbers(1, 1)
    check(numbers == listOf(3, 2, 1))

    check(properties(12.0, 42.0) == Triple(504.0, 108.0, 216.0))
    check(properties(0.0, 5.0) == Triple(0.0, 10.0, 20.0))
    rejects { properties(-1.0, 5.0) }
    rejects { properties(Double.NaN, 5.0) }
    rejects { properties(1.0, Double.POSITIVE_INFINITY) }
    check(generateDivision()(20) == 2)
    check(generateMultiplication()(30.0, 10.0) == 300.0)
    check(higherOrderOperation(4, 5) { a, b -> a + b } == 9)
    rejects { delta(10, 0) }

    var calls = 0
    check(3 allowFor { calls++; it * 2 } == 6)
    check(calls == 1)
    val text: String? = listOf("Kotlin").firstOrNull()
    check(text.hasText())
    if (text.hasText()) check(text.length == 6) // The contract permits this smart cast.
    check(!null.hasText() && !" ".hasText())
    val sample = SampleText()
    sample isSetting "Sample text"
    sample isRemoving "Sample "
    check(sample.text == "text" && sample.isStarting("te"))
    val operations = OperationValues(10)
    check((operations + 5).totalNumberOfOperations == 15)
    check((operations - 3).totalNumberOfOperations == 7)
    check(operations.totalNumberOfOperations == 10)
    check(operations() == operations && operations() !== operations)
    check("Stefan" { it.uppercase() } == "STEFAN")

    val human = Human().apply { age = 25 }
    rejects { human.age = -1 }
    check(human.age == 25)
    val animal = Animal()
    val view = animal.animalList
    animal.addAnimal("Dog")
    check(view == listOf("Dog"))
    val player = MyNewPlayer("Luther", 10)
    player.score = -5
    check(player.score == 0)
    rejects { player.rollBall(-1) }
    check(player.TeamMate("DJ").pairing() == "Luther and DJ")

    val producer: Producer<Any> = ShowProducer()
    check(producer.producer() is String)
    var consumed: Any? = null
    val broadConsumer: Consumer<Any> = object : Consumer<Any> {
        override fun consumer(item: Any) { consumed = item }
    }
    val consumer: Consumer<String> = broadConsumer
    consumer.consumer("Kotlin")
    check(consumed == "Kotlin")
    rejects { Name(" ") }
    check(Name("Stefan") == Name("Stefan"))
    rejects { checkMathematics(Mathematics.Division(10, 0)) }
    println("Reference boundary checks passed.")
}
