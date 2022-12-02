import java.time.LocalDate;
import java.util.ArrayList;

public class Controller {
    private Database database;
    private FileHandler fileHandler;

    public Controller(){
        database = new Database();
        fileHandler = new FileHandler();
    }

    public void addExerciser(String name, LocalDate birthDate, int phoneNumber, String address,
                             String memberStatus){
        database.addExerciser(name, birthDate, phoneNumber, address, memberStatus);
    }

    public void addCompetitionSwimmer(String name, LocalDate birthDate, int phoneNumber, String address,
                                      String memberStatus, Discipline[] dis){
        database.addCompetitionSwimmer(name, birthDate, phoneNumber, address, memberStatus, dis);
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




}
