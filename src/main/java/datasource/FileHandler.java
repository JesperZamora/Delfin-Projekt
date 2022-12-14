package datasource;

import java.io.File;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import domain.Member;
import domain.SwimTime;
import domain.CompetitionSwimmer;
import domain.Exerciser;

public class FileHandler {
    private File file = new File("Dolphin.csv");

    public void saveFile(ArrayList<Member> memberList) {
        try {
            PrintStream output = new PrintStream(file);
            for(Member member : memberList){
                if(member instanceof CompetitionSwimmer) {
                    output.println(member.getName() + "," + member.getBirthDate() + "," + member.getPhoneNumber() + "," +
                                    member.getAddress() + "," + member.getMembershipType() + "," + member.MemberStatus()
                                    + "," + member.isPaid());

                    for (SwimTime discipline : ((CompetitionSwimmer) member).getDisciplines()) {
                        if (discipline != null) {
                            output.println(discipline.getLocation() + "," + discipline.getDate() + "," +
                                    discipline.getDisciplineName() + "," + discipline.getTime());
                        }
                    }

                } else {
                    output.println(member.getName() + "," + member.getBirthDate() + "," + member.getPhoneNumber() + "," +
                                    member.getAddress() + "," + member.getMembershipType() + "," + member.MemberStatus()
                                    + "," + member.isPaid());
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

                if(attributes.length <5) {
                    SwimTime discipline = new SwimTime(attributes[0], LocalDate.parse(attributes[1]),
                            attributes[2], Double.parseDouble(attributes[3]));

                    int lastMember = loadedMember.size();
                    CompetitionSwimmer competitionSwimmer = (CompetitionSwimmer) loadedMember.get(lastMember-1);
                    competitionSwimmer.addAbility(discipline);

                }else if(attributes[4].equals("Comp swimmer")){
                    CompetitionSwimmer swimmer = new CompetitionSwimmer(attributes[0], LocalDate.parse(attributes[1]),
                            Integer.parseInt(attributes[2]), attributes[3], attributes[5]);
                            swimmer.setIsPaid(Boolean.parseBoolean(attributes[6]));

                    loadedMember.add(swimmer);

                } else {
                    Exerciser exerciser = new Exerciser(attributes[0], LocalDate.parse(attributes[1]),
                            Integer.parseInt(attributes[2]), attributes[3], attributes[5]);
                            exerciser.setIsPaid(Boolean.parseBoolean(attributes[6]));

                    loadedMember.add(exerciser);
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