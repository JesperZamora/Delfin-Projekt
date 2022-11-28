import java.time.LocalDate;
import java.util.ArrayList;

public class Database {
    private ArrayList<Member> members = new ArrayList<>();

    public void addExerciser(String name, LocalDate birthDate, int phoneNumber, String address, String memberStatus){
        members.add(new Exerciser(name, birthDate, phoneNumber, address, memberStatus));
    }

    //TODO: not finished yet. Needs discipline information (future sprint)
    public void addCompetitionSwimmer(String name, LocalDate birthDate, int phoneNumber, String address, String memberStatus){
        members.add(new Competition(name, birthDate, phoneNumber, address, memberStatus));
    }

    public void loadFile(ArrayList<Member> loadedFile){
        this.members = loadedFile;
    }

    public ArrayList<Member> searchMember(String searchWord){
        ArrayList<Member> foundMembers = new ArrayList<>();

        for (Member member : members){
            if (member.getName().contains(searchWord)){
                foundMembers.add(member);
            } else if(Integer.toString(member.getAge()).equals(searchWord)){
                foundMembers.add(member);
            } else if(Integer.toString(member.getPhoneNumber()).contains(searchWord)){
                foundMembers.add(member);
            }
        }
        return foundMembers;
    }

    public ArrayList<Member> getMembers(){
        return members;
    }


}
