import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Discipline  {
    private String disciplineName;
    private LocalDate date;
    private double time;
    //private DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private String dateOfResult;
    private Discipline[] disciplines = new Discipline[4];

    public Discipline(String disciplineName, double time,LocalDate date) {
        this.disciplineName = disciplineName;
        this.date = date;
        this.time = time;

    }


    public String toString(){
        return String.format("""
                %s,%s,%s""",disciplineName, date, time);
    }

    public String getDisciplineName() {
        return disciplineName;
    }

    public LocalDate getDate() {
        return date;
    }

    public double getTime() {
        return time;
    }
}
