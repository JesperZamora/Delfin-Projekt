import java.time.LocalDate;
import java.time.Period;

public abstract class Member {
    private String name;
    private int day;
    private int month;
    private int year;
    private int phoneNumber;
    private String address;
    private boolean activeMembership;
    private String membershipType;
    private int age;


    public Member(String name, int day, int month, int year, int phoneNumber, String address) {
        this.name = name;
        this.day = day;
        this.month = month;
        this.year = year;
        this.phoneNumber = phoneNumber;
        this.address = address;
        membershipAgeType();
    }

    public void ageCalculator() {
        LocalDate today = LocalDate.now();
        LocalDate birthDate = LocalDate.of(year, month, day);
        age = Period.between(birthDate, today).getYears();
    }

    public void membershipAgeType() {
        ageCalculator();
        if (age < 18) {
            this.membershipType = "Junior";
        } else {
            this.membershipType = "Senior";
        }
    }

}




