/*
 * Call stack visualization for recursive repeatString method.
 *
 * The stack grows downward with the most recent call on top.
 * Each frame shows the method invocation with its arguments.
 *
 *   +--------------------------------+
 *   |  repeatString("I <3 Java", 0)  |  <- top of stack
 *   +--------------------------------+
 *   |  repeatString("I <3 Java", 1)  |
 *   +--------------------------------+
 *   |  repeatString("I <3 Java", 2)  |
 *   +--------------------------------+
 *   |  repeatString("I <3 Java", 3)  |
 *   +--------------------------------+
 *   |  main(null)                    |  <- bottom of stack
 *   +--------------------------------+
 */

public class Repeater
{
    public static void repeatString(String toRepeat, int times)
    {
        if (times <= 0) {
            return;
        }
        else {
            System.out.println(toRepeat);
            repeatString(toRepeat, times - 1);
        }
    }

    public static void main(String[] args)
    {
        repeatString("I <3 Java", 3);
    }
}
