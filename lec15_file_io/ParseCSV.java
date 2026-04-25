import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ParseCSV
{
    public static void main(String[] args)
    {
        File fileIn = new File("SortedWolves.csv");
        Scanner fileScan = null;
        String[] tokens = null;
        double[] allWeights = new double[10];
        int index = 0;
        try {
            // fileScan = new Scanner(fileIn);
            // String line = null;
            // while (fileScan.hasNextLine()) {
            //     line = fileScan.nextLine();
            //     tokens = line.split(",");
            //     allWeights[index] = Double.parseDouble(tokens[1]);
            //     System.out.println(allWeights[index]);
            //     index++;
            // }
            fileScan = new Scanner(fileIn);
            String line = null;
            while (fileScan.hasNextLine()) {
                line = fileScan.nextLine();
                Scanner wolfScan = new Scanner(line);
                wolfScan.useDelimiter(",");
                wolfScan.nextInt();  //consume unused rank token
                allWeights[index] = wolfScan.nextDouble();
                System.out.println(allWeights[index]);
                index++;
            }
        }
        catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        finally {
            if (fileScan != null) {
                fileScan.close();
            }
        }
    }
}
