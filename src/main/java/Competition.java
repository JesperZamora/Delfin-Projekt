import java.time.LocalDate;

public class Competition {
    int placeInCompetetion;
    String competetionName;
    int time;
    public Competition(String competetionName, int placeInCompetetion, int time) {
        this.competetionName = competetionName;
        this.placeInCompetetion = placeInCompetetion;
        this.time = time;
    }
}
