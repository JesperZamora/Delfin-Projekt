package domain;

import java.util.Comparator;

public class TimeComparator implements Comparator<CompetitionSwimmer> {
    public int compare(CompetitionSwimmer m1, CompetitionSwimmer m2){
        return (int) (m1.getTime() - m2.getTime());
    }
}