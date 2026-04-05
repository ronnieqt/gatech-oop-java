/* Encapsulation:
 * A class itself should govern how the instance variables of its objects are manipulated 
 *   so that the objects operate as they are intended.
 * With the private keyword, we enforce encapsulation by giving access to an instance variable 
 *   to just the methods within its class.
 * The private modifier enforces encapsulation.
 */

public class Insect
{
    // class members

    // instance variables
    private double weight;
    private int x;
    private int y;

    // static constants (final) and variables
    // Static modifier turns a class member into a shared entity across all objects of a class.
    public static final int DEFAULT_X = 0;
    public static final int DEFAULT_Y = 0;
    public final double DIST_WEIGHT_LOSS_FACTOR = 0.0001;
    private static int population = 0;
    private static final String[] FACTS = {
        "The two main groups of insects are winged and wingless",
        "There are more than 1 million insect species",
        "Insects are cold-blooeded",
        "Spiders are not considered insects"
    };

    // constructor
    // default values of instance variables in a default ctor
    //   numeric primitive types : 0
    //   boolean                 : false
    //   class (object type)     : null
    public Insect(double initWeight)
    {
        // DIY principle: don't repeat yourself.
        // a more specific constructor calls a less specific one
        this(initWeight, DEFAULT_X, DEFAULT_Y);
    }

    public Insect(double weight, int x, int y) 
    {
        // within a method's body, any use of an identifier that's also the name of a formal parameter
        // represents that formal parameters
        this.weight = weight;  // use "this" as a reference
        this.x = x;
        this.y = y;
        ++population;
    }

    // methods
    // class interface: public methods of a class
    public void eat(double amount)
    {
        System.out.println("Nibble Nibble");
        weight += amount;
    }

    // getters (getVarName) and setters (setVarName)
    // setter methods should include validation before setting the variable if applicable
    public double getWeight() 
    {
        return weight;
    }

    public int getX()
    {
        return x;
    }

    public void setX(int x)
    {
        if (isLegalX(x)) {
            this.x = x;
        }
    }

    public int getY()
    {
        return y;
    }

    public void setY(int y)
    {
        if (isLegalY(y)) {
            this.y = y;
        }
    }

    @Override  // method override
    public String toString() 
    {
        return String.format("Insect(weight: %.1f, x: %d, y: %d)", weight, x, y);
    }

    // getters for static variables must also be static
    public static int getPopulation()
    {
        return population;
    }

    public void move(int x, int y)
    {
        double distance = calculateDistance(this.x, this.y, x, y);
        if (distance > 0) {
            this.x = x;
            this.y = y;
            weight = weight * DIST_WEIGHT_LOSS_FACTOR * distance;
            System.out.printf("Moved %.2f units\n", distance);
        } else {
            System.out.println("Staying put");
        }
    }

    // static method:
    //   Methods that do not represent actions that would be performed
    //   on the specific object of a class should be static.
    private static double calculateDistance(double x1, double y1, double x2, double y2)
    {
        double dx = x2 - x1;
        double dy = y2 - y1;
        return Math.sqrt(dy * dy + dx * dx);
    }

    // A static method cannot directly access a non-static member
    public static String produceRandomeFact()
    {
        // min + (U * ((max - min) + 1))
        int idx = (int) (Math.random() * ((FACTS.length - 1) + 1));
        return FACTS[idx];
    }

    public static boolean isLegalX(int newX)
    {
        return (newX >= 0 ? true : false);
    }

    public static boolean isLegalY(int newY)
    {
        return (newY >= 0 ? true : false);
    }
}
