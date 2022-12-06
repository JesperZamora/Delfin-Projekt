package domain;

import java.time.LocalDate;

public class CompetitionSwimmer extends Member {
    private SwimTime[] disciplines = new SwimTime[4];
    public CompetitionSwimmer(String name, LocalDate birthDate, int phoneNumber, String address, String memberStatus) {
        super(name, birthDate, phoneNumber, address, memberStatus);
        setMembershipType("Comp swimmer");
    }

    public void addAbility(SwimTime newDiscipline){
        for(int i = 0; i < disciplines.length; i++){
            if(disciplines[i] == null){
                disciplines[i] = newDiscipline;
                break;
            }
        }
    }

    public SwimTime[] getDisciplines() {
        return disciplines;
    }


}