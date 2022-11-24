import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;


public class Competition extends Member {
    int year;
    int month;
    int day;
    int age;
    LocalDate birthDate;
    String birthDateFormat;
    public Competition(String name, int day, int month, int year, int phoneNumber, String address) {
        super(name, day, month, year, phoneNumber, address);
        this.year = year;
        this.month = month;
        this.day = day;
        ageCalculator();
    }



    }



