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

    public boolean isButterfly() {
        for (SwimTime swimTime : disciplines) {
            if (swimTime != null && swimTime.getDisciplineName().equalsIgnoreCase(("butterfly"))) {
                return true;
            }
        }
        return false;
    }

    public boolean isCrawl() {
        for (SwimTime swimTime : disciplines) {
            if (swimTime != null && swimTime.getDisciplineName().equalsIgnoreCase("crawl")) {
                return true;
            }
        }
        return false;
    }

    public boolean isBackCrawl() {
        for (SwimTime swimTime : disciplines) {
            if (swimTime != null && swimTime.getDisciplineName().equalsIgnoreCase("backcrawl")) {
                return true;
            }
        }
        return false;
    }

    public boolean isBreastStroke() {
        for (SwimTime swimTime : disciplines) {
            if (swimTime != null && swimTime.getDisciplineName().equalsIgnoreCase("breaststroke")) {
                return true;
            }
        }
        return false;
    }

    public double getTime() {
        double bestTime = 0;
        for (SwimTime swimTime : disciplines) {
            if (swimTime.getTime() != 0) {
                bestTime = swimTime.getTime();
            }
        }
        return bestTime;
    }


    public SwimTime[] getDisciplines() {
        return disciplines;
    }


}