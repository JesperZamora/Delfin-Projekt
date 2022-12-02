import java.time.LocalDate;
import java.util.Arrays;

public class CompetitionSwimmer extends Member {
    private Discipline[] disciplines = new Discipline[4];
    private Discipline newDiscipline;
    public CompetitionSwimmer(String name, LocalDate birthDate, int phoneNumber, String address, String memberStatus) {
        super(name, birthDate, phoneNumber, address, memberStatus);
        setMembershipType("Comp swimmer");
    }

    public void addNewDiscipline(String disciplineName, double time,LocalDate date) {
        for(int i = 0; i < disciplines.length; i++) {
            if(disciplines[i] == null) {
                disciplines[i] = new Discipline(disciplineName, time, date);
                break;
            }
        }
    }



    public Discipline[] getDisciplines(){
        return disciplines;
    }

    public String getDisciplineName() {
        return newDiscipline.getDisciplineName();
    }

    public LocalDate getDate() {
        return newDiscipline.getDate();
    }

    public double getTime() {
        return newDiscipline.getTime();
    }
    public void setDisciplines(Discipline[] disciplines) {
        this.disciplines = disciplines;
    }


    @Override
    public String toString() {
        return super.toString() + "compDisciplines=" + Arrays.toString(disciplines) + "\n";

    }
}