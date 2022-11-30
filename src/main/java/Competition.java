import java.time.LocalDate;
import java.util.ArrayList;

public class Competition extends Member {

    private DisciplineEnum disciplineEnum;
    private Discipline[] disciplines = new Discipline[4];
    private String discipline;

    public Competition(String name, LocalDate birthDate, int phoneNumber, String address, String memberStatus, String discipline) {
        super(name, birthDate, phoneNumber, address, memberStatus);
        setMembershipType("comp swimmer");
        this.discipline = discipline;
    }

    public void addDisciplines() {
        if (disciplineEnum == DisciplineEnum.BACKCRAWL){
            Discipline backcrawl = disciplines[0];
        } else if (disciplineEnum == DisciplineEnum.BUTTERFLY){
            Discipline butterfly = disciplines[1];
        } else if (disciplineEnum == DisciplineEnum.BREASTSTROKE){
            Discipline breaststroke = disciplines[2];
        } else if (disciplineEnum == DisciplineEnum.CRAWL) {
            Discipline crawl = disciplines[3];
        }
    }
}