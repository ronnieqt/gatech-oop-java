import java.util.InputMismatchException;
import java.util.Scanner;

public class FahrenheitToCelsiusExceptions
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a Fahrenheit value: ");
        try {
            // code that's dependent on statements that may throw an exception
            // should be in the same try block
            int fahrenheit = input.nextInt();
            double celsius = (5.0 / 9.0) * (fahrenheit - 32);
            System.out.printf("Fahrenheit : %d\n", fahrenheit);
            System.out.printf("Celsius    : %.1f\n", celsius);
        }
        catch (InputMismatchException | ArithmeticException e) {
            // combined catch blocks
            System.out.println("Sorry, that wasn't an int.");
            System.out.println("Please re-run the program again.");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        finally {
            // statements in the finally block will be executed
            // regardless of whether a try block throws an exception or not
            input.close();
        }
    }
}
