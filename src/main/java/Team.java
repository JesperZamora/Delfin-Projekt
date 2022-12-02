import java.util.ArrayList;

public class Team {
    Trainer trainer;
    ArrayList<Member> team;
    String teamName;

    @Override
    public String toString() {
        return "teamName = " + teamName + " " +
                "trainer =" + trainer +
                " " + team;
    }

    public Team(String teamName, Trainer trainer, ArrayList<Member> team){
        this.teamName = teamName;
        this.trainer = trainer;
        this.team = team;
    }

}

