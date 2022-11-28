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
    private String membershipType;
    private String memberStatus;
    private LocalDate birthDate;

    public Member(String name, LocalDate birthDate, int phoneNumber, String address, String memberStatus) {
        this.name = name;
        setBirthDate(birthDate);
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.memberStatus = memberStatus;
        membershipByAge();
        formatBirthDate();
    }

    public void ageCalculator() {
        LocalDate today = LocalDate.now();
        age = Period.between(birthDate, today).getYears();
    }

    public void formatBirthDate() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        birthDateFormat = birthDate.format(format);
    }

    public void membershipByAge() {
        if (age < 18) {
            this.membershipByAge = "junior";
        } else {
            this.membershipByAge = "senior";
        }
    }

/*    public String toString() {
        return String.format("%-18s %-7d %-13s %-12d %-27s %-8s %-15s %s",
                name, age, birthDateFormat, phoneNumber, address, membershipByAge, membershipType, memberStatus);
    }*/

    public String toString() {
        return String.format("""
                        Name:            %s
                        Age:             %d
                        Birthdate:       %s
                        Phone no:        %d
                        Address:         %s
                        Membership:      %s
                        Member type:     %s
                        Member status:   %s \n""",
                name, age, birthDateFormat, phoneNumber, address, membershipByAge, membershipType, memberStatus);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
    public LocalDate getBirthDate() {
        return birthDate;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public String getMembershipType(){
        return membershipType;
    }

    public String MemberStatus() {
        return memberStatus;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
        formatBirthDate();
        ageCalculator();
        membershipByAge();
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setMembershipType(String membershipType){
        this.membershipType = membershipType;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setMemberStatus(String memberStatus) {
        this.memberStatus = memberStatus;
    }
}




