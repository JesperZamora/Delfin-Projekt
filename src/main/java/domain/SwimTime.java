package domain;
import java.time.LocalDate;

public class SwimTime {
    private String location;
    private LocalDate date;
    private String disciplineName;
    private double time;

    public SwimTime(String location, LocalDate date, String disciplineName, double time) {
        this.location = location;
        this.date = date;
        this.disciplineName = disciplineName;
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getDisciplineName() {
        return disciplineName;
    }

    public double getTime() {
        return time;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setDisciplineName(String disciplineName) {
        this.disciplineName = disciplineName;
    }

    public void setTime(double time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return  "Location: " + location + '\n' +
                "Date: " + date + '\n' +
                "Discipline: " + disciplineName + '\n' +
                "Time: " + time + '\n';
    }
}
