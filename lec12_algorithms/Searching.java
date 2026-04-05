import java.util.Random;

public class Searching 
{
    // ======================================================== 
    // linear search O(n)

    public static int linearSearch(Comparable x, Comparable[] xs)
    {
        for (int i = 0; i < xs.length; ++i) {
            if (xs[i] == x) {
                return i;
            }
        }
        return -1;
    }

    // ======================================================== 
    // binary search O(lgn)

    public static int binarySearch(Comparable x, Comparable[] xs)
    {
        int beg = 0, end = xs.length - 1, mid = -1;
        while (beg <= end) {
            mid = (beg + end) / 2;
            if (xs[mid].compareTo(x) == 0) {
                return mid;
            }
            else if (xs[mid].compareTo(x) < 0) {
                beg = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        return -1;
    }

    // ======================================================== 
    // main

    public static void main(String[] args) 
    {
        Integer[] numbers = new Integer[100000];
        Random rand = new Random(42);
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt(100000);
        }
        System.out.println("Linear Search: " + linearSearch(56, numbers));

        Integer[] xs1 = { 2, 3, 5, 6, 7, 10, 11, 13 };
        System.out.println("Binary Search: " + binarySearch(10, xs1));
    }

    // ======================================================== 
}
