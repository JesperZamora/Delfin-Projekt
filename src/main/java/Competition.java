import java.awt.*;
import java.time.LocalDate;
import java.util.Arrays;

public class Competition extends Member {


    private Discipline[] disciplines;

    public Competition(String name, LocalDate birthDate, int phoneNumber, String address, String memberStatus, Discipline[] dis) {
        super(name, birthDate, phoneNumber, address, memberStatus);
        setMembershipType("comp swimmer");
        this.disciplines = new Discipline[4];
        this.disciplines = dis;
    }

    public Result disciplineName(Discipline disciplineName) {
        Result[] disciplines = new Result[4];
        for (Result i : disciplines) {
            if (i.getDisciplineEnumName().equals(disciplineName)) {
                return i;
            }
        }
        return null;
    }

    public void addDisciplines1(Discipline dis) {
        for (int i = 0; i < disciplines.length; i++) {
            disciplines[0] = dis;
        }
    }








            /*switch (DiscipliDISCIPLINENAME) {
                case BUTTERFLY:
                    disciplines[0] = dis;
                    break;
                case CRAWL:
                    disciplines[1] = dis;
                    break;
                case BREASTSTROKE:
                    disciplines[2] = dis;
                    break;
                case BACKCRAWL:
                    disciplines[3] = dis;
                    break;*/



    public Discipline[] getDisciplines() {
        return disciplines;
    }

    @Override
    public String toString() {
        return super.toString() + "Competition{" +
                "disciplines=" + Arrays.toString(disciplines) +
                '}';
    }
}