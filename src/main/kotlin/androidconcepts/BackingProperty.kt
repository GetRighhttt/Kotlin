package androidconcepts

/*
The Backing Property in Android allows us to encapsulate variables that we do not want
to expose to the outside world, or other classes.

We typically see this used with LiveData in Android and Flows.
 */

class Animal {

    /*
    With Kotlin, we are demoing the backing property here with a var, which means it is mutable.
    Usually you would use a val but using a var allows us to use custom setters.

    In the class, we always use the backing field to update or modify the data.
    Outside the class, we use the backing property.
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

    /*
    Now we are showing the immutable variation of the backing property.
    This is the typical approach, and resembles typically how we would use LiveData or Flows in android.

    We do not need to use a custom setter here because the value is immutable, so it cannot be changed
    in main or other classes.
     */
    private val _animalList = mutableListOf<String>() // backing field
    val animalList: List<String> // backing property
        get() = _animalList // getter

    fun addAnimal(animalName: String) = _animalList.add(animalName)

    fun sortAnimalList(animalList: List<String>) = animalList.sorted()

}

fun main() {
    val myAnimalInstance = Animal() // creating an instance or animal, or an animal object
    println(myAnimalInstance.printAnimalName()) // prints Lion

    val newAnimalName = Animal()
    newAnimalName.animalName = "Squirrel"
    val newDogAnimal = Animal()
    newDogAnimal.animalName = "Dog"
    val newCatAnimal = Animal()
    newCatAnimal.animalName = "Cat"

    val myAnimalList = myAnimalInstance.animalList
    myAnimalInstance.addAnimal("Bear")
    myAnimalInstance.addAnimal("Fox")
    myAnimalInstance.addAnimal("Giraffe")
    myAnimalInstance.addAnimal("Cheetah")
    myAnimalInstance.addAnimal("Jaguar")
    myAnimalInstance.addAnimal(newAnimalName.animalName) // adds the squirrel instance to list
    myAnimalInstance.addAnimal(newDogAnimal.animalName) // adds the dog instance to list
    myAnimalInstance.addAnimal(newCatAnimal.animalName) // adds the cat instance to list

    println(myAnimalList) // prints [Bear, Fox, Giraffe, Cheetah, Jaguar, Squirrel, Dog, Cat]
    println(myAnimalInstance.sortAnimalList(myAnimalList)) // [Bear, Cat, Cheetah, Dog, Fox, Giraffe, Jaguar, Squirrel]


}