import java.time.LocalDate;

public class Exerciser extends Member {
    public Exerciser(String name, LocalDate birthDate, int phoneNumber, String address) {
        super(name, birthDate, phoneNumber, address);
        formatBirthDate();
        ageCalculator();
    }
}