import java.time.LocalDate;

public class Competition extends Member {

    private DisciplineEnum disciplineEnum;
    Discipline[] disciplines;

    public Competition(String name, LocalDate birthDate, int phoneNumber, String address, String memberStatus) {
        super(name, birthDate, phoneNumber, address, memberStatus);
        setMembershipType("comp swimmer");
        this.disciplines = new Discipline[4];
    }

    public Discipline disciplineName(DisciplineEnum disciplineName) {
        Discipline[] disciplines = new Discipline[4];
        for (Discipline i : disciplines) {
            if (i.getDisciplineEnumName().equals(disciplineName)) {
                return i;
            }
        }
        return null;
    }

    public void addDisciplines(Discipline des) {
            switch (DisciplineEnum.DISCIPLINENAME) {
                case BUTTERFLY:
                    disciplines[0] = des;
                    break;
                case CRAWL:
                    disciplines[1] = des;
                    break;
                case BREASTSTROKE:
                    disciplines[2] = des;
                    break;
                case BACKCRAWL:
                    disciplines[3] = des;
                    break;
            }
        }


    public DisciplineEnum getDisciplineEnum() {
        return disciplineEnum;
    }

    public Discipline[] getDisciplines() {
        return disciplines;
    }
}