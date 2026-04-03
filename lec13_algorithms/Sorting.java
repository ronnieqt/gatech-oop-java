import java.util.Arrays;
import java.util.Random;

public class Sorting 
{
    // ========================================================
    // selection sort O(n^2)

    public static void selectionSort(Comparable[] list) 
    {
        int minIdx = 0;
        // Sometimes, we can deduce the growth rate of an algorithm 
        //   by looking for certain attributes in its implementation.
        // For example, whenever the bulk of an algorithm 
        //   is performed in a loop whose limits depend on the size of input (i.e., n), 
        //   we can expect a worst-case linear runtime growth as input size increases. 
        // For selection sort, there are 2 such loops; therefore, the growth rate is quadratic.
        for (int unsortedStartIdx = 0; unsortedStartIdx < list.length - 1; ++unsortedStartIdx) {
            minIdx = unsortedStartIdx;
            for (int i = unsortedStartIdx + 1; i < list.length; ++i) {
                if (list[i].compareTo(list[minIdx]) < 0) {
                    minIdx = i;
                }
            }
            if (minIdx != unsortedStartIdx) {
                swap(list, unsortedStartIdx, minIdx);
            }
        }
    }

    private static void swap(Comparable[] xs, int i, int j) 
    {
        Comparable tmp = xs[i];
        xs[i] = xs[j];
        xs[j] = tmp;
    }

    // ========================================================
    // merge sort O(nlgn) (linearithmic = linear and logarithmic)

    public static void mergeSort(int[] xs, int begIdx, int endIdx)
    {
        if (begIdx >= endIdx) {
            return;
        }
        int midIdx = (int) (begIdx + endIdx) / 2;
        mergeSort(xs, begIdx, midIdx);
        mergeSort(xs, midIdx + 1, endIdx);
        merge(xs, begIdx, midIdx + 1, endIdx);
    }

    private static void merge(int[] xs, int lBegIdx, int rBegIdx, int endIdx)
    {
        int ln = rBegIdx - lBegIdx;
        int rn = endIdx - rBegIdx + 1;
        int[] lxs = new int[ln];
        int[] rxs = new int[rn];
        for (int i = 0; i < ln; ++i) {
            lxs[i] = xs[lBegIdx + i];
        }
        for (int i = 0; i < rn; ++i) {
            rxs[i] = xs[rBegIdx + i];
        }
        int i = 0, j = 0, k = lBegIdx;
        while (i < ln && j < rn) {
            if (lxs[i] < rxs[j]) {
                xs[k] = lxs[i];
                ++i;
            }
            else {
                xs[k] = rxs[j];
                ++j;
            }
            ++k;
        }
        while (i < ln) {
            xs[k] = lxs[i];
            ++i;
            ++k;
        }
        while (j < rn) {
            xs[k] = rxs[j];
            ++j;
            ++k;
        }
    }

    // ========================================================
    // insertion sort O(n^2)

    public static void insertionSort(int[] xs)
    {
        for (int unsortedBegIdx = 1; unsortedBegIdx < xs.length; ++unsortedBegIdx) {
            int currValue = xs[unsortedBegIdx];
            int i = unsortedBegIdx - 1;  // sortedEndIdx
            // xs[i+1] is free to change
            while (i >= 0) {
                if (xs[i] > currValue) {
                    xs[i + 1] = xs[i];
                }
                else {
                    break;  // xs[i] <= currValue
                }
                --i;
            }
            xs[i + 1] = currValue;
        }
    }

    // ========================================================
    // utils

    private static Integer[] randGen(int n, int cap, long seed)
    {
        Random rand = new Random(seed);
        Integer[] numbers = new Integer[n];
        for (int i = 0; i < n; ++i) {
            numbers[i] = rand.nextInt(cap);
        }
        return numbers;
    }

    // ========================================================
    // entry point

    public static void main(String[] args) 
    {
        Integer[] xs1 = randGen(8, 20, 42);
        System.out.println("B: " + Arrays.toString(xs1));
        selectionSort(xs1);
        System.out.println("A: " + Arrays.toString(xs1));

        Integer[] xs2 = randGen(10000, 100000, 42);
        long beg = System.nanoTime();
        selectionSort(xs2);
        long end = System.nanoTime();
        System.out.printf("Elapsed time in ms: %.2f\n", 1e-6 * (end - beg));

        int[] xs3 = { 3, 5, 7, 8, 2, 4, 6 };
        System.out.println("B: " + Arrays.toString(xs3));
        merge(xs3, 0, 4, 6);
        System.out.println("A: " + Arrays.toString(xs3));

        int[] xs4 = { 4, 3, 7, 2, 6, 5, 8 };
        System.out.println("B: " + Arrays.toString(xs4));
        mergeSort(xs4, 0, 6);
        System.out.println("A: " + Arrays.toString(xs4));

        int[] xs5 = { 5, 4, 3, 2, 1 };
        System.out.println("B: " + Arrays.toString(xs5));
        insertionSort(xs5);
        System.out.println("A: " + Arrays.toString(xs5));
    }

    // ========================================================
}