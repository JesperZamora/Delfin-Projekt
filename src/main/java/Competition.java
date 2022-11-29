import java.time.LocalDate;

public class Competition extends Member {

    private Discipline discipline;

    public Competition(String name, LocalDate birthDate, int phoneNumber, String address, String memberStatus) {
        super(name, birthDate, phoneNumber, address, memberStatus);
        setMembershipType("comp swimmer");
    }
}