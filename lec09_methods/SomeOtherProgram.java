public class SomeOtherProgram 
{
    public static void main(String args[]) 
    {
        String[] concepts = { "abstraction", "polymorphism", "inheritance", "encapsulation" };
        System.out.println(ArraySearchV2.searchArray("polymorphism", concepts));
        System.out.println(ArraySearchV2.searchArray("inheritance", concepts));

        int[] weekHighs = {80, 70, 75, 69, 72, 74, 90};
        System.out.println(ArraySearchV2.searchArray(90, weekHighs));
        System.out.println(ArraySearchV2.searchArray(85, weekHighs));
    }
}
