/* Syntax vs. Semantics
 * Syntax    : is the statement legal in Java?
 * Semantics : represents meaning of some code.
 */

/* Types of errors
 * 1. compiler error (typically because of syntax violations found in code)
 * 2. runtime error
 * 3. logical error
 */

public class BackToBasics
{
    public static void main(String[] args)
    {
        // major is a reference variable; object data is stored on the heap
        String major = new String("Computer Science");
        System.out.println(major);
    }
}
