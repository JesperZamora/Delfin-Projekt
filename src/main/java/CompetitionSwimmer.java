import java.time.LocalDate;

public class CompetitionSwimmer extends Member {
    private Discipline[] disciplines = new Discipline[4];
    public CompetitionSwimmer(String name, LocalDate birthDate, int phoneNumber, String address, String memberStatus) {
        super(name, birthDate, phoneNumber, address, memberStatus);
        setMembershipType("Comp swimmer");
    }

    public void addAbility(Discipline newDiscipline){
        for(int i = 0; i < disciplines.length; i++){
            if(disciplines[i] == null){
                disciplines[i] = newDiscipline;
                break;
            }
        }
    }

    public Discipline[] getDisciplines() {
        return disciplines;
    }
}