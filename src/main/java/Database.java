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

    public ArrayList<Member> getMembers(){
        return members;
    }


}
