package designpatterns

/*
A "Singleton" is about limiting memory usage and resource allocation. When we create objects that are the same,
we are being wasteful and using unnecessary resources. This is a problem when we want our apps to scale and need
additional resources in order to do so.

In Kotlin, this is made easy for us by using the 'object' keyword. All of our requirements are met in Kotlin by using
the object keyword.
Singleton requirements:

1. Should have exactly one instance.
2. Instance should be accessible by all parts of the system.
3. Thread safe
4. Performant
5. Lazy initialization

Object keyword is basically like a class except it cant have a constructor, and it cannot be instantiated.
Also, this keyword is used for more than just singletons in kotlin.
 */
object SingletonObject {

    init {
        // We can use an init block if we need something to happen when the object is called.
    }
}