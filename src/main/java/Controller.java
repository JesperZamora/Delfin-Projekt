import java.time.LocalDate;
import java.util.ArrayList;

public class Controller {
    private Database database;
    Competition competition; //remove
    private FileHandler fileHandler;
    public Controller(){
        database = new Database();
        fileHandler = new FileHandler();
    }

    public void addExerciser(String name, LocalDate birthDate, int phoneNumber, String address, boolean memberStatus){
        database.addExerciser(name, birthDate, phoneNumber, address, memberStatus);
    }

    public void addCompetitionSwimmer(String name, LocalDate birthDate, int phoneNumber, String address, boolean memberStatus){
        database.addCompetitionSwimmer(name, birthDate, phoneNumber, address, memberStatus);
    }

    public ArrayList<Member> getMembers(){
        return database.getMembers();
    }

    public ArrayList<Member> searchMember(String searchWord){
        return database.searchMember(searchWord);
    }

    public void saveFile(){
       fileHandler.saveFile(getMembers());
    }

    public void loadFile(){
        database.loadFile(fileHandler.loadFile());
    }

/*    public void searchMemberAge(String age){
        database.searchMemberAge(age);
    }

    public void searchMemberPhoneNumber(String phoneNumber){
        database.searchMemberPhoneNumber(phoneNumber);
    }*/

/*    public void editMember(String name, LocalDate birthDate, int phoneNumber, String address, int memberChoice){
        database.editMember(name, birthDate, phoneNumber, address, memberChoice);
    }*/
  /*  public void ageCalculator() {
        competition.ageCalculator();
    }*/

}
