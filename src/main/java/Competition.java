import java.time.LocalDate;

public class Competition {
    int placement;
    String competitionName;
    int time;
    public Competition(String competitionName, int placement, int time) {
        this.competitionName = competitionName;
        this.placement = placement;
        this.time = time;
    }
}
