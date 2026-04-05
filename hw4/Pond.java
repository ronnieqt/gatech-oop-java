public class Pond 
{
    public static void main(String[] args) 
    {
        // Create at least 4 Frog objects
        Frog peepo = new Frog("Peepo");
        Frog pepe = new Frog("Pepe", 10, 15.0);
        Frog peepaw = new Frog("Peepaw", 4.6, 5.0);
        Frog myfrog = new Frog("MyFrog", 3, 4.0);
        // Create at least 3 Fly objects
        // Fly fly1 = new Fly(1.0, 3.0);
        Fly fly2 = new Fly(6.0);
        // Fly fly3 = new Fly();
        // Set the species of any Frog to "1331 Frogs"
        Frog.setSpecies("1331 Frogs");
        // Print out on a new line the description of the Frog named Peepo
        System.out.println(peepo);
        // Have the Frog named Peepo attempt to eat the Fly with a mass of 6
        peepo.eat(fly2);
        // Print out on a new line the description of the Fly with a mass of 6
        System.out.println(fly2);
        // Have the Frog named Peepo grow by 8 months
        peepo.grow(8);
        // Have the Frog named Peepo attempt to eat the Fly with a mass of 6
        peepo.eat(fly2);
        // Print out on a new line the description of the Fly with a mass of 6
        System.out.println(fly2);
        // Print out on a new line the description of the Frog named Peepo
        System.out.println(peepo);
        // Print out on a new line the description of your own Frog
        System.out.println(myfrog);
        // Have the Frog named Peepaw grow by 4 months
        peepaw.grow(4);
        // Print out on a new line the description of the Frog named Peepaw
        System.out.println(peepaw);
        // Print out on a new line the description of the Frog named Pepe
        System.out.println(pepe);
    }
}
