import java.util.Comparator;

//TODO At lave vores comparator om til tid. (Kræver en getter til tid)
public class TimeComparator implements Comparator<CompetitionSwimmer> {
    public int compare(CompetitionSwimmer m1, CompetitionSwimmer m2){
        return (int) (m1.getTime() - m2.getTime());
    }
}
