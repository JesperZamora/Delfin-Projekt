public class Controller {
    private Database database;
    public Controller(){
        database = new Database();
    }

    public void addExerciser(String name, int day, int month, int year, int phoneNumber, String address){
        database.addExerciser(name, day, month, year, phoneNumber, address);
    }

    public void addCompetitionSwimmer(String name, int day, int month, int year, int phoneNumber, String adress){
        database.addCompetitionSwimmer(name, day, month, year, phoneNumber, adress);
    }

    public ArrayList<Member> getMembers(){
        return database.getMembers();
    }

    public void searchMemberName(String name){
        database.searchMemberName(name);
    }

    public void searchMemberAge(String age){
        database.searchMemberAge(age);
    }

    public void searchMemberPhoneNumber(String phoneNumber){
        database.searchMemberPhoneNumber(phoneNumber);
    }

    public void editMember(String name, int day, int month, int year, int phoneNumber, String adress, int memberChoice){
        database.editMember(name, day, month, year, phoneNumber, adress, memberChoice);
    }
}
