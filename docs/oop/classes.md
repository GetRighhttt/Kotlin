1. CLASS - typically bundles together state and its operations by way of
 properties and operations. Classes are viewed as templates of objects.

2. LOCAL Classes - are classes defined inside of functions. Used if a function needs
some specific information.

3. NESTED Classes - creating a class is inside of another class. Works great if you need a helper
class that acts uniquely to the outer class, however it cannot access the outer class member variables.
Can be a good choice for serializable models.

4. INNER Classes - nested classes that have access to the outer class member variables. The only difference
is you have to call the inner class from the object.

5. DATA Classes - classes meant to hold data that have generated built-in methods(copy(), hashcode(), toString()).
Good for modeling json responses and DTO, and they can also be destructed.

6. VALUE Classes - good for when you want to create specific classes for a value without creating an object in
memory for that value. So if we want to modify values specifically, value classes allow the JVM to compile them as regular
values and not classes. It must be one property and it must be read-only (val).

7. ENUM Classes - enumeration classes are used for limiting values that pertain to a type, holding state, or static
names for a specific type.

8. SEALED Classes - limit the subtypes of a class and also good for holding state. Very similar to enums except they
typically house data classes, objects, etc. for state management. Sealed Classes are really good for when you need to
determine the response type of a HTTP response.

9. ANNOTATION Classes - annotations pretty much indicate what kind of elements, when a class can run, etc. These are
mainly used for building out Frameworks.