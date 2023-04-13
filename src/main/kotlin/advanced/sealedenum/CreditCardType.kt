package advanced.sealedenum

import advanced.sealedenum.Sports.*

/**
 * Enums are essentially a collection of constants, or enum values.
 * Enums are used to store the same type of values pretty much.
 *
 * For more practical examples, in android development for example,
 * we use enums sometimes to hold state values when we do not need to use
 * classes or sealed classes.
 *
 * We usually use enum values with a when statement to manipulate output.
 *
 * Enums cannot inherit from abstract or open classes.
 *
 * We can assign our own properties using a constructor.
 */
enum class CreditCardType {
    // enum constants have ordinal index

    SILVER, // ordinal = 0, and they also have a name property
    GOLD, // ordinal = 1
    PLATINUM // ordinal = 2
}

// second example that inherits an interface
enum class Sports(name: String) : YourSport {
    BASKETBALL("Basketball") {
        override fun yourSport() {
            println("Your sport is Basketball.")
        }
    },
    FOOTBALL("Football") {
        override fun yourSport() {
            println("Your sport is Football.")
        }
    },
    BASEBALL("Baseball") {
        override fun yourSport() {
            println("Your sport is Baseball.")
        }
    },
    SOCCER("Soccer") {
        override fun yourSport() {
            println("Your sport is Soccer.")
        }
    },
    TENNIS("Tennis") {
        override fun yourSport() {
            println("Your sport is Tennis.")
        }
    }
}

/*
Enums can only inherit interfaces
 */
interface YourSport {
    fun yourSport()
}

/*
Start main.
 */
fun main() {


    println("Printing Enum classes and thier values..")
    Thread.sleep(1000)
    println(CreditCardType.values().forEach(::println))
    println(Sports.values().forEach(::println))
    Thread.sleep(1000)

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
    when (goldCredit) {
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

    println(Sports.BASKETBALL.yourSport())
}