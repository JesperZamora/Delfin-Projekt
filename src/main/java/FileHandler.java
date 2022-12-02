import java.io.File;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class FileHandler {
    private File file = new File("Dolphin.csv");

    public void saveFile(ArrayList<Member> memberList) {
        try {
            PrintStream output = new PrintStream(file);
            for (Member member : memberList) {
                if (member instanceof Exerciser) {
                    output.println(
                                    member.getName() + "," +
                                    member.getBirthDate() + "," +
                                    member.getPhoneNumber() + "," +
                                    member.getAddress() + "," +
                                    member.getMembershipType() + "," +
                                    member.MemberStatus()
                    );
                } else if (member instanceof CompetitionSwimmer) {
                    output.println(
                                    member.getName() + "," +
                                    member.getBirthDate() + "," +
                                    member.getPhoneNumber() + "," +
                                    member.getAddress() + "," +
                                    member.getMembershipType() + "," +
                                    member.MemberStatus()
                                    //+ "," +  ((CompetitionSwimmer) member).getDisciplineName() + "," +
                                    //((CompetitionSwimmer) member).getTime() + "," +
                                    //((CompetitionSwimmer) member).getDate()

                                   // + "," +  Arrays.toString(((CompetitionSwimmer) member).getDisciplines())
                    );

                }
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
                if (attributes[4].equals("Exerciser")) {
                    Exerciser exerciser = new Exerciser(
                            attributes[0],
                            LocalDate.parse(attributes[1]),
                            Integer.parseInt(attributes[2]),
                            attributes[3],
                            attributes[5]

                    );
                    loadedMember.add(exerciser);

                } else {
                    CompetitionSwimmer competition = new CompetitionSwimmer(
                            attributes[0],
                            LocalDate.parse(attributes[1]),
                            Integer.parseInt(attributes[2]),
                            attributes[3],
                            attributes[5]
                    );

/*
                    Discipline discipline = new Discipline(
                            attributes[6],
                            Double.parseDouble(attributes[7]),
                            LocalDate.parse(attributes[8]));

                    competition.addNewDiscipline(attributes[6],
                            Double.parseDouble(attributes[7]),
                            LocalDate.parse(attributes[8]));
*/

                    loadedMember.add(competition);
                }
            }
            reader.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return loadedMember;
    }

    public File getFile() {
        return file;
    }
}

