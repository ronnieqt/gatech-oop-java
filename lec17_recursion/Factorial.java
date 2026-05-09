/* Factorial
 * In order for a recursive method to properly complete,
 * it needs to have three important components:
 * 1. a base case (also called terminating condition) that returns without making a recursive call
 * 2. reduction step that moves the direction of the recursive calls towards the terminating condition
 * 3. recursive call (otherwise it wouldn’t be recursion!)
 */

public class Factorial
{
    public static int factorial(int n)
    {
        if (n >= 0) {
            return factorialAux(n);
        }
        else {
            throw new IllegalArgumentException("Non-negative input required");
        }
    }

    private static int factorialAux(int n)
    {
        if (n == 0) {
            return 1;
        }
        else {
            return n * factorialAux(n - 1);
        }
    }

    public static void main(String[] args)
    {
        System.out.println(factorial(4));
    }
}
