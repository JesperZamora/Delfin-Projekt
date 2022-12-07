package domain;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SwimTime {
    private String location;
    private LocalDate date;
    private String disciplineName;
    private String dateFormat;
    private double time;


    public SwimTime(String location, LocalDate date, String disciplineName, double time) {
        this.location = location;
        this.date = date;
        this.disciplineName = disciplineName;
        this.time = time;
        formatDate();
    }

    public void formatDate(){
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        dateFormat = date.format(format);
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
        formatDate();
    }

    public void setDisciplineName(String disciplineName) {
        this.disciplineName = disciplineName;
    }

    public void setTime(double time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return  String.format("Location: %-14s Date: %-14s Discipline: %-14s Time: %.02f ", location, dateFormat, disciplineName, time);
    }
}
