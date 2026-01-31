public class PrimitiveOperations 
{
    public static void main(String[] args)
    {
        // Section 1: Primitive Operations
        // 1.1 Declare and initialize two variables.
        int var1 = 42;
        double var2 = 2026.01;
        System.out.println("Variable1: " + var1);
        System.out.println("Variable2: " + var2);
        // 1.2 Multiply these variables together, and assign the outcome to a new variable.
        double var3 = var1 * var2;
        System.out.println("Var1*Var2: " + var3);
        // 1.3 Use casting to convert the integer from the first step to a floating point value.
        double var4 = (double) var1;
        System.out.println("Variable4: " + var4);
        // 1.4 Use casting to convert the floating point value from the first step to an integer type.
        long var5 = (long) var2;
        System.out.println("Variable5: " + var5);
        // 1.5 Declare a char variable, and assign an uppercase letter to it.
        char var6 = 'A';
        System.out.println("Variable6: " + var6);
        // 1.6 Using a numerical operation, change the letter to the same letter, but in lowercase.
        char var7 = (char) (var6 + 32);
        System.out.println("Variable7: " + var7);
    }
}
