public class FrogSol {

    // instance variables
    private String name;
    private int age;
    private double tongueSpeed;
    private boolean isFroglet;

    // class variable
    private static String species = "Rare Pepe";

    // constants
    private static final int DEFAULT_AGE = 5;
    private static final double DEFAULT_TONGUE = 5;

    public FrogSol(String name) {
        // through constructor chaining, we pass specified parameters and default values to appropriate constructor
        this(name, DEFAULT_AGE, DEFAULT_TONGUE);
    }

    public FrogSol(String name, double ageInYears) {
        // we make the calculation from years to months inside the this
        // this is required because constructor chaining can only happen as the first statement of a constructor
        this(name, (int) (12 * ageInYears), DEFAULT_TONGUE);
    }

    public FrogSol(String name, int age, double tongueSpeed) {
        this.name = name;
        this.age = age;
        this.tongueSpeed = tongueSpeed;
        this.isFroglet = (age > 1) && (age < 7); // isFroglet determined through age and is calculated within the constructor
    }

    public void grow(int addMonths) {
        // loop to implement aging
        for (int i = 1; i <= addMonths; i++) {
            age += 1;
            if (age <= 12) {
                tongueSpeed += 1;
            } else if (age <= 30) {
                //
            } else {
                tongueSpeed -= 1;
            }
        }
        // cannot decrease tongueSpeed to less than 5
        // because of ternary operator, tongueSpeed is maintained when higher than 5, and set to 5 when it's lower
        tongueSpeed = (tongueSpeed < 5) ? 5 : tongueSpeed;

        // remember to update isFroglet
        isFroglet = (age > 1) && (age < 7);
    }

    public void grow() {
        // we do the growing by 1 month, avoiding duplicate code
        grow(1);
    }

    /**
     * This method allows the frog to eat a fly
     *
     * @param prey a fly the frog is attempting to eat
     */
    public void eat(FlySol prey) {
        if (!prey.isDead()) {
            if (tongueSpeed > prey.getSpeed()) {
                // fly is caught
                if (prey.getMass() >= (age * 0.5)) {
                    grow();
                }
                prey.setMass(0);
            } else {
                // fly is not caught
                prey.grow(1);
            }
        }
    }

    /**
     * @return a description of the frog or froglet with name, age, and tongue speed
     */
    public String toString() {
        if (isFroglet) {
            return String.format("My name is %s and I'm a rare froglet! I'm %d months old"
                                 + " and my tongue has a speed of %.2f.", name, age, tongueSpeed);
        } else {
            return String.format("My name is %s and I'm a rare frog. I'm %d months old"
                                 + " and my tongue has a speed of %.2f.", name, age, tongueSpeed);
        }
    }

    /**
     * @return the name of the frog species
     */
    public static String getSpecies() {
        return species;
    }

    /**
     * This method changes the name of the species of all Frogs
     *
     * @param newSpecies the new name of the species
     */
    public static void setSpecies(String newSpecies) {
        species = newSpecies;
    }

}
