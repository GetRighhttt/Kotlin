package advanced.sealedenum

import advanced.sealedenum.Sports.*

/**
 * Enumerated classes are classes that store the same type of values, and these values are known as constants, or
 * they can't be changed.
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
    PLATINUM; // ordinal = 2

    companion object {
        fun returnType(type: CreditCardType) = type.name
    }
}

/*
Enums can also inherit interfaces.
 */
interface YourSport {
    fun yourSport()
}

// second example that inherits an interface
enum class Sports(name: String) : YourSport {

    BASKETBALL(name = "Basketball") {
        override fun yourSport() {
            println("Your sport is $name.")
        }
    },

    FOOTBALL(name = "Football") {
        override fun yourSport() {
            println("Your sport is $name.")
        }
    },

    BASEBALL(name = "Baseball") {
        override fun yourSport() {
            println("Your sport is $name.")
        }
    },

    SOCCER(name = "Soccer") {
        override fun yourSport() {
            println("Your sport is $name.")
        }
    },

    TENNIS(name = "Tennis") {
        override fun yourSport() {
            println("Your sport is $name.")
        }
    };
}

/*
Start main.
 */
fun main() {

    println("Printing Enum classes and their values..")
    println(CreditCardType.values().forEach(::println))
    println(Sports.values().forEach(::println))
    println(CreditCardType.returnType(CreditCardType.SILVER))

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
     * valueOf() returns the enum constant name that matches the parameter
     */
    val allValues = CreditCardType.values()
    allValues.forEach { println(it) }

    /**
     * when() statement with enums...
     */
    val myCreditCard: CreditCardType = CreditCardType.GOLD
    when(myCreditCard.name) {
        CreditCardType.SILVER.toString() -> {
            println("Silver has been chosen!")
        }

        CreditCardType.GOLD.toString() -> {
            println("Gold has been chosen!")
        }

        CreditCardType.PLATINUM.toString() -> {
            println("Platinum has been chosen!")
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

    println(BASKETBALL.yourSport())
}