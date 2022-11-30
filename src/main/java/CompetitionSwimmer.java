import java.time.LocalDate;

public class CompetitionSwimmer extends Member {
    public CompetitionSwimmer(String name, LocalDate birthDate, int phoneNumber, String address, String memberStatus) {
        super(name, birthDate, phoneNumber, address, memberStatus);
        setMembershipType("comp swimmer");
    }
}