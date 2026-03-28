import java.util.Arrays;

public class Sorting 
{
    // ========================================================

    // selection sort
    public static void selectionSort(Comparable[] list) {
        int minIdx = 0;
        for (int unsortedStartIdx = 0; unsortedStartIdx < list.length - 1; ++unsortedStartIdx) {
            minIdx = unsortedStartIdx;
            for (int i = unsortedStartIdx + 1; i < list.length; ++i) {
                if (list[i].compareTo(list[minIdx]) < 0) {
                    minIdx = i;
                }
            }
            swap(list, unsortedStartIdx, minIdx);
        }
    }

    // ========================================================

    private static void swap(Comparable[] xs, int i, int j) {
        Comparable tmp = xs[i];
        xs[i] = xs[j];
        xs[j] = tmp;
    }

    // ========================================================

    public static void main(String[] args) {
        Integer[] xs = { 3, 9, 6, 1, 2 };
        System.out.println("Before: " + Arrays.toString(xs));
        selectionSort(xs);
        System.out.println(" After: " + Arrays.toString(xs));
    }

    // ========================================================
}