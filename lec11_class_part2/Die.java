import java.util.Random;

/* What are the classes that we'll need for this game?
 * An important tip for answering that question is to look at the nouns and verbs in the problem description.
 * Respectively, these typically represent the classes and methods to include in a solution.
 */

public class Die 
{
    public static final int SIDES = 6;
    private int faceValue;
    private Random rand;

    public Die()
    {
        faceValue = 1;
        rand = new Random();
    }

    public int getFaceValue()
    {
        return faceValue;
    }

    @Override
    public String toString() 
    {
        return String.format("Die with face value: %d", faceValue);
    }

    public int roll()
    {
        faceValue = 1 + rand.nextInt(SIDES);
        return faceValue;
    }

    public static void main(String[] args) 
    {
        Die die1 = new Die();
        System.out.println(die1);
        die1.roll();
        System.out.println(die1);
    }
}
