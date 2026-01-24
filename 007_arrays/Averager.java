public class Averager 
{
    public static void main(String[] args)
    {
        // double[] weekHighs = new double[7];  // defaults: 0, 0.0, null
        double[] weekHighs = { 80, 70, 75, 69, 72, 74, 90 };
        double highsSum = 0.0;
        // for (int i = 0; i < weekHighs.length; ++i) {
        //     highsSum += weekHighs[i];
        // }
        for (double dayHigh : weekHighs) {
            highsSum += dayHigh;
        }
        double avgHighs = highsSum / weekHighs.length;
        System.out.println("Average is: " + avgHighs);
    }
}
