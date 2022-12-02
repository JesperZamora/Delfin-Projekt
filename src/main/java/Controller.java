import java.time.LocalDate;
import java.util.ArrayList;

public class Controller {
    private Database database;
    private FileHandler fileHandler;

    public Controller() {
        database = new Database();
        fileHandler = new FileHandler();
    }

    public void addExerciser(String name, LocalDate birthDate, int phoneNumber, String address,
                             String memberStatus) {
        database.addExerciser(name, birthDate, phoneNumber, address, memberStatus);
    }

    public void addCompetitionSwimmer(String name, LocalDate birthDate, int phoneNumber, String address,
                                      String memberStatus) {
        database.addCompetitionSwimmer(name, birthDate, phoneNumber, address, memberStatus);
    }


    public ArrayList<Member> getMembers() {
        return database.getMembers();
    }

    public ArrayList<Member> searchMember(String searchWord) {
        return database.searchMember(searchWord);
    }

    public void saveFile() {
        fileHandler.saveFile(getMembers());
    }

    public void loadFile() {
        database.loadFile(fileHandler.loadFile());
    }


    public void sortCompGroupByAge() {
        database.sortCompMembersAge();
    }

    public ArrayList<Member> getCompMembersOver18() {
        return database.getGetCompMembersOver18();
    }

    public ArrayList<Member> getCompMembersUnder18() {
        return database.getCompMembersUnder18();
    }
}
