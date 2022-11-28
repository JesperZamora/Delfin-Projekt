import java.io.File;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

class FileHandler {
    private File file = new File("Dolphin.csv");

    public void saveFile(ArrayList<Member> memberList) {
        try {
            PrintStream output = new PrintStream(file);
            for (Member member : memberList) {
                output.println(
                                member.getName() + "," +
                                member.getBirthDate() + "," +
                                member.getPhoneNumber() + "," +
                                member.getAddress() + "," +
                                member.getMembershipType() + "," +
                                member.MemberStatus());
            }
            output.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Member> loadFile() {
        ArrayList<Member> loadedMember = new ArrayList<>();

        try {
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String[] attributes = reader.nextLine().split(",");
                if(attributes[4].equals("exerciser")){
                    Exerciser exerciser = new Exerciser(
                            attributes[0],
                            LocalDate.parse(attributes[1]),
                            Integer.parseInt(attributes[2]),
                            attributes[3],
                            attributes[5]);
                    loadedMember.add(exerciser);

                } else{
                    Competition competition = new Competition(
                            attributes[0],
                            LocalDate.parse(attributes[1]),
                            Integer.parseInt(attributes[2]),
                            attributes[3],
                            attributes[5]);
                    loadedMember.add(competition);
                }
            }
            reader.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return loadedMember;
    }

    public File getFile(){
        return file;
    }
}

