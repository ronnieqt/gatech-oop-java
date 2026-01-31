import java.util.Scanner;

public class CalculatorSol 
{
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in); // this will be the single scanner used throughout the entire program
        // it is very important to note that this won't be instantiated within a for loop as that would result in multiple intantiations
        
        String errorMessage = "Invalid input entered. Terminating..."; // storing error message in a variable allows for easier update if needed
        
        // print prompts to indicate request for user input
        System.out.println("List of operations: add subtract multiply divide alphabetize");
        System.out.println("Enter an operation:");
        String operation = input.next(); // makes the program wait for user input
        
        // switch statements are useful when there are discrete cases of values
        // in this case, this program accepts specifically 5 types of operations
        switch (operation.toLowerCase()) { // forcing inputs to lowercase allows us to consider all combinations of casing in the input at once
            // aDD -> add, ADD -> add, etc.
            case "add":
                System.out.println("Enter two integers:");
                // check if the inputs are valid
                if (input.hasNextInt()) {
                    int int1 = input.nextInt();
                    // will need to check second input as well before performing the operation
                    // note that there are two operands to check, so there needs to be a separate hasNextInt()/nextInt()
                    if (input.hasNextInt()) {
                        int int2 = input.nextInt();
                        System.out.println("Answer: " + (int1 + int2)); // order of operations is important here due to String concatenation
                    } else {
                        System.out.println(errorMessage);
                    }
                } else {
                    System.out.println(errorMessage);
                }
                break; // don't forget a break statement at the end of the case
            case "subtract":
                // note that input validation for add and subtract case are identical
                // consider: how can we reduce the repeated code?
                System.out.println("Enter two integers:");
                if (input.hasNextInt()) {
                    int int1 = input.nextInt();
                    if (input.hasNextInt()) {
                        int int2 = input.nextInt();
                        System.out.println("Answer: " + (int1 - int2));
                    } else {
                        System.out.println(errorMessage);
                    }
                } else {
                    System.out.println(errorMessage);
                }
                break;
            case "multiply":
                System.out.println("Enter two doubles:");
                if (input.hasNextDouble()) { // note we are now accepting double values instead of int
                    double double1 = input.nextDouble();
                    if (input.hasNextDouble()) {
                        double double2 = input.nextDouble();
                        // using printf for formatting
                        // this is where a lot of tests can fail by adding extra spaces, more digits than expected, etc.
                        System.out.printf("Answer: %.2f\n", double1 * double2);
                    } else {
                        System.out.println(errorMessage);
                    }
                } else {
                    System.out.println(errorMessage);
                }
                break;
            case "divide":
                System.out.println("Enter two doubles:");
                if (input.hasNextDouble()) {
                    double double1 = input.nextDouble();
                    if (input.hasNextDouble()) {
                        double double2 = input.nextDouble();
                        if (double2 != 0) {
                            // can only divide if the second input is not zero
                            System.out.printf("Answer: %.2f\n", double1 / double2);
                        } else {
                            System.out.println(errorMessage);
                        }
                    } else {
                        System.out.println(errorMessage);
                    }
                } else {
                    System.out.println(errorMessage);
                }
                break;
            case "alphabetize":
                System.out.println("Enter two words:");
                String word1 = input.next();
                String word2 = input.next();
                // during comparison, we check the lowercase versions of the two words
                // case insenstive comparison
                // note: can also use equalsIgnoreCase(). Try it!
                if (word1.toLowerCase().equals(word2.toLowerCase())) {
                    System.out.println("Answer: Chicken or Egg."); // notice exact format specified in assignment description
                } else if (word1.toLowerCase().compareTo(word2.toLowerCase()) < 0) {
                    System.out.println("Answer: " + word1 + " comes before " + word2 + " alphabetically.");
                    // note that printf can also be used here for formatting %s
                } else if (word1.toLowerCase().compareTo(word2.toLowerCase()) > 0) {
                    System.out.println("Answer: " + word2 + " comes before " + word1 + " alphabetically.");
                } else {
                    System.out.println(errorMessage);
                }
                break;
            default:
                // if user input does not match any of the operations, print the error message
                System.out.println(errorMessage);
                break;
        }
        input.close();
    }
}
