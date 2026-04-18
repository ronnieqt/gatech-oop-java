# Polymorphism

Our recent discussion of inheritance and interfaces shows that an object can be polymorphic (or exist in different forms).

* In the context of inheritance, we've seen it in the ability of an object to be referred to by a variable with a type that is a superclass of the actual class from which the object is instantiated.
* Similarly, with interfaces, we've seen that an object can be referred to by an interface-typed variable as long as the object's class (or an ancestor) implements the interface.

```java
DeclaredType refVar = new ObjectType(...);
```

Generally speaking, the object type is the actual class that follows the new operator when an object is instantiated.

Based on the declared type, Java answers a couple of questions during compilation with the respective polymorphism.

* Can object of some class be legally assigned to a reference of some declared type?
* Is every variable and method we try to access with a reference variable available (declared/defined) in its declared type?

is-a test: the the passes if we can find `DeclaredType` as one of the ancestors of `ObjectType`. An assignment or cast is legal when the is-a test passes.

Dynamic Binding:

* Besides evaluating whether a certain cast operation is legal at runtime, the JVM has to determine which version of a method to execute when an object's class and its reference's declared type have different definitions of the method.
* JVM would check the ObjectType first, then up the inheritance tree, level by level until it finds a superclass with a bark definition.
* This process of matching a method call in a statement to its actual definition at runtime (instead of compile time) is known by either of these three terms: dynamic binding, late-binding, or runtime resolution.
