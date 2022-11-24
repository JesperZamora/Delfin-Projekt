import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public abstract class Member {
    private String name;
    private int age;
    private String birthDateFormat;
    private int phoneNumber;
    private String address;
    private String membershipByAge;
    private boolean memberStatus;
    private String membershipType;
    private LocalDate birthDate;
    private int day;
    private int month;
    private int year;
    //private String active;
    //private String passive;
    //private String inactive;


    public Member(String name, LocalDate birthDate, int phoneNumber, String address) {
        this.name = name;
        setBirthDate(birthDate);
        this.phoneNumber = phoneNumber;
        this.address = address;
        membershipByAge();
        formatBirthDate();
    }

/*    public Member() {

    }*/

    public void ageCalculator() {
        LocalDate today = LocalDate.now();
        age = Period.between(birthDate, today).getYears();
    }

    public void formatBirthDate() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        birthDateFormat = birthDate.format(format);
    }

    public void membershipByAge() {
        ageCalculator();
        if (age < 18) {
            this.membershipByAge = "junior";
        } else {
            this.membershipByAge = "senior";
        }
    }

    public String toString() {
        return String.format("%-18s %-7d %-13s %-12d %-27s %s",
                name, age, birthDateFormat, phoneNumber, address, membershipByAge);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return this.age;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
        formatBirthDate();
        ageCalculator();
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setMemberStatus(boolean memberStatus) {
        this.memberStatus = memberStatus;
    }

/*    public void setMembershipAgeType(String membershipAgeType) {
        this.membershipAgeType = membershipAgeType;
    }*/

/*    public void setMembershipType(String membershipType) {
        this.membershipType = membershipType;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setBirthDateFormat(String birthDateFormat){
        this.birthDateFormat = birthDateFormat;
    }*/

/*    public String getActive() {
        return active;
    }


    public String getPassive() {
        return passive;
    }*/

    public void setMembershipType() {
        this.membershipType = membershipType;
    }

    public int getMonth() {
        return month;
    }
    public LocalDate getBirthDate() {
        return birthDate;
    }
}




