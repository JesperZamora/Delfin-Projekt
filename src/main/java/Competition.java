import java.time.LocalDate;
import java.util.ArrayList;

public class Competition extends Member {

    private DisciplineEnum disciplineEnum;
    private Discipline[] disciplines = new Discipline[4];

    public Competition(String name, LocalDate birthDate, int phoneNumber, String address, String memberStatus, Discipline[] disciplines) {
        super(name, birthDate, phoneNumber, address, memberStatus);
        setMembershipType("comp swimmer");
        this.disciplines = disciplines;
    }

    public void addDisciplines() {
    }
}