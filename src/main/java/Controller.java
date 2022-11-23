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
}
