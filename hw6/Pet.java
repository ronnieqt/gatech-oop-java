// any pet that would seek consultation from the clinic
public abstract class Pet
{
    protected String name;
    protected double health; // [0.0,1,0]
    protected int painLevel; // 1,2,...,10

    public Pet(String name, double health, int painLevel)
    {
        this.name = name;
        this.health = (health > 1.0) ? 1.0 : ((health < 0.0) ? 0.0 : health);
        this.painLevel = (painLevel > 10) ? 10 : ((painLevel < 1) ? 1 : painLevel);
    }

    public String getName()
    {
        return this.name;
    }

    public double getHealth()
    {
        return this.health;
    }

    public int getPainLevel()
    {
        return this.painLevel;
    }

    // the time taken (in minutes) to treat the pet
    public abstract int treat();

    public void speak()
    {
        String msg = "Hello! My name is " + this.name;
        if (painLevel > 5) {
            msg = msg.toUpperCase();
        }
        System.out.println(msg);
    }

    public boolean equals(Object o)
    {
        if (o instanceof Pet) {
            Pet pet = (Pet) o;
            return this.name.equals(pet.name);
        }
        return false;
    }

    protected void heal()
    {
        this.health = 1.0;
        this.painLevel = 1;
    }
}
