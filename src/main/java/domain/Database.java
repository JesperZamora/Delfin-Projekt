package domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;

public class Database {
    private ArrayList<Member> members = new ArrayList<>();
    private Trainer trainer1 = new Trainer("Stefan");
    private ArrayList<Member> listJunior = new ArrayList<>();
    private ArrayList<Member> listSenior = new ArrayList<>();
    private Team teamJunior = new Team("Team Junior", trainer1, listJunior);
    private Team teamSenior = new Team("Team Senior", trainer1, listSenior);
    private ArrayList<Member> competitionSwimmers = new ArrayList<>();

    public void addExerciser(String name, LocalDate birthDate, int phoneNumber, String address, String memberStatus) {
        members.add(new Exerciser(name, birthDate, phoneNumber, address, memberStatus));
    }

    public void addCompetitionSwimmer(String name, LocalDate birthDate, int phoneNumber, String address, String memberStatus) {
        members.add(new CompetitionSwimmer(name, birthDate, phoneNumber, address, memberStatus));
    }

    public void loadFile(ArrayList<Member> loadedFile) {
        this.members = loadedFile;
    }

    public ArrayList<Member> searchMember(String searchWord) {
        ArrayList<Member> foundMembers = new ArrayList<>();

        for (Member member : members) {
            if (member.getName().toLowerCase().contains(searchWord.toLowerCase())) {
                foundMembers.add(member);
            } else if (Integer.toString(member.getAge()).contains(searchWord)) {
                foundMembers.add(member);
            } else if (Integer.toString(member.getPhoneNumber()).contains(searchWord)) {
                foundMembers.add(member);
            }
        }
        return foundMembers;
    }
    public int sumOfSubscriptions(ArrayList<Member> member){
        int sum = 0;
        for (Member m : member) {
                sum += m.getSubscriptionPrice();
        }
        return sum;
    }

    public ArrayList<Member> getMembers() {
        return members;

    }
    public Team getTeamJunior() {
        return teamJunior;
    }

    public Team getTeamSenior() {
        return teamSenior;
    }

    public ArrayList<Member> getListJunior() {
        return listJunior;
    }

    public ArrayList<Member> getListSenior() {
        return listSenior;
    }

    public ArrayList<Member> getCompetitionSwimmers(){
        for (Member member : members){
            if (member instanceof CompetitionSwimmer){
                competitionSwimmers.add(member);
            }
        }
        return competitionSwimmers;
    }
}



