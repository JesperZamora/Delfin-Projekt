import java.time.LocalDate;

public class Competition extends Member {

    public Competition(String name, LocalDate birthDate, int phoneNumber, String address) {
        super(name, birthDate, phoneNumber, address);
        formatBirthDate();
        ageCalculator();
    }
}