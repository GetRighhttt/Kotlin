package advancedkotlin.sealedenum

/** An enum has a fixed set of named instances. Each can have properties and behavior. */
enum class CreditCardType {
    SILVER, GOLD, PLATINUM;
    companion object { fun returnType(type: CreditCardType): String = type.name }
}
interface YourSport { fun yourSport() }
enum class Sports(val displayName: String) : YourSport {
    BASKETBALL("Basketball"),
    FOOTBALL("Football"),
    BASEBALL("Baseball"),
    SOCCER("Soccer"),
    TENNIS("Tennis");
    override fun yourSport() { println("Your sport is $displayName.") }
}

fun main() {
    CreditCardType.entries.forEach(::println) // SILVER, GOLD, PLATINUM
    Sports.entries.forEach(::println)
    println(CreditCardType.returnType(CreditCardType.SILVER)) // SILVER
    println("${CreditCardType.SILVER.ordinal}, ${CreditCardType.SILVER.name}") // 0, SILVER
    // ordinal is the declaration position; do not treat it as a stable stored ID.
    println(CreditCardType.valueOf("GOLD")) // GOLD; unknown names throw IllegalArgumentException.

    // Match enum values directly, retaining exhaustive checking.
    val myCreditCard = CreditCardType.GOLD
    val message = when (myCreditCard) {
        CreditCardType.SILVER -> "Silver has been chosen!"
        CreditCardType.GOLD -> "Gold has been chosen!"
        CreditCardType.PLATINUM -> "Platinum has been chosen!"
    }
    println(message)
    Sports.BASKETBALL.yourSport() // Your sport is Basketball.
    // entries exposes the enum values without creating a new array on each access.
    // values() is still available when an array is needed.
}
