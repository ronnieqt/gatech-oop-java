public class Dog extends Canine
{
    protected String name;

    public Dog(String name, double size)
    {
        super(size);
        this.name = name;
    }

    public void fetch()
    {
        System.out.println("Run");
        System.out.println("Clinch");
        System.out.println("Return");
    }

    // The key point about this header is that the type of input is Object.
    // When a reference does point to an object that is different from its type,
    //   the only methods that we invoke on the object (using that reference) are the ones declared in the references' type.
    // That rule means that regardless of what o is pointing to, it can only invoke these inherited methods of the Object class.
    @Override
    public boolean equals(Object o)
    {
        if (!(o instanceof Dog)) {  // inherent null check
            return false;
        }
        // A new Dog reference variable (doggy) is formed by casting o to a Dog.
        // The cast operator only creates a new reference and does not change the type of its operand to something else.
        Dog doggy = (Dog) o;
        return ((doggy.size == size) && (doggy.name.equals(name)));
    }

    public static void main(String[] args) 
    {
        Dog dog1 = new Dog("Spot", 9.6);
        Dog dog2 = new Dog("Spot", 9.6);
        Dog dog3 = new Dog("Spot", 9.600001);
        dog1.bark(); // inheriting methods
        System.out.println("dog1 == dog2: " + dog1.equals(dog2));
        System.out.println("dog1 == dog3: " + dog1.equals(dog3));
    }
}
