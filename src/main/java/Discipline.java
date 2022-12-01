import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Discipline  {
    //private boolean trainingOrComp;
    private String disciplineName;
    private LocalDate date;
    private double time;
    //private DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    //private String dateOfResult = date.format(format);
    private Discipline[] disciplines = new Discipline[4];

    public Discipline(String disciplineName, double time,LocalDate date) {
        this.disciplineName = disciplineName;
        this.date = date;
        this.time = time;

    }

    public void addNewDiscipline() {
        for(int i = 0; i < disciplines.length; i++) {
            if(disciplines[i] == null) {
                disciplines[i] = new Discipline(disciplineName, time, date);
                break;
            }
        }
    }

    public Discipline[] getDisciplines(){
        return disciplines;
    }


    public String toString(){
        return String.format("""
                %s,%s,%s""",disciplineName, date, time);
    }

    public String getDisciplineName() {
        return disciplineName;
    }

/*
    public boolean getTrainOrComp() {
        return trainingOrComp;
    }
*/

    public LocalDate getDate() {
        return date;
    }

    public double getTime() {
        return time;
    }
}
