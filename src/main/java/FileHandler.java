import java.io.File;
import java.io.PrintStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

class FileHandler {
    private File file = new File("Delfin.csv");
    private DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public void saveToFile(ArrayList<Member> delfinList) {
        try {
            PrintStream ps = new PrintStream(file);
            for (Member m : delfinList) {
                ps.println( m.getName() + ", " + m.getAge() + ", "
                        + m.getPhoneNumber() + ", " + m.getAddress()
                        + ", " + m.getBirthDate());
                ps.println("\n");
            }
            ps.close();
            if (delfinList.isEmpty()) {
                System.out.println("Person are not saved to file.");
            }
            if (!delfinList.isEmpty()) {
                System.out.println(delfinList.size() + " person has been saved to file.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<Member> loadFileC() {
        ArrayList<Member> delfinList = new ArrayList();
        try {

            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String[] attributes = sc.nextLine().split(",");
                Competition c = new Competition(
                        attributes[0],
                        LocalDate.parse(attributes[1], format),
                        Integer.parseInt(attributes[2]),
                        attributes[3]);
                delfinList.add(c);
            }
            sc.close();
            if (delfinList.isEmpty()) {
                System.out.println("Person are not found in the file.");
            }
            return delfinList;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public ArrayList<Member> loadFileE() {
        ArrayList<Member> delfinList = new ArrayList();
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String[] attributes = sc.nextLine().split(",");
                Exerciser e = new Exerciser(
                        attributes[0],
                        LocalDate.parse(attributes[1], format),
                        Integer.parseInt(attributes[2]),
                        attributes[3]);
                delfinList.add(e);
            }
            sc.close();
            if (delfinList.isEmpty()) {
                System.out.println("Person are not found in the file.");
            }
            return delfinList;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public File getFile(){
        return file;
    }
}

