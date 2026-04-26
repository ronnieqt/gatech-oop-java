import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * A class that represents a Clinic that takes in Dogs and Cats
 */
public class ClinicSol {
    private File patientFile;
    private int day;

    /**
     * Creates a Clinic with a patient record from a file
     *
     * @param file the patient files for the clinic
     */
    public ClinicSol(File file) {
        patientFile = file;
        day = 1;
    }

    /**
     * Creates a Clinic with a patient record from a file name
     *
     * @param fileName the name of the patient file as a String
     */
    public ClinicSol(String fileName) {
        // assume string includes filename extension .csv
        this(new File(fileName));
    }

    /**
     * Method that conducts appointments for the next day's patients.
     * Format of the delimited data for each patient is as follows:
     * name,species,stat,day,timeIn,timeOut,initialHealth,initialPainLevel
     *
     * @param f a file containing the appointments of the day
     * @return a String of delimited values and information for each appointment
     */
    public String nextDay(File f) throws FileNotFoundException {
        day++;
        // any thrown exceptions will be dealt with in addToFile
        String output = "";
        // do the same procedure for all pets and loop
        Scanner fileScan = new Scanner(f);
        Scanner input = new Scanner(System.in);

        String line = null;
        while (fileScan.hasNextLine()) {
            line = fileScan.nextLine();
            String[] pInfo = line.split(","); // creates a String array
            String name = pInfo[0];
            String species = pInfo[1];
            String stat = pInfo[2];
            String timeIn = pInfo[3];
            // contents: {name, species, stat, timeIn}

            if (!(species.equals("Dog") || species.equals("Cat"))) {
                throw new InvalidPetExceptionSol();
            }

            System.out.printf("Consultation for %s the %s at %s.\n",
                name, species, timeIn);
            double health = 0;
            int painLevel = 0;
            boolean validHealth = false;
            boolean validPain = false;
            while (!validHealth) {
                System.out.printf("What is the health of %s?\n", name);
                if (input.hasNextDouble()) {
                    health = input.nextDouble();
                    validHealth = true;
                } else {
                    // discards the invalid input
                    input.nextLine();
                    System.out.println("Please enter a number");
                }
            }

            while (!validPain) {
                System.out.printf("On a scale of 1 to 10, how much pain is %s "
                                + "in right now?\n", name);
                if (input.hasNextInt()) {
                    painLevel = input.nextInt();
                    validPain = true;
                } else {
                    input.nextLine();
                    System.out.println("Please enter a number");
                }
            }

            // instantiate the appropriate pet object with new info
            PetSol petPatient;
            switch (species) {
                // Depending on the pet we set the variable or throw the exception
                case "Dog":
                    petPatient = new DogSol(name, health, painLevel, Double.parseDouble(stat));
                    break;
                case "Cat":
                    petPatient = new CatSol(name, health, painLevel, Integer.parseInt(stat));
                    break;
                default:
                    throw new InvalidPetExceptionSol();
            }
            // correct it just in case a value that is too high or low was entered
            health = petPatient.getHealth();
            painLevel = petPatient.getPainLevel();
            petPatient.speak();
            int treatmentTime = petPatient.treat();
            String timeOut = addTime(timeIn, treatmentTime);
            output += String.format("%s,%s,%s,Day %d,%s,%s,%s,%d\n", name, species, stat,
                    day, timeIn, timeOut, String.valueOf(health), painLevel);
        }
        fileScan.close();
        input.close();
        return output.trim();
    }

    /**
     * Method that conducts appointments for the next day's patients
     * Format of the delimited data for each patient is as follows:
     * name,species,stat,day,timeIn,timeOut,initialHealth,initialPainLevel
     *
     * @param fileName the file name of a file containing the appointments of the day
     * @return a String of delimited values and information for each appointment
     */
    public String nextDay(String fileName) throws FileNotFoundException {
        return nextDay(new File(fileName));
    }

    /**
     * Writes the info from a String representing an appointment to patientFile
     * If the patient already exists, only the appointment info will be recorded
     *
     * @param patientInfo a String representing a single appointment
     * @return a boolean for whether the appointment info was successfully written
     */
    public boolean addToFile(String patientInfo) {
        // we declare and set the variables that handle files here, outside the try block
        Scanner fileScan = null;
        PrintWriter filePrint = null;
        String stringOutput = "";

        try {
            // we set the values of variables that handle files here in the try block
            // the PrintWriter will be set later as we cannot read and write at the same time
            fileScan = new Scanner(patientFile);

            // find the patient name
            boolean newPatient = true;
            int firstDelimiter = patientInfo.indexOf(",");
            String name = patientInfo.substring(0, firstDelimiter);

            while (fileScan.hasNextLine()) {
                String line = fileScan.nextLine();
                if (line.startsWith(name)) {
                    newPatient = false;
                    // add only the appointment info
                    // could use patientInfo.split(",") to get a String array
                    int currentDelim = firstDelimiter;
                    for (int i = 2; i <= 3; i++) {
                        // first loop gives index of second demilimter
                        int nextDelim = patientInfo.indexOf(",", currentDelim + 1);
                        currentDelim = nextDelim;
                    }
                    // value of currentDelim is index of the third delimiter
                    line += patientInfo.substring(currentDelim);
                }
                stringOutput += (line + "\n");
            }
            // conditional if a new line for new patient is needed
            if (newPatient) {
                stringOutput += patientInfo;
            }
            // we can't read and write file at the same time, so we close the Scanner
            // and only then open the PrintWriter
            fileScan.close();
            filePrint = new PrintWriter(patientFile);
            filePrint.print(stringOutput);
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            // we close the variables that handle files here, in the finally block
            // this executes even if the code returns, the returned value will be
            // maintained unless it changes here
            if (fileScan != null) {
                fileScan.close();
            }
            if (filePrint != null) {
                filePrint.close();
            }
        }
    }

    private static String addTime(String timeIn, int treatmentTime) {
        // remember: when using substring, the ending index is exclusive
        int hours = Integer.parseInt(timeIn.substring(0, 2));
        int minutes = Integer.parseInt(timeIn.substring(2));
        int hourOut = hours + (int) ((minutes + treatmentTime) / 60);
        int minOut = (minutes + treatmentTime) % 60;
        // pad zeros if needed
        String output = "";
        output += (hourOut < 10) ? ("0" + hourOut) : hourOut;
        output += (minOut < 10) ? ("0" + minOut) : minOut;
        return output;
    }
}
