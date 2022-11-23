import java.time.LocalDate;
import java.time.Period;

public abstract class Member {
    String name;
    int phoneNumber;
    boolean activeMembership;
    String adress;
    String membershipAgeType;
    int day;
    int month;
    int year;

    public Member(String name, int day, int month, int year, int phoneNumber, String adress) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.adress = adress;
        this.day = day;
        this.month = month;
        this.year = year;
        SeniorOrJunior();
    }

    LocalDate today = LocalDate.now();
    LocalDate birthDate = LocalDate.of(year, month, day);
    int age = Period.between(birthDate, today).getYears();

    public void SeniorOrJunior() {
        ageCalculator();
        if (age < 18) {
            setMembershipAgeType("Junior");
        } else if (age >= 18 && age <= 60) {
            setMembershipAgeType("Senior");

        } else {
            setMembershipAgeType("Senior med takst");
        }

    }

    public void setMembershipAgeType(String membershipAgeType) {
        this.membershipAgeType = membershipAgeType;
    }

    public void ageCalculator() {
        LocalDate today = LocalDate.now();
        LocalDate birthDate = LocalDate.of(year, month, day);
        age = Period.between(birthDate, today).getYears();

    }

}

