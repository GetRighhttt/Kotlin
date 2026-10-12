# Arrays and collections

These examples began in 2022 and grew as I practiced collection operations.
Earlier versions are in Git history; this page is the current reference.

| Type | What to remember | Example |
| --- | --- | --- |
| Array | Fixed size; elements can change | [Arrays.kt](../src/main/kotlin/datastructures/Arrays.kt) |
| List | Ordered, indexed, allows duplicates | [List.kt](../src/main/kotlin/datastructures/List.kt) |
| Set | Unique elements | [Sets.kt](../src/main/kotlin/datastructures/Sets.kt) |
| Map | Unique keys associated with values | [Maps.kt](../src/main/kotlin/datastructures/Maps.kt) |

## Read-only and mutable

List, Set, and Map expose read-only operations. Their mutable counterparts add write
operations. A read-only reference can point to a mutable collection and observe its
changes. A val prevents reassignment of the reference; it does not freeze an object.
List.kt demonstrates this with a view and a shallow copy.

## Ordering and output

HashMap and HashSet leave iteration order unspecified. Sort their contents when
showing output that needs a predictable order. Arrays use contentToString() to
print their elements and contentEquals() to compare them.

## Collections, sequences, and Java streams

Kotlin sequences and Java streams are separate APIs. A List filter/map chain
creates intermediate lists. With asSequence(), those transformations run as a
terminal operation such as toList() consumes elements. A sequence can avoid
intermediate lists, but that does not make it faster in every case.

## Run an example

```sh
mkdir -p build
kotlinc src/main/kotlin -language-version 2.4 -api-version 2.4 -jvm-target 1.8 -d build/examples.jar
kotlin -classpath build/examples.jar datastructures.ArraysKt
```

ListKt reads up to five valid integers. Invalid text is retried; closed input ends
the loop and prints the numbers collected so far.

## Kotlin documentation

- [Collections](https://kotlinlang.org/docs/collections-overview.html)
- [Arrays](https://kotlinlang.org/docs/arrays.html)
- [Sequences](https://kotlinlang.org/docs/sequences.html)
