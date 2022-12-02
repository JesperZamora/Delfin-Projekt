import java.io.File;
import java.io.PrintStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class FileHandler {
    private File file = new File("Dolphin.csv");
    private DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");

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
                            if(!member.getName().isEmpty()){
                                output.print(
                                        member.getName() + "," +
                                        member.getBirthDate() + "," +
                                        member.getPhoneNumber() + "," +
                                        member.getAddress() + "," +
                                        member.getMembershipType() + "," +
                                        member.MemberStatus());

                                if(((CompetitionSwimmer) member).getDisciplines() != null) {
                                    Discipline[] disciplines = ((CompetitionSwimmer) member).getDisciplines();
                                    for (Discipline discipline : disciplines) {
                                        output.print(","+ discipline);
                                    }
                                    output.println();
                                }
                            }

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
                }

                if (attributes[4].equals("Comp swimmer")){
                    CompetitionSwimmer competition = new CompetitionSwimmer(
                            attributes[0],
                            LocalDate.parse(attributes[1]),
                            Integer.parseInt(attributes[2]),
                            attributes[3],
                            attributes[5]

                    );
                    loadedMember.add(competition);

                    if(!attributes[6].equals("null")){
                        int lastMember = loadedMember.size();
                        CompetitionSwimmer competitionSwimmer = (CompetitionSwimmer) loadedMember.get(lastMember-1);
                        Discipline discipline = new Discipline(
                                attributes[6],
                                Double.parseDouble(attributes[8]),
                                LocalDate.parse(attributes[7]));
                                competitionSwimmer.addDiscipline(discipline);

                                if(!attributes[9].equals("null")) {
                                    Discipline discipline1 = new Discipline(
                                            attributes[9],
                                            Double.parseDouble(attributes[11]),
                                            LocalDate.parse(attributes[10]));
                                    competitionSwimmer.addDiscipline(discipline1);

                                    if(!attributes[12].equals("null")){
                                        Discipline discipline2 = new Discipline(
                                                attributes[12],
                                                Double.parseDouble(attributes[14]),
                                                LocalDate.parse(attributes[13]));
                                        competitionSwimmer.addDiscipline(discipline2);

                                        if(!attributes[15].equals("null")){
                                            Discipline discipline3 = new Discipline(
                                                    attributes[15],
                                                    Double.parseDouble(attributes[17]),
                                                    LocalDate.parse(attributes[16]));
                                            competitionSwimmer.addDiscipline(discipline3);
                                        }
                                    }
                                }

                    }
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


/*                    output.println(
                                    member.getName() + "," +
                                    member.getBirthDate() + "," +
                                    member.getPhoneNumber() + "," +
                                    member.getAddress() + "," +
                                    member.getMembershipType() + "," +
                                    member.MemberStatus()
                                    //+ "," +  ((CompetitionSwimmer) member).getDisciplineName() + "," +
                                    //((CompetitionSwimmer) member).getTime() + "," +
                                    //((CompetitionSwimmer) member).getDate()

                                    //+ "," +  Arrays.toString(((CompetitionSwimmer) member).getDisciplines())
                    );*/


/*                    Discipline discipline = new Discipline(
                            attributes[6],
                            Double.parseDouble(attributes[7]),
                            LocalDate.parse(attributes[8]));

                    competition.addNewDiscipline(attributes[6],
                            Double.parseDouble(attributes[7]),
                            LocalDate.parse(attributes[8]));
*/

//loadedMember.add(competition);