import java.time.LocalDate;
import java.util.ArrayList;

public class Database {
    private ArrayList<Member> members = new ArrayList<>();
    private ArrayList<Member> compMembersUnder18 = new ArrayList<>();
    private ArrayList<Member> compMembersOver18 = new ArrayList<>();
    private Discipline[] disciplines = new Discipline[4];

    public void addExerciser(String name, LocalDate birthDate, int phoneNumber, String address, String memberStatus) {
        members.add(new Exerciser(name, birthDate, phoneNumber, address, memberStatus));
    }

    //TODO: not finished yet. Needs discipline information (future sprint)
    public void addCompetitionSwimmer(String name, LocalDate birthDate, int phoneNumber, String address, String memberStatus) {
        members.add(new CompetitionSwimmer(name, birthDate, phoneNumber, address, memberStatus, disciplines));
    }

    public void addNewDiscipline(String disciplineName, double time,LocalDate date) {
        for(int i = 0; i < disciplines.length; i++) {
            if(disciplines[i] == null) {
                disciplines[i] = new Discipline(disciplineName, time, date);
                break;
            }
        }
    }

    public void loadFile(ArrayList<Member> loadedFile) {
        this.members = loadedFile;
    }

    public ArrayList<Member> searchMember(String searchWord) {
        ArrayList<Member> foundMembers = new ArrayList<>();

        for (Member member : members) {
            if (member.getName().toLowerCase().contains(searchWord)) {
                foundMembers.add(member);
            } else if (Integer.toString(member.getAge()).contains(searchWord)) {
                foundMembers.add(member);
            } else if (Integer.toString(member.getPhoneNumber()).contains(searchWord)) {
                foundMembers.add(member);
            }
        }
        return foundMembers;
    }

    public ArrayList<Member> getMembers() {
        return members;

    }
    public void sortCompMembersAge() {
        for (Member member : members) {
            if (member.getMembershipType().equals("comp swimmer") && member.getAge() < 18) {
                compMembersUnder18.add(member);


            } else if (member.getMembershipType().equals("comp swimmer") && member.getAge() >= 18) {
                compMembersOver18.add(member);

            }
        }
    }

    public ArrayList<Member> getCompMembersUnder18() {
        return compMembersUnder18;

    }
    public ArrayList<Member> getGetCompMembersOver18() {
        return compMembersOver18;
    }
}



