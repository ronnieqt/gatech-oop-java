public class InsectClientV2
{
    public static void main(String[] args) 
    {
        InsectV2 bug1 = new InsectV2(13, 31, 0);
        System.out.println(bug1.getWeight());
        System.out.println(bug1.getX());
        bug1.setX(-314);  // illegal input
        System.out.println(bug1.getX());
        bug1.setX(133);
        System.out.println(bug1.getX());
        System.out.println(bug1.getY());
        System.out.println(InsectV2.getPopulation());

        InsectV2 bug2 = new InsectV2(31);
        System.out.println(bug2.getWeight());
        System.out.println(bug2.getX());
        System.out.println(bug2.getY());
        System.out.println(bug2.toString());
        System.out.println(bug2);
        System.out.println(InsectV2.getPopulation());
    }
}
