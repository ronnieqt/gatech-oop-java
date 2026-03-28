public class FlySol {

    // instance variables
    private double mass;
    private double speed;

    private static final int DEFAULT_MASS = 5;
    private static final int DEFAULT_SPEED = 10;

    // constructors
    public FlySol() {
        // passing default values to next most specific constructor
        this(DEFAULT_MASS);
    }

    public FlySol(double mass) {
        // passing on to 2-arg
        this(mass, DEFAULT_SPEED);
    }

    public FlySol(double mass, double speed) {
        this.mass = mass;
        this.speed = speed;
    }

    // getters
    public double getMass() {
        return mass;
    }

    public double getSpeed() {
        return speed;
    }

    // setters
    public void setMass(double mass) {
        if (mass >= 0) {
            this.mass = mass;
        }
    }

    public void setSpeed(double speed) {
        if (speed > 0) {
            this.speed = speed;
        }
    }

    // instance methods

    public void grow(int addMass) {
        // we do it in one go instead of doing interative approach, like we do in Frog
        if (mass >= 20) {
            speed -= 0.5 * addMass; // we decrease by half the number of months, or 0.5 per month
        } else if (mass + addMass < 20) {
            speed += addMass; // we increase by the number of months
        } else {
            // We split the months into before 20 and after 20 and do both operations
            int before20 = 20 - (int) mass;
            int after20 = (int) mass + addMass - 20;
            speed += before20 - 0.5 * after20;
        }
        mass += addMass; // we add the mass
    }

    public boolean isDead() {
        return (mass == 0);
    }

    public String toString() {
        if (mass == 0) {
            // recall discussion of String.format() in the lesson on input and output
            return String.format("I'm dead, but I used to be a fly with a speed of %.2f.", speed);
        } else {
            return String.format("I'm a speedy fly with %.2f speed and %.2f mass.", speed, mass);
        }
    }

}
