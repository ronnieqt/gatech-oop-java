public class InsectClient
{
    public static void main(String[] args) 
    {
        Insect bug0 = new Insect(10, 100, 90);
        bug0.eat(10);
        bug0.move(1, 10);

        System.out.println(Insect.produceRandomeFact());

        Insect bug1 = new Insect(13, 31, 0);
        System.out.println(bug1.getWeight());
        System.out.println(bug1.getX());
        bug1.setX(-314);  // illegal input
        System.out.println(bug1.getX());
        bug1.setX(133);
        System.out.println(bug1.getX());
        System.out.println(bug1.getY());
        System.out.println(Insect.getPopulation());

        Insect bug2 = new Insect(31);
        System.out.println(bug2.getWeight());
        System.out.println(bug2.getX());
        System.out.println(bug2.getY());
        System.out.println(bug2.toString());
        System.out.println(bug2);
        System.out.println(Insect.getPopulation());
    }
}

