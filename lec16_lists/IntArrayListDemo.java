import java.util.ArrayList;

public class IntArrayListDemo
{
    public static void main(String[] args)
    {
        ArrayList<Integer> scores = new ArrayList<>(); // autoboxing
        // Autoboxing converts primitive types to objects with the help of wrapper classes.
        scores.add(90);
        scores.add(95);
        scores.add(110);
        scores.add(99);
        scores.add(105);
        System.out.println(scores.toString());

        int sum = 0;
        for (Integer score : scores) { // for each loop works here
            sum += score; // autounboxing
        }
        System.out.println("Total points: " + sum);
    }
}