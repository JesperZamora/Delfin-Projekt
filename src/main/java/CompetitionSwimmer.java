import java.time.LocalDate;

public class CompetitionSwimmer extends Member {
    private Discipline[] disciplines = new Discipline[4];

    public CompetitionSwimmer(String name, LocalDate birthDate, int phoneNumber, String address, String memberStatus) {
        super(name, birthDate, phoneNumber, address, memberStatus);
        setMembershipType("Comp swimmer");
    }

    public void addAbility(Discipline newDiscipline) {
        for (int i = 0; i < disciplines.length; i++) {
            if (disciplines[i] == null) {
                disciplines[i] = newDiscipline;
                break;
            }
        }
    }


    public boolean isButterfly() {
        for (Discipline discipline : disciplines) {
            if (discipline != null && discipline.getDisciplineName().equalsIgnoreCase(("butterfly"))) {
                return true;
            }
        }
        return false;
    }

    public boolean isCrawl() {
        for (Discipline discipline : disciplines) {
            if (discipline.getDisciplineName().equalsIgnoreCase("crawl")) {
                return true;
            }
        }
        return false;
    }

    public boolean isBackCrawl() {
        for (Discipline discipline : disciplines) {
            if (discipline.getDisciplineName().equalsIgnoreCase("backcrawl")) {
                return true;
            }
        }
        return false;
    }

    public boolean isBreastStroke() {
        for (Discipline discipline : disciplines) {
            if (discipline.getDisciplineName().equalsIgnoreCase("breaststroke")) {
                return true;
            }
        }
        return false;
    }

    public double getTime() {
        double bestTimeButterflySwimmers = 0;
        for (Discipline discipline : getDisciplines()) {
            bestTimeButterflySwimmers = discipline.getTime();
        }
        return bestTimeButterflySwimmers;
    }

    public Discipline[] getDisciplines() {
        return disciplines;
    }
}