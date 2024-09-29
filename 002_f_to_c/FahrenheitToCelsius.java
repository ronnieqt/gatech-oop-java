public class FahrenheitToCelsius
{
    public static void main(String[] args)
    {
        // variable declaration statements
        int satF;  // <type> <identifier>;
        int sunF;

        // variable assignment statement
        satF = 78;  // <identifier> = <expression>;
        sunF = 81;  // variable initialization

        double satC = (5.0/9) * (satF - 32);
        double sunC = (5.0/9) * (sunF - 32);

        System.out.println("Weekend Averages");
        System.out.println("Sat: " + satC);
        System.out.println("Sun: " + sunC);
    }
}

