# Classes and objects

A class groups properties and behavior. Constructor parameters become properties
when declared with val or var. init blocks run during construction. Classes and
members are final by default; open permits inheritance or overriding.

| Declaration | What I use it to remember |
| --- | --- |
| Local class | Visible inside its enclosing function |
| Nested class | Does not hold an outer instance |
| inner class | Has access to its outer instance |
| data class | Generated value-based methods and destructuring |
| value class | Distinct wrapper type; may be boxed on the JVM |
| enum class | Fixed set of named instances |
| sealed class/interface | Restricted direct subtypes and exhaustive when |
| object | Singleton declaration |
| companion object | Object associated with a class |
| annotation class | Metadata interpreted by a compiler, tool, or library |

Data-class copy() is shallow. A typealias is another name for an existing type;
a value class creates a distinct type. A matching hash code does not prove object
identity. Use == for equality and === for reference identity where supported.

- [Inheritance, composition, nested and inner classes](../../src/main/kotlin/oop/OOPExamples.kt)
- [Constructors](../../src/main/kotlin/oop/ConstructorsExample.kt)
- [Abstract classes](../../src/main/kotlin/oop/AbstractClassesEx.kt)
- [Objects and companions](../../src/main/kotlin/oop/ObjectExample.kt)
- [Delegation](../../src/main/kotlin/oop/Delegation.kt)
- [Type aliases](../../src/main/kotlin/oop/TypeAliasesEx.kt)
- [Data classes](../../src/main/kotlin/advancedkotlin/datacl/DataClasses.kt)
- [Value classes](../../src/main/kotlin/advancedkotlin/valuecl/ValueClasses.kt)
- [Enums](../../src/main/kotlin/advancedkotlin/sealedenum/Enums.kt)
- [Sealed classes](../../src/main/kotlin/advancedkotlin/sealedenum/SealedClasses.kt)

[Classes](https://kotlinlang.org/docs/classes.html),
[data classes](https://kotlinlang.org/docs/data-classes.html), and
[value classes](https://kotlinlang.org/docs/inline-classes.html) in the Kotlin docs.
