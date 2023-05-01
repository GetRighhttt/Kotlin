package designpatterns.creational

/*
The Builder design pattern essentially represents breaking down the construction of objects into
step-by-step instructions. It is mostly used when you have an object that needs to be constructed, and
has a long list of parameters. To create an object, you execute a series of these steps on a builder object.
Also, you don't need to call all the steps if it is not necessary for the builder pattern. You just call the
steps that are necessary for you to proceed with building the object.

We often see this pattern used when we need to implement various jetpack libraries in android projects.
For instance, when creating Retrofit2 objects, the builder pattern is used to create that object.
 */
class FoodOrder private constructor(
    val bread: String = "Flat bread",
    val condiments: String?,
    val meat: String?,
    val fish: String?) {

    data class Builder(
        var bread: String? = null,
        var condiments: String? = null,
        var meat: String? = null,
        var fish: String? = null) {

        fun bread(bread: String) = apply { this.bread = bread }
        fun condiments(condiments: String) = apply { this.condiments = condiments }
        fun meat(meat: String) = apply { this.meat = meat }
        fun fish(fish: String) = apply { this.fish = fish }
        fun build() = bread?.let { FoodOrder(it, condiments, meat, fish) }
        fun randomBuild() = bread(bread ?: "dry")
            .condiments(condiments ?: "pepper")
            .meat(meat ?: "beef")
            .fish(fish?: "Tilapia")
            .build()
    }
}

fun main() {
    val foodOrder = FoodOrder.Builder()
        .bread("white bread")
        .meat("bacon")
        .condiments("olive oil")
        .build()
}
