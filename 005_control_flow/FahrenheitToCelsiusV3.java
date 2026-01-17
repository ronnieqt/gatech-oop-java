import java.util.Scanner;

/*
 * if (booleanExpression1) {
 *     statement;
 *     statement;
 *     statement;
 * }
 * else if (booleanExpression2) {
 *     statement;
 *     statement;
 *     statement;
 * }
 * else {
 *     statement;
 *     statement;
 *     statement;
 * }
 */

// In general, the relational and arithmetical operators take precedence over the logical operators. 
// AND takes precedence over OR.

public class FahrenheitToCelsiusV3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a Fahrenheit value: ");
        int fahrenheit = input.nextInt();
        System.out.print("Enter a day of the week: ");
        String day = input.next();
        double celsius = (5.0 / 9) * (fahrenheit - 32);
        System.out.println(day + " Fahrenheit: " + fahrenheit);
        System.out.printf("%s %.1f \n", day + " Celsius:", celsius);
        input.close();

        if (fahrenheit >= 70) {
            System.out.println("Yay! Go to park.");
        } else {
            System.out.println("Stay home where there's wi-fi and learn 1331 online");
        }
    }
}
