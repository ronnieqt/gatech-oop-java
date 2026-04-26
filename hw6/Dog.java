public class Dog extends Pet
{
    private double droolRate;

    public Dog(String name, double health, int painLevel, double droolRate)
    {
        super(name, health, painLevel);
        System.out.println(name + ", " + health + ", " + painLevel);
        this.droolRate = (droolRate <= 0.0) ? 0.5 : droolRate;
    }

    public Dog(String name, double health, int painLevel)
    {
        this(name, health, painLevel, 5.0);
    }

    public double getDroolRate()
    {
        return this.droolRate;
    }

    @Override
    public int treat()
    {
        double treatTime = 0.0;
        if (droolRate < 3.5) {
            treatTime = (painLevel * 2.0) / health;
        }
        else if (droolRate <= 7.5) {
            treatTime = painLevel / health;
        }
        else { // droolRate > 7.5
            treatTime = painLevel / (health * 2.0);
        }
        heal();
        return (int) Math.round(treatTime);
    }

    public void speak()
    {
        super.speak();
        String msg = "bark ".repeat(painLevel).trim();
        if (painLevel > 5) {
            msg = msg.toUpperCase();
        }
        System.out.println(msg);
    }

    @Override
    public boolean equals(Object o)
    {
        if (o instanceof Dog) {
            Dog dog = (Dog) o;
            return super.equals(o) && (this.droolRate == dog.droolRate);
        }
        return false;
    }

    public static void main(String[] args)
    {
        Dog d1 = new Dog("a", 0.2, 3);
        d1.speak();
        Dog d2 = new Dog("b", -0.2, 11);
        System.out.println(d2.getHealth());
        System.out.println(d2.getPainLevel());
        System.out.println(d2.getDroolRate());
        Dog d3 = new Dog("c", 0.4, 6, -0.1);
        System.out.println("d3: " + d3.getHealth());
        System.out.println("d3: " + d3.getPainLevel());
        System.out.println("d3: " + d3.getDroolRate());
        System.out.println("d3: " + d3.treat());
        Dog d4 = new Dog("d", 0.4, 6, 4.5);
        d4.speak();
        System.out.println("d4: " + d4.treat());
        Dog d5 = new Dog("e", 0.4, 6, 8);
        System.out.println("d5: " + d5.treat());
    }
}
