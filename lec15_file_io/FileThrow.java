import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// Two types of exceptions: unchecked (e.g. RuntimeException) and checked (e.g. FileNotFoundException)
// - We do not need to catch or specify (with a `throws` clause) in the code; these exceptions can occur in many places.
// - For checked exceptions, we must either catch or specify (like below).

public class FileThrow
{
    public static void main(String[] args) throws FileNotFoundException
    {
        String fileName = args[0];
        String word = args[1];

        File file = new File(fileName);
        Scanner scan = null;

        scan = new Scanner(file);
        int lineCount = 0;
        System.out.printf("Lines in %s containing %s:\n", fileName, word);

        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            if (line.contains(word)) {
                System.out.println(lineCount + ": " + line);
            }
            lineCount++;
        }
        scan.close();
    }
}
