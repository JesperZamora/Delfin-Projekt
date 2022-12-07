package domain;

import java.util.ArrayList;

public class Team {
    Trainer trainer;
    ArrayList<Member> team;
    String teamName;

    public Team(String teamName, Trainer trainer, ArrayList<Member> team){
        this.teamName = teamName;
        this.trainer = trainer;
        this.team = team;
    }

    @Override
    public String toString() {
        return "Team-name: " + teamName + " " +
                "trainer: " + trainer +
                " \n ";
    }

    public ArrayList<Member> getTeam() {
        return team;
    }
}

