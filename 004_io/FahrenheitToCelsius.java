import java.util.Scanner;

/* A sequence of characters = tokens separated by delimiters (default delimiters = whitespace chars = ' ', '\t', '\n').
 * next(), nextInt(), nextDouble(): reads individual tokens and returns them as strings, ints, and doubles.
 * nextLine(): keeps pulling characters from the stream until it reaches '\n' (pulled and discarded).
 * All Scanner next methods (except nextLine) skip any leading whitespace when scanning for tokens.
 */

public class FahrenheitToCelsius 
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);  // 78\nFriday\n
        System.out.print("Enter a Fahrenheit value: ");
        int fahrenheit = input.nextInt();  // read 78
        input.nextLine();  // clean up \n at the end of unser input
        double celsius = (5.0 / 9) * (fahrenheit - 32);
        System.out.print("Enter a date (year month day): ");  // multiple tokens per line
        int year = input.nextInt();
        int month = input.nextInt();
        int day = input.nextInt();
        System.out.printf("%d-%d-%d Celsius: %.1f\n", year, month, day, celsius);
        input.close();
    }
}
