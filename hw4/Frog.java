public class Frog 
{
    private String name;
    private int age;
    private double tongueSpeed;
    private boolean isFroglet;

    private static String species = "Rare Repe";

    // Ctors
    public Frog(String name, int age, double tongueSpeed)
    {
        this.name = name;
        this.age = age;
        this.isFroglet = age > 1 && age < 7;
        this.tongueSpeed = tongueSpeed;
    }

    public Frog(String name, double ageInYears, double tongueSpeed)
    {
        this(name, (int) (ageInYears * 12), tongueSpeed);
    }

    public Frog(String name)
    {
        this(name, 5, 5.0);
    }

    // Setters and Getters
    public void setSpecies(String newSpecies)
    {
        species = newSpecies;
    }

    public String getSpecies()
    {
        return species;
    }

    // Methods

    public void grow(int ageToAdd)
    {
        tongueSpeed += 1.0 * Math.min(ageToAdd, Math.max(0, 12 - age));
        tongueSpeed -= 1.0 * Math.min(ageToAdd, Math.max(0, age + ageToAdd - 30));
        tongueSpeed = Math.max(5.0, tongueSpeed);
        age += ageToAdd;
        isFroglet = age > 1 && age < 7;
    }

    public void grow()
    {
        grow(1);
    }

    public void eat(Fly fly)
    {
        if (fly.isDead()) {
            return;
        }
        else if (tongueSpeed > fly.getSpeed()) {
            // caught
            if (fly.getMass() >= 0.5 * age) {
                grow();
            }
            fly.setMass(0.0);
        }
        else {
            // not caught
            fly.grow(1);
        }
    }

    public String toString()
    {
        if (isFroglet) {
            return String.format(
                    "My name is %s and I'm a rare froglet! I'm %d months old and my tongue has a speed of %.2f.",
                    name, age, tongueSpeed);
        } else {
            return String.format(
                    "My name is %s and I'm a rare frog. I'm %d months old and my tongue has a speed of %.2f.",
                    name, age, tongueSpeed);
        }
    }

    // Main

    public static void main(String[] args) 
    {
        Frog frog1 = new Frog("FrogA");
        System.out.println(frog1);
        frog1.grow();
        System.out.println(frog1);
        frog1.grow(5);
        System.out.println(frog1);
        frog1.grow(3);
        System.out.println(frog1);
        frog1.grow(14);
        System.out.println(frog1);
        frog1.grow(5);
        System.out.println(frog1);
        frog1.grow(2);
        System.out.println(frog1);
        frog1.grow(10);
        System.out.println(frog1);
        Frog frog2 = new Frog("FrogB");
        Fly fly1 = new Fly(11.0, 4.0);
        Fly fly2 = new Fly(1.0, 3.0);
        Fly fly3 = new Fly(11.0, 10.0);
        System.out.println(frog2);
        System.out.println(fly1);
        System.out.println(fly2);
        System.out.println(fly3);
        frog2.eat(fly1);
        System.out.println(frog2);
        System.out.println(fly1);
        frog2.eat(fly2);
        System.out.println(frog2);
        System.out.println(fly2);
        frog2.eat(fly3);
        System.out.println(frog2);
        System.out.println(fly3);
        frog1.setSpecies("New Species");
        System.out.println(frog1.getSpecies());
        System.out.println(frog2.getSpecies());
    }
}
