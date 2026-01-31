public class StringOperations 
{
    public static void main(String[] args)
    {
        // Section 2 - String Methods
        // 2.1 Create a new String object and assign it your name.
        String var1 = "Computer Science";
        System.out.println("Variable1: " + var1);
        // 2.2 Pick the first letter in your name, and replace it with ‘A’. 
        //     Then, replace the last letter in your name with ‘Z’.
        String var2 = "A" + var1.substring(1, var1.length() - 1) + "Z";
        System.out.println("Variable2: " + var2);
        // 2.3 Declare a new String and give it the value of some web address.
        String var3 = "www.gatech.edu";
        System.out.println("Variable3: " + var3);
        // 2.4 Create a substring of the variable that’s just the "name" section, 
        //     and concatenate the integer "1331" to the end.
        int idx_beg = var3.indexOf('.');
        int idx_end = var3.indexOf('.', idx_beg + 1);
        String var4 = var3.substring(idx_beg + 1, idx_end) + "1331";
        System.out.println("Variable4: " + var4);
    }
}
