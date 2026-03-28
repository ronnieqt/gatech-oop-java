// Q: Why we need interfaces?
// How do we write generic code like a loop that interacts with objects of different
//   classes that have no superclass or subclass relationship besides the fact that they're subclasses of object?
//   Furthermore, these objects have similar behaviors outside of the methods in object, 
//   and we might wanna invoke that code.
// Interfaces provide an elegant solution to this kind of problem.
// They allow us to formalize groups of two or more classes that have no meaningful inheritance relationships, 
//   but they share similar kinds of behaviors.

// In an interface, we declare a set of abstract methods that we expect a group of classes to define in their own way.
// Once we compile the interface, we get a class file that represents a new type
//   -- a very hollow one for that matter but one that still represents a broad concept or thing. 

// Any concrete or abstract class can then declare itself as an implementor of the interface.
// In the concrete case, the class must define all of the interface’s methods. If not, the class will not compile.
// On the other hand, an abstract class that does not define all of an interface's methods
//   will compile since it can delegate that task to a concrete subclass.

// An interface is a type.
// An object of a class that implements the interface 
//   is not only an instance of that class (and its superclasses) 
//   but also the interface.
// There are no restrictions as to how many interfaces a class implements,
//   so interfaces allow us much more flexibility with the types our classes can belong to.

// If we added an implement groomable clause to the canine class,
//   all the subclasses would automatically be groomable types via inheritance.
// So in essence, Java passes the implements clause down the inheritance tree.

// Modfiers like public and abstract can be ommitted in an interface as they are implied.

// An interface provides a way of enforcing that a class declares and/or defines one or more methods.
// One way to think about an interface is that it's like a contract.
// If the class implements an interface, it's bound to a contract represented by a set of abstract methods.

public interface IGroomable  // no need for the abstract modifier
{
    public void groom();
}
