/*
 * A method allows a programmer to group related statements together and give them a name.
 * One of the main reasons to do that is to modularize programs, or in this context, 
 *   break programs into small and manageable pieces (or methods) that represent specific and meaningful tasks.
 */

public class ArraySearchV2
{
    // The method signature has three parts: return type, name, and parameter list.
    public static boolean searchArray(String target, String[] array)
    {
        boolean result = false;
        for (String element : array) {
            if ((element != null) && element.equals(target)) {
                result = true;
                break;
            }
        }
        return result;
    }

    // method overloading
    // In Java, to overload a method, you simply need two or more versions that differ in 
    //   the types, order, and/or number of formal parameters.
    // More formally, a method is overloaded when there are two versions with the same name, but different signatures.
    // Note that return types are not involved in this definition.
    // In order to be considered overloaded, methods must have the same name and different parameter signatures.
    //   The parameters may differ by types, order (order matters), or number of terms.
    // The modifier (public, static) and return type do not matter for determining whether functions are overloaded.
    public static boolean searchArray(int target, int[] array)
    {
        boolean result = false;
        for (int element : array) {
            if (element == target) {
                result = true;
                break;
            }
        }
        return result;
    }
}
