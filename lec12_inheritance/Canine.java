// Inheritance allows for "is a" relationships.

/* Access Modifiers
 * +----------------+---------+---------+----------+-------+
 * | Modifier       | Class   | Package | Subclass | World |
 * +----------------+---------+---------+----------+-------+
 * | public         |   Y     |   Y     |    Y     |   Y   |
 * | protected      |   Y     |   Y     |    Y     |   N   |
 * | none/default   |   Y     |   Y     |    N     |   N   |
 * | private        |   Y     |   N     |    N     |   N   |
 * +----------------+---------+---------+----------+-------+
 */

/* Abstract Modifier
 * We can assign the abstract modifier to methods and classes that are not fully defined.
 * An abstract method is simply a method, that has a declaration but no definition.
 * If a class has an abstract method, it must be declared abstract as well.
 */

// Abstract classes should represent *generic* concepts or things.
// An abstract class, tows the line between the concrete and undefined while still effectively representing concepts or things.
// There may be behaviors that we have in mind, but only have names and very high level objectives for them.
// So we leave the details to the subclasses to define.
public abstract class Canine 
{
    // public > protected > private
    // private members are not inherited
    // protected members can only be accessed by its sub-classes and 
    //   any other class within that class's package
    protected double size;
    
    public Canine(double size)
    {
        this.size = size;
    }

    public void bark()
    {
        System.out.println("Woof Woof");
    }

    // An abstract method has a method header, but no body.
    // We'll imagine that unlike bark, there's not much consistency in how each of the possible canine descendants groom themselves.
    // So there isn't a default groom method definition to actually putting the Canine level the hierarchy for sharing.
    // By declaring groom as an abstract method, we can enforce it any class that wants to claim that it is a Canine has a groom method.
    public abstract void groom();
}
