import java.time.LocalDate;
import java.util.ArrayList;

public class Discipline {

    private String disciplineName;
    private int time;
    private LocalDate date;
    public Discipline(String disciplineName, int time, LocalDate date){
        this.disciplineName = disciplineName;
        this.date = date;
        this.time = time;
    }

    public String getDisciplineName() {
        return disciplineName;
    }

    public int getTime() {
        return time;
    }

    public LocalDate getDate() {
        return date;
    }
}