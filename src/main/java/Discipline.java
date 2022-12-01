import java.time.LocalDate;
import java.util.ArrayList;

public class Discipline {

    // enum DisciplineEnum
    // slettes: private String disciplineName;

    private DisciplineEnum disciplineEnumName;
    private int time;
    private LocalDate date;
    public Discipline(DisciplineEnum disciplineEnumName, int time, LocalDate date){
        this.disciplineEnumName = disciplineEnumName;
        this.date = date;
        this.time = time;
    }

    public DisciplineEnum getDisciplineEnumName() {
        return disciplineEnumName;
    }

    public int getTime() {
        return time;
    }

    public LocalDate getDate() {
        return date;
    }

}