package datastructures

/*
Maps is a collection of key-value pairs in which keys are unique, and is used
quite often in real-world applications.

The keyword "to" is used to create a pair of two elements. This keyword is actually a special function
in the Kotlin language that is built in.
 */

 fun main() {

     val basketballGOATPyramid = mapOf(
         1 to "Michael Jordan",
         2 to "Kobe",
         3 to "Hakeem Olajuwon",
         4 to "Kareem Abdul-Jabbar",
         5 to "Magic Johnson"
     )

     println(basketballGOATPyramid.values) // prints the values to a list
     println(basketballGOATPyramid.keys) // prints the ids or keys to a list
     println(basketballGOATPyramid) // in a set

     /*
     [Michael Jordan, Kobe, Hakeem Olajuwon, Kareem Abdul-Jabbar, Magic Johnson]
     [1, 2, 3, 4, 5]
     {1=Michael Jordan, 2=Kobe, 3=Hakeem Olajuwon, 4=Kareem Abdul-Jabbar, 5=Magic Johnson}
      */

 }