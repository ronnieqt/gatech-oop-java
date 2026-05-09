public class LinkedListDriver
{
    public static void main(String[] args)
    {
        LinkedList<Double> lst = new LinkedList<Double>();
        lst.add(0, 1.1);
        lst.add(1, 2.2);
        System.out.println(lst);
        try {
            lst.add(-1, 100.0);
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
        try {
            lst.add(3, 100.0);
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
        lst.add(3.3);
        lst.add(4.4);
        System.out.println(lst);
        System.out.println(lst.size());
        System.out.println(lst.contains(2));
        System.out.println(lst.get(1));
        try {
            lst.get(-1);
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
        try {
            lst.get(4);
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(lst.indexOf(3));
        System.out.println(lst.remove(3));
        System.out.println(lst);
        System.out.println(lst.remove(1));
        System.out.println(lst);
        System.out.println(lst.remove(0));
        System.out.println(lst);
        lst.add(10.1);
        lst.add(20.2);
        lst.add(30.3);
        System.out.println(lst);
        System.out.println(lst.remove(3.3));
        System.out.println(lst);
        System.out.println(lst.remove(3.3));
        System.out.println(lst.remove(20.2));
        System.out.println(lst);
        lst.add(100.1);
        lst.add(200.1);
        System.out.println(lst);
        System.out.println(lst.set(1, 300.3));
        System.out.println(lst);
        LinkedList<Double> lst1 = new LinkedList<Double>();
        LinkedList<Double> lst2 = new LinkedList<Double>();
        for (int i = 1; i <= 3; ++i) {
            lst1.add(2.0 * i);
            lst2.add(2.0 * i);
        }
        System.out.println(lst1.equals(lst2));
        lst2.set(1, 100.3);
        System.out.println(lst1);
        System.out.println(lst2);
        System.out.println(lst1.equals(lst2));
    }
}
