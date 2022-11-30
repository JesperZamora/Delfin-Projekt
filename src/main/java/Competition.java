import java.time.LocalDate;
import java.util.ArrayList;

public class Competition extends Member {

    private Discipline discipline;
    private String swimmerType;

    public Competition(String name, LocalDate birthDate, int phoneNumber, String address, String memberStatus, String swimmerType) {
        super(name, birthDate, phoneNumber, address, memberStatus);
        setMembershipType("comp swimmer");
        this.swimmerType = swimmerType;
    }

}