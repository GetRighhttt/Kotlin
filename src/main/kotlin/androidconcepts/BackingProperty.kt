package androidconcepts

/** A private backing property stores data exposed through another property. */
class Animal {
    private var _animalName = "Lion" // A property with its own backing field.
    var animalName: String
        get() = _animalName
        set(value) { _animalName = value }

    private val _animalList = mutableListOf<String>()
    val animalList: List<String>
        get() = _animalList // A live read-only view, not an immutable snapshot.

    fun printAnimalName() { println(_animalName) }
    fun addAnimal(animalName: String): Boolean = _animalList.add(animalName)
    fun sortAnimalList(animals: List<String>): List<String> = animals.sorted()
}

fun readInAnimals(list: MutableList<String>) {
    var remaining = 5
    while (remaining > 0) {
        val input = readlnOrNull() ?: break // Closed input must end the loop.
        val name = input.trim()
        if (name == "q") break
        if (name.isBlank()) {
            println("Please enter a name, or q to quit.")
            continue
        }
        list.add(name)
        remaining--
    }
}

fun main() {
    val myAnimalInstance = Animal()
    myAnimalInstance.printAnimalName() // Lion
    val newSquirrelAnimal = Animal().apply { animalName = "Squirrel" }
    val newDogAnimal = Animal().apply { animalName = "Dog" }
    val newCatAnimal = Animal().apply { animalName = "Cat" }

    val anotherAnimalList = mutableListOf<String>()
    println("Enter up to 5 animals (q to quit):")
    readInAnimals(anotherAnimalList)
    println(anotherAnimalList)

    // Taking the view before adding animals shows that later updates are visible.
    val myAnimalList = myAnimalInstance.animalList
    myAnimalInstance.addAnimal(newSquirrelAnimal.animalName)
    myAnimalInstance.addAnimal(newDogAnimal.animalName)
    myAnimalInstance.addAnimal(newCatAnimal.animalName)
    // myAnimalList.add("Fox") does not compile through the List interface.
    println(myAnimalInstance.sortAnimalList(myAnimalList)) // [Cat, Dog, Squirrel]
    val combinedList = myAnimalList + anotherAnimalList
    println("Combined List:")
    println(combinedList.sorted())
}
