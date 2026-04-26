import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Clinic
{
    private File patientFile;
    private int day;

    public Clinic(File file)
    {
        this.patientFile = file;
        this.day = 1;
    }

    public Clinic(String fileName)
    {
        this(new File(fileName));
    }

    public String nextDay(File f) throws FileNotFoundException
    {
        // read file f that contains: name, typeOfPet, timeOfAppointment
        String log = "";
        Scanner input = new Scanner(System.in); // user inputs
        Scanner fileScan = new Scanner(f);
        String line = null;
        String[] tokens = null;
        while (fileScan.hasNextLine()) {
            line = fileScan.nextLine();
            tokens = line.split(",");
            String name = tokens[0];
            String typeOfPet = tokens[1];
            String timeIn = tokens[3];
            // take in user input for health
            boolean success = false;
            double health = 0.0;
            while (!success) {
                try {
                    System.out.printf("Consultation for %s the %s at %s\n", name, typeOfPet, timeIn);
                    System.out.printf("What is the health of %s?\n", name);
                    health = input.nextDouble();
                    success = true;
                }
                catch (Exception e) {
                    input.nextLine();
                    System.out.println("Please enter a number.");
                }
            }
            // take user input for pain level
            success = false;
            int painLevel = 0;
            while (!success) {
                try {
                    System.out.printf("On a scale of 1 to 10, how much pain is %s in right now?\n", name);
                    painLevel = input.nextInt();
                    success = true;
                }
                catch (Exception e) {
                    input.nextLine();
                    System.out.println("Please enter an integer.");
                }
            }
            // create pet object
            Pet pet = null;
            if (typeOfPet.equals("Dog")) {
                double droolRate = Double.parseDouble(tokens[2]);
                pet = new Dog(name, health, painLevel, droolRate);
            }
            else if (typeOfPet.equals("Cat")) {
                int miceCaught = Integer.parseInt(tokens[2]);
                pet = new Cat(name, health, painLevel, miceCaught);
            }
            else {
                throw new InvalidPetException();
            }
            double initHealth = pet.getHealth();
            int initPainLevel = pet.getPainLevel();
            pet.speak();
            int treatmentTime = pet.treat();
            String timeOut = addTime(timeIn, treatmentTime);
            log += String.format("%s,%s,%s,Day %d,%s,%s,%s,%d\n",
                    name, typeOfPet, tokens[2], day, timeIn, timeOut,
                    String.valueOf(initHealth), initPainLevel);
        }
        day += 1;
        fileScan.close();
        input.close();
        return log.trim();
    }

    public String nextDay(String fileName) throws FileNotFoundException
    {
        return nextDay(new File(fileName));
    }

    public boolean addToFile(String patientInfo)
    {
        // Assume the vet will never see two different pets with the same name.
        Scanner fileScan = null;
        PrintWriter filePrint = null;
        String log = "";
        boolean success = false;
        try {
            String[] tokens = patientInfo.split(",");
            String name = tokens[0];
            fileScan = new Scanner(patientFile);
            boolean newPatient = true;
            while (fileScan.hasNextLine()) {
                String line = fileScan.nextLine();
                if (line.startsWith(name)) {
                    newPatient = false;
                    String appointmentInfo = "";
                    for (int i = 3; i < tokens.length; ++i) {
                        appointmentInfo += tokens[i];
                        if (i < tokens.length - 1) {
                            appointmentInfo += ",";
                        }
                    }
                    log += line + "," + appointmentInfo + "\n";
                }
                else {
                    log += line + "\n";
                }
            }
            if (newPatient) {
                log += patientInfo;
            }
            fileScan.close();
            filePrint = new PrintWriter(patientFile);
            filePrint.print(log);
            success = true;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        finally {
            if (fileScan != null) {
                fileScan.close();
            }
            if (filePrint != null) {
                filePrint.close();
            }
        }
        return success;
    }

    private String addTime(String timeIn, int treatmentTime)
    {
        int hh = Integer.parseInt(timeIn.substring(0, 2));
        int mm = Integer.parseInt(timeIn.substring(2));
        mm += treatmentTime;
        if (mm > 60) {
            hh += mm / 60;
            mm = mm % 60;
        }
        return String.format("%02d%02d", hh, mm);
    }

    public static void main(String[] args)
    {
        Clinic clinic = new Clinic("Patients.csv");
        String log = "";
        try {
            log = clinic.nextDay("Test.csv");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(log);
    }
}
