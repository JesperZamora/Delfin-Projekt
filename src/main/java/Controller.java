import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Controller {
    private Database database;
    Competition competition;
    public Controller(){
        database = new Database();
    }


    public void addExerciser(String name, LocalDate birthDate, int phoneNumber, String address){
        database.addExerciser(name, birthDate, phoneNumber, address);
    }

    public void addCompetitionSwimmer(String name, LocalDate birthDate, int phoneNumber, String adress){
        database.addCompetitionSwimmer(name, birthDate, phoneNumber, adress);
    }

    public ArrayList<Member> getMembers(){
        return database.getMembers();
    }

    public ArrayList<Member> searchMemberName(String name){
        return database.searchMemberName(name);
    }

    public void searchMemberAge(String age){
        database.searchMemberAge(age);
    }

    public void searchMemberPhoneNumber(String phoneNumber){
        database.searchMemberPhoneNumber(phoneNumber);
    }

    public void editMember(String name, LocalDate birthDate, int phoneNumber, String address, int memberChoice){
        database.editMember(name, birthDate, phoneNumber, address, memberChoice);
    }
    public void ageCalculator() {
        competition.ageCalculator();
    }

}
