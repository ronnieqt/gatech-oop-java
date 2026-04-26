public class Cat extends Pet
{
    private int miceCaught;

    public Cat(String name, double health, int painLevel, int miceCaught)
    {
        super(name, health, painLevel);
        this.miceCaught = (miceCaught < 0) ? 0 : miceCaught;
    }

    public Cat(String name, double health, int painLevel)
    {
        this(name, health, painLevel, 0);
    }

    public int getMiceCaught()
    {
        return this.miceCaught;
    }

    @Override
    public int treat()
    {
        double treatTime = 0.0;
        if (miceCaught < 4) {
            treatTime = (painLevel * 2.0) / health;
        }
        else if (miceCaught <= 7) {
            treatTime = painLevel / health;
        }
        else {
            treatTime = painLevel / (health * 2.0);
        }
        heal();
        return (int) Math.round(treatTime);
    }

    public void speak()
    {
        super.speak();
        String msg = "meow ".repeat(miceCaught).trim();
        if (miceCaught > 5) {
            msg = msg.toUpperCase();
        }
        System.out.println(msg);
    }

    @Override
    public boolean equals(Object o)
    {
        if (o instanceof Cat) {
            Cat cat = (Cat) o;
            return super.equals(o) && (this.miceCaught == cat.miceCaught);
        }
        return false;
    }

    public static void main(String[] args)
    {
        Cat c1 = new Cat("a", 0.6, 3);
        c1.speak();
    }
}
