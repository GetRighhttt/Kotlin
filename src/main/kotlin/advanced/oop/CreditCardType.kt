package advanced.oop

import advanced.oop.Sports.*

/**
 * Enums are essentially a collection of constants, or enum values.
 * Enums are used to store the same type of values pretty much.
 *
 * For more practical examples, in android development for example,
 * we use enums sometimes to hold state values when we do not need to use
 * classes or sealed classes.
 *
 * We usually use enum values with a when statement to manipulate output.
 */
enum class CreditCardType {
    // enum constants have ordinal index

    SILVER, // ordinal = 0, and they also have a name property
    GOLD, // ordinal = 1
    PLATINUM // ordinal = 2
}

// second example
enum class Sports(name: String) {
    BASKETBALL("Basketball"),
    FOOTBALL("Football"),
    BASEBALL("Baseball"),
    SOCCER("Soccer"),
    TENNIS("Tennis")
}

/*
Start main.
 */
fun main() {
    // how we declare an object of an enum class
    val goldCredit: CreditCardType = CreditCardType.GOLD
    println("The second best card type is $goldCredit!")

    val silverCredit = CreditCardType.SILVER
    println("The third best card type is $silverCredit!")

    val platinumCredit = CreditCardType.PLATINUM
    println("The best card type is $platinumCredit!")

    /**
     * Each Enum has two properties: ordinal and name..
     */
    println("${CreditCardType.SILVER.ordinal} , ${CreditCardType.SILVER.name}")

    /**
     * Enums also have two built in methods: values() and valueOf().
     * values() returns an array of values of enum objects
     * valueOf() returns an
     */
    val allValues = CreditCardType.values()
    allValues.forEach { println(it) }

    /**
     * when() statement with enums...
     */
    when(goldCredit) {
        CreditCardType.SILVER -> {
            println("Silver")
        }
        CreditCardType.GOLD -> {
            println("Gold")
        }
        CreditCardType.PLATINUM -> {
            println("Platinum")
        }
    }

    val newSport: Sports = BASEBALL
    when (newSport.name) {
        "BASKETBALL" -> println("Favorite sport is $BASKETBALL.")
        "FOOTBALL" -> println("Second favorite sport is $FOOTBALL")
        "BASEBALL" -> println("$BASEBALL is third...")
        "SOCCER" -> println("$SOCCER is actually third..")
        "TENNIS" -> println("I don't even know why $TENNIS is here...")
    }
}