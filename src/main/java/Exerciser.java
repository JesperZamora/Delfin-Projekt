import java.time.LocalDate;

public class Exerciser extends Member {
    public Exerciser(String name, LocalDate birthDate, int phoneNumber, String address, boolean memberStatus) {
        super(name, birthDate, phoneNumber, address, memberStatus);
        setMembershipType("exerciser");
    }
}