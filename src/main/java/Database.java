import java.util.ArrayList;

public class Database {
    private ArrayList<Member> members = new ArrayList<>();

    public void addExerciser(String name, int day, int month, int year, int phoneNumber, String address){
        members.add(new Exerciser(name, day, month, year, phoneNumber, address));
    }

    //TODO: not finished yet. Needs discipline information (future sprint)
    public void addCompetitionSwimmer(String name, int day, int month, int year, int phoneNumber, String adress){
        members.add(new Competition(name, day, month, year, phoneNumber, adress));
    }

    public Member searchMemberName(String searchName){
        for (Member m : members){
            if (m.getName().contains(searchName)){
                return m;
            }
        }
        return null;
    }

    public Member searchMemberAge(String searchAge){
        for (Member m : members){
            String actualAge = Integer.toString(m.getAge());
            if (actualAge.contains(searchAge)){
                return m;
            }
        }
        return null;
    }

    public Member searchMemberPhoneNumber(String searchPhoneNumber){
        for (Member m : members){
            String actualPhoneNumber = Integer.toString(m.getPhoneNumber());
            if (actualPhoneNumber.contains(searchPhoneNumber)){
                return m;
            }
        }
        return null;
    }
}
