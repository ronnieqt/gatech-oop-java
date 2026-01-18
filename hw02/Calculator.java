import java.util.Scanner;

public class Calculator 
{
    public static void main(String[] args)
    {
        // Print out the list of operations for the user.
        System.out.println("List of operations: add subtract multiply divide alphabetize");
        // Prompt the user to enter an operation (case-insensitive).
        Scanner inputs = new Scanner(System.in);
        System.out.println("Enter an operation:");
        String operation = inputs.next().toLowerCase();
        String answer = "";
        boolean validInputs = true;
        // Perform the chosen operation and print the correct output.
        switch (operation) {
            case "add":
                try {
                    System.out.println("Enter two integers:");
                    int x1 = inputs.nextInt();
                    int x2 = inputs.nextInt();
                    answer = String.format("%d", x1 + x2);
                }
                catch (Exception e) {
                    validInputs = false;
                }
                break;
            case "subtract":
                try {
                    System.out.println("Enter two integers:");
                    int x1 = inputs.nextInt();
                    int x2 = inputs.nextInt();
                    answer = String.format("%d", x1 - x2);
                }
                catch (Exception e) {
                    validInputs = false;
                }
                break;
            case "multiply":
                try {
                    System.out.println("Enter two doubles:");
                    double x1 = inputs.nextDouble();
                    double x2 = inputs.nextDouble();
                    answer = String.format("%.2f", x1 * x2);
                }
                catch (Exception e) {
                    validInputs = false;
                }
                break;
            case "divide":
                try {
                    System.out.println("Enter two doubles:");
                    double x1 = inputs.nextDouble();
                    double x2 = inputs.nextDouble();
                    if (x2 == 0.0) {
                        validInputs = false;
                    }
                    else {
                        answer = String.format("%.2f", x1 / x2);
                    }
                }
                catch (Exception e) {
                    validInputs = false;
                }
                break;
            case "alphabetize":
                System.out.println("Enter two words:");
                String word1 = inputs.next();
                String word2 = inputs.next();
                if (word1.toLowerCase().compareTo(word2.toLowerCase()) < 0) {
                    answer = String.format("%s comes before %s alphabetically.", word1, word2);
                }
                else if (word1.toLowerCase().compareTo(word2.toLowerCase()) > 0) {
                    answer = String.format("%s comes before %s alphabetically.", word2, word1);
                }
                else {
                    answer = "Chicken or Egg.";
                }
                break;
            default:
                validInputs = false;
                break;
        }
        inputs.close();
        // The program should terminate gracefully after the result of the operation is printed.
        if (validInputs) {
            System.out.printf("Answer: %s\n", answer);
        }
        else {
            System.out.println("Invalid input entered. Terminating...");
        }
    }
}
