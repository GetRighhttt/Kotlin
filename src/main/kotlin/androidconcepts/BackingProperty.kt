package androidconcepts

/**
 * The Backing Property in Android allows us to encapsulate variables that we do not want
 * to expose to the outside world, or other classes.
 * We typically see this used with LiveData in Android and Flows.
 */

class Animal {

    /**
     * Mutable(var) - setter required
     */
    private var _animalName: String = "Lion" // backing FIELD - holds the actual data
    var animalName: String // backing property used in main or other classes
        get() { // custom getter
            return _animalName
        }
        set(value) { // custom setter
            _animalName = value
        }

    fun printAnimalName() = println(_animalName) // prints animal name in class

    /**
     * Immutable(val) - no setter required here.
     */
    private val _animalList = mutableListOf<String>() // backing field
    val animalList: List<String> // backing property
        get() = _animalList // getter

    fun addAnimal(animalName: String) = _animalList.add(animalName)

    fun sortAnimalList(animalList: List<String>) = animalList.sorted()

}

fun readInAnimals(list: MutableList<String>) {
    var count = 5
    while (count > 0) {
        val nameOfAnimal = readlnOrNull()
        if (nameOfAnimal == "q") break
        if (nameOfAnimal != null) {
            list.add(nameOfAnimal)
            count--
        }
    }
}

fun main() {

    val myAnimalInstance = Animal() // creating an instance or animal, or an animal object
    myAnimalInstance.printAnimalName() // prints Lion

    val newSquirrelAnimal = Animal()
    newSquirrelAnimal.animalName = "Squirrel"

    val newDogAnimal = Animal()
    newDogAnimal.animalName = "Dog"

    val newCatAnimal = Animal()
    newCatAnimal.animalName = "Cat"

    val anotherAnimalList = mutableListOf<String>()

    println("Enter in animals:")
    readInAnimals(anotherAnimalList)
    println(anotherAnimalList)

    val myAnimalList = myAnimalInstance.animalList
    myAnimalInstance.addAnimal(newSquirrelAnimal.animalName) // adds the squirrel instance to list
    myAnimalInstance.addAnimal(newDogAnimal.animalName) // adds the dog instance to list
    myAnimalInstance.addAnimal(newCatAnimal.animalName) // adds the cat instance to list

    // myAnimalList.add <- won't work because the list is immutable in the Animal class
    println(myAnimalInstance.sortAnimalList(myAnimalList)) // [Bear, Cat, Cheetah, Dog, Fox, Giraffe, Jaguar, Squirrel]

    val combinedList = mutableListOf<String>()
    combinedList.addAll(myAnimalList)
    combinedList.addAll(anotherAnimalList)

    Thread.sleep(1000)
    println("Combined List:")
    println("${combinedList.sorted()}")

    /**
     * Lion
     * Enter in animals:
     * lion
     * tiger
     * bear
     * giraffe
     * cow
     * [lion, tiger, bear, giraffe, cow]
     * [Cat, Dog, Squirrel]
     * Combined List:
     * [Cat, Dog, Squirrel, bear, cow, giraffe, lion, tiger]
     */
}