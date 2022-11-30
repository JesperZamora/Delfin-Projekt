import java.time.LocalDate;

public class Discipline  {

    private String disciplineName;
    private String trainOrCompResult;
    private LocalDate date;
    private double time;
    private Discipline[] disciplines = new Discipline[4];

    public Discipline(String disciplineName, String trainOrCompResult, LocalDate date, double time) {
        this.disciplineName = disciplineName;
        this.trainOrCompResult = trainOrCompResult;
        this.date = date;
        this.time = time;
    }

    public void addDisciplines(String disciplineName, String trainOrCompResult, LocalDate date, double time) {
        for(int i = 0; i < disciplines.length; i++) {
            if(disciplines[i] == null) {
                disciplines[i] = new Discipline(disciplineName, trainOrCompResult, date, time);;
                break;
            }
        }
    }

    public void setDisciplineName(String disciplineName) {
        this.disciplineName = disciplineName;
    }

    public void setTrainOrCompResult(String trainOrCompName) {
        this.trainOrCompResult = trainOrCompName;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setTime(double time) {
        this.time = time;
    }
}
