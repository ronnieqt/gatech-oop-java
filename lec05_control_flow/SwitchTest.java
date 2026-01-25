import java.util.Scanner;

/*
 * switch (expression) {
 *     case value1:
 *         statement(s)
 *         break;
 *     case value2:
 *         statement(s)
 *         break;
 *     default:
 *         statement(s)
 * }
 */

public class SwitchTest 
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter your selection: ");
        int selection = input.nextInt();
        input.close();
        String menuOption;
        switch (selection) {
            case 0:
                menuOption = "Operator";
                break;
            case 1:
                menuOption = "Customer Service";
                break;
            case 2:
                menuOption = "Technical Support";
                break;
            default:
                menuOption = "Retry Selection";
                break;
        }
        System.out.println(menuOption);
    }
}
