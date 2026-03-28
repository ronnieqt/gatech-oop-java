public class PondSol {
    public static void main(String[] args) {
        // Frog instances
        FrogSol peepo = new FrogSol("Peepo");
        FrogSol pepe = new FrogSol("Pepe", 10, 15);
        FrogSol peepaw = new FrogSol("Peepaw", 4.6);
        FrogSol anyName = new FrogSol("Any Name", 10, 10);

        // Fly instances
        FlySol oneMass = new FlySol(1, 3);
        FlySol sixMass = new FlySol(6);
        FlySol flyAny = new FlySol(10, 10);

        // step 1
        FrogSol.setSpecies("1331 Frogs");

        // step 2
        System.out.println(peepo);

        // step 3
        peepo.eat(sixMass);

        // step 4
        System.out.println(sixMass);

        // step 5
        peepo.grow(8);

        // step 6
        peepo.eat(sixMass);

        // step 7
        System.out.println(sixMass);

        // step 8
        System.out.println(peepo);

        // step 9
        System.out.println(anyName);

        // step 10
        peepaw.grow(4);

        // step 11
        System.out.println(peepaw);

        // step 12
        System.out.println(pepe);
    }
}
