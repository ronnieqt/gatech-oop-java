public class Wolf extends Canine implements Groomable
{
    protected int rank;

    public Wolf(double size, int rank)
    {
        // A superclass' constructor is always called by the child constructor's first line, no matter what.
        // If you don't explicitly invoke it with a super call, in a child class' constructor,
        //   Java automatically invokes a parameterless super constructor at the very start of the child's constructor.
        super(size);
        this.rank = rank;
    }

    public void groom() 
    {
        System.out.println("lick");
    }

    // The final modifier signifies that methods/classes are in their terminal definition or form.
    // A final variable: cannot be modified (a constant).
    // A final method  : cannot be overwritten.
    // A final class   : cannot be subclassed (public final class <ClassName>)
    // A rule of thumb is that 
    //   when you have a method that warrants data sensitive operations or 
    //   is highly optimized to do something in a certain way,
    //   you might want to make it final to guarantee that that implementation is
    //   adhered to as the hierarchy gets more diverse and deeper.
    // The convention is to place the final keyword after the visibility modifier, but it can legally be put before.
    public final int getRank()
    {
        return rank;
    }

    // An overridden method can, however, have different kinds of visibility.
    // But a child class' version could not restrict the visibility using the parent's version.
    // Meaning, a parent could have a private method and a child could override it and make it public.
    @Override
    public void bark()  // overriding methods
    {
        for (int i = 0; i < 3; ++i) {
            // super: used to refer to a member of a superclass
            super.bark();
        }
    }

    public static void main(String[] args) 
    {
        Wolf alpha = new Wolf(17.1, 1);
        alpha.bark();  // the class of the object being referenced determines the method called.
    }
}
