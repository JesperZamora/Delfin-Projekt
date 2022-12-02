import java.time.LocalDate;

public class Result {

    // enum DisciplineEnum
    // slettes: private String disciplineName;

    private Discipline disciplineEnumName;
    private int time;
    private LocalDate date;
    public Result(Discipline disciplineEnumName, int time, LocalDate date){
        this.disciplineEnumName = disciplineEnumName;
        this.date = date;
        this.time = time;
    }

    public Discipline getDisciplineEnumName() {
        return disciplineEnumName;
    }

    public int getTime() {
        return time;
    }

    public LocalDate getDate() {
        return date;
    }

}