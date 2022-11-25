import java.time.LocalDate;
import java.util.ArrayList;

public class Database {
    private ArrayList<Member> members = new ArrayList<>();
    private ArrayList<Member> editMembers = new ArrayList<>();


    public void addExerciser(String name, LocalDate birthDate, int phoneNumber, String address, boolean memberStatus){
        members.add(new Exerciser(name, birthDate, phoneNumber, address, memberStatus));
    }

    //TODO: not finished yet. Needs discipline information (future sprint)
    public void addCompetitionSwimmer(String name, LocalDate birthDate, int phoneNumber, String address, boolean memberStatus){
        members.add(new Competition(name, birthDate, phoneNumber, address, memberStatus));
    }

    public void loadFile(ArrayList<Member> loadedFile){
        this.members = loadedFile;
    }

/*    public void editMember(String name, LocalDate birthDate, int phoneNumber, String address, int memberChoice){
        if (!editMembers.isEmpty()){
            Member editMember = editMembers.get(memberChoice - 1);

        }
    }*/

    public ArrayList<Member> searchMemberName(String searchName){
        for (Member m : members){
            if (m.getName().contains(searchName)){
                editMembers.add(m);
                return editMembers;
            }
        }
        return null;
    }

    public Member searchMemberAge(String searchAge){
        for (Member m : members){
            String actualAge = Integer.toString(m.getAge());
            if (actualAge.contains(searchAge)){
                editMembers.add(m);
                return m;
            }
        }
        return null;
    }

    public Member searchMemberPhoneNumber(String searchPhoneNumber){
        for (Member m : members){
            String actualPhoneNumber = Integer.toString(m.getPhoneNumber());
            if (actualPhoneNumber.contains(searchPhoneNumber)){
                editMembers.add(m);
                return m;
            }
        }
        return null;
    }
    public ArrayList<Member> getMembers(){
        return members;
    }


}
