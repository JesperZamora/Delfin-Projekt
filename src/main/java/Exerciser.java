import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Exerciser extends Member {
    String birthDateFormat;
    LocalDate birthDate;
    int year;
    int month;
    int day;
    int age;
    public Exerciser(String name, int day, int month, int year, int phoneNumber, String address) {
        super(name, day, month, year, phoneNumber, address);
        ageCalculator();
    }

    @Override
    public void ageCalculator() {
        LocalDate today = LocalDate.now();
        birthDate = LocalDate.of(year, month, day);
        age = Period.between(birthDate, today).getYears();

    }

    @Override
    public void formatBirthDate() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        birthDateFormat = birthDate.format(format);
    }

}
