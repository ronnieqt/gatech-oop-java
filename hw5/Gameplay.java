public class Gameplay
{
    public static void main(String[] args)
    {
        BlueAstronaut blueBob = new BlueAstronaut("Bob", 20, 6, 30);
        BlueAstronaut blueHeath = new BlueAstronaut("Heath", 30, 3, 21);
        BlueAstronaut blueAlbert = new BlueAstronaut("Albert", 44, 2, 0);
        BlueAstronaut blueAngel = new BlueAstronaut("Angel", 0, 1, 0);

        RedAstronaut redLiam = new RedAstronaut("Liam", 19, "experienced");
        RedAstronaut redSusp = new RedAstronaut("Suspicious Person", 100, "expert");

        System.out.println("====== init");
        for (Player p : Player.getPlayers()) {
            System.out.println(p);
        }

        System.out.println("====== step 1");
        redLiam.sabotage(blueBob);
        System.out.println("Bob: " + blueBob.toString());

        System.out.println("====== step 2");
        System.out.println("Liam: " + redLiam.toString());
        System.out.println("Suspicious Person: " + redSusp.toString());
        redLiam.freeze(redSusp);
        System.out.println("Liam: " + redLiam.toString());
        System.out.println("Suspicious Person: " + redSusp.toString());

        System.out.println("====== step 3");
        redLiam.freeze(blueAlbert);
        System.out.println("Liam: " + redLiam.toString());
        System.out.println("Albert: " + blueAlbert.toString());

        System.out.println("====== step 4");
        for (Player p : Player.getPlayers()) {
            System.out.println(p);
        }
        blueAlbert.emergencyMeeting();
        for (Player p : Player.getPlayers()) {
            System.out.println(p);
        }

        System.out.println("====== step 5");
        redSusp.emergencyMeeting();
        for (Player p : Player.getPlayers()) {
            System.out.println(p);
        }

        System.out.println("====== step 6");
        blueBob.emergencyMeeting();
        for (Player p : Player.getPlayers()) {
            System.out.println(p);
        }

        System.out.println("====== step 7");
        System.out.println("Heath: " + blueHeath.toString());
        blueHeath.completeTask();
        System.out.println("Heath: " + blueHeath.toString());

        System.out.println("====== step 8");
        System.out.println("Heath: " + blueHeath.toString());
        blueHeath.completeTask();
        System.out.println("Heath: " + blueHeath.toString());

        System.out.println("====== step 9");
        System.out.println("Heath: " + blueHeath.toString());
        blueHeath.completeTask();
        System.out.println("Heath: " + blueHeath.toString());

        System.out.println("====== step 10");
        System.out.println("Liam: " + redLiam.toString());
        System.out.println("Angel: " + blueAngel.toString());
        redLiam.freeze(blueAngel);
        System.out.println("Liam: " + redLiam.toString());
        System.out.println("Angel: " + blueAngel.toString());

        System.out.println("====== step 11");
        System.out.println("Bob: " + blueBob.toString());
        redLiam.sabotage(blueBob);
        System.out.println("Bob: " + blueBob.toString());
        redLiam.sabotage(blueBob);
        System.out.println("Bob: " + blueBob.toString());

        System.out.println("====== step 12");
        redLiam.freeze(blueBob);
        System.out.println("Bob: " + blueBob.toString());

        // System.out.println("====== step 13");
        // blueAngel.emergencyMeeting();
        // System.out.println("Liam: " + redLiam.toString());

        System.out.println("====== step 14");
        System.out.println("Heath: " + blueHeath.toString());
        for (int i = 0; i < 5; ++i) {
            redLiam.sabotage(blueHeath);
            System.out.println("Heath: " + blueHeath.toString());
        }

        System.out.println("====== step 15");
        redLiam.freeze(blueHeath);
        System.out.println("Heath: " + blueHeath.toString());
    }
}
