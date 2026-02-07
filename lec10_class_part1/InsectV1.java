/* Encapsulation:
 * A class itself should govern how the instance variables of its objects are manipulated 
 *   so that the objects operate as they are intended.
 * With the private keyword, we enforce encapsulation by giving access to an instance variable 
 *   to just the methods within its class.
 */

public class InsectV1
{
    // class members

    // instance variables
    private double weight;
    private int x;
    private int y;

    // static constants (final) and variables
    // Static modifier turns a class member into a shared entity across all objects of a class.
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
    public InsectV1(double initWeight, int initX, int initY) 
    {
        weight = initWeight;
        x = initX;
        y = initY;
        ++population;
    }

    // methods
    // class interface: public methods of a class
    public void eat(double amount)
    {
        System.out.println("Nibble Nibble");
        weight += amount;
    }

    public void move(int newX, int newY)
    {
        double distance = calculateDistance(x, y, newX, newY);
        if (distance > 0) {
            x = newX;
            y = newY;
            weight = weight * DIST_WEIGHT_LOSS_FACTOR * distance;
            System.out.printf("Moved %.2f units\n", distance);
        } 
        else {
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

    // test method
    public static void main(String[] args) 
    {
        System.out.println("Insect population: " + population);
        InsectV1 bug1 = new InsectV1(10, 100, 90);
        System.out.println("Insect population: " + population);
        InsectV1 bug2 = new InsectV1(4, -300, 400);
        System.out.println("Insect population: " + population);

        bug1.eat(10);
        bug1.move(1, 10);
        bug2.move(-300, 400);

        System.out.println(produceRandomeFact());
    }
}
