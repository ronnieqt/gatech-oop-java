/*
 * while (booleanExpression) {
 *     bodyStatement1;
 *     bodyStatement2;
 *     ...
 * }
 *
 * do {
 *     bodyStatement1;
 *     bodyStatement2;
 *     ...
 * } while (booleanExpression)
 * 
 * for (initStatement; condition; updateStatement) {
 *     bodyStatement1;
 *     bodyStatement2;
 *     ...
 * }
 */

public class HelloWorldLoop 
{
    public static void main(String[] args) 
    {
        int i = 0;
        while (i < 10) {
            System.out.println("Hello world");
            i++;
        }

        System.out.println("-----------");

        for (int j = 0; j < 10; ++j) {
            System.out.println("Hello world");
        }
    }
}
