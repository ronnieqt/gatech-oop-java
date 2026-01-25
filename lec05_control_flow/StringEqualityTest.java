public class StringEqualityTest 
{
    public static void main(String[] args)
    {
        String x1 = "park";
        String x2 = "home";
        String x3 = "park";
        String x4 = new String("park");
        String x5 = new String("park");
        if (x1 == x2) {
            System.out.println("x1 and x2 are aliases");
        }
        if (x1 == x3) {
            System.out.println("x1 and x3 are aliases");
        }
        if (x4 == x5) {
            System.out.println("x4 and x5 are aliases");
        }
        if (x1.equals(x2)) {
            System.out.println("x1 and x2 have the same contents");
        }
        if (x4.equals(x5)) {
            System.out.println("x4 and x5 have the same contents");
        }

        String x6 = "park";
        String x7 = "p4rk";
        if (x6.compareTo(x7) > 0) {
            System.out.println("x6 is greater than x7");
        }
    }
}
