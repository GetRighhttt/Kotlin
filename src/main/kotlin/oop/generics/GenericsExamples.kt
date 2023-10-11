package oop.generics

/*
Let's go over a few Generic examples
 */

open class Animal <T> (val t: T)

class Dog
class Fish
open class Bird
class Eagle: Bird()

fun main() {
     val myAnimal = Animal(Dog()) // declaring an invariant animal object of type dog
}