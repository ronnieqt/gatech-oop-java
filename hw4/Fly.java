public class Fly 
{
    private double mass;
    private double speed;

    // Constructors

    public Fly(double mass, double speed)
    {
        this.mass = mass;
        this.speed = speed;
    }

    public Fly(double mass)
    {
        // constructor chaining
        this(mass, 10.0);
    }

    public Fly()
    {
        this(5.0, 10.0);
    }

    // Setters and Getters

    public void setMass(double mass)
    {
        this.mass = mass;
    }

    public void setSpeed(double speed)
    {
        this.speed = speed;
    }

    public double getMass()
    {
        return mass;
    }

    public double getSpeed()
    {
        return speed;
    }

    // Methods

    public String toString()
    {
        if (isDead()) {
            return String.format("I'm dead, but I used to be a fly with a speed of %.2f.", speed);
        } else {
            return String.format("I'm a speedy fly with %.2f speed and %.2f mass.", speed, mass);
        }
    }

    public void grow(int massToAdd)
    {
        if (mass < 20.0) {
            speed = speed + Math.min(20.0 - mass, massToAdd) - 0.5 * Math.max(0.0, mass + massToAdd - 20.0);
        }
        else {
            speed -= 0.5 * massToAdd;
        }
        mass += massToAdd;
    }

    public boolean isDead()
    {
        return mass == 0.0;
    }

    // Main

    public static void main(String[] args) 
    {
        Fly fly = new Fly();
        System.out.println(fly);
        fly.grow(10);
        System.out.println(fly);
        fly.grow(7);
        System.out.println(fly);
        fly.grow(3);
        System.out.println(fly);
        fly.setMass(0.0);
        System.out.println(fly);
    }
}
