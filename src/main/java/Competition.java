import java.time.LocalDate;

public class Competition extends Member {

    public Competition(String name, LocalDate birthDate, int phoneNumber, String address, boolean memberStatus) {
        super(name, birthDate, phoneNumber, address, memberStatus);
        formatBirthDate();
        ageCalculator();
        setMembershipType("comp swimmer");
    }

}