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
    private LocalDate birthDate;
    private String birthDateFormat;


    public Member(String name, int day, int month, int year, int phoneNumber, String address) {
        this.name = name;
        this.day = day;
        this.month = month;
        this.year = year;
        this.phoneNumber = phoneNumber;
        this.address = address;
        membershipAgeType();
        formatBirthDate();
    }

    public void ageCalculator() {
        LocalDate today = LocalDate.now();
        birthDate = LocalDate.of(year, month, day);
        age = Period.between(birthDate, today).getYears();
    }
    public void formatBirthDate(){
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        birthDateFormat = birthDate.format(format);
    }

    public void membershipAgeType() {
        ageCalculator();
        if (age < 18) {
            this.membershipType = "junior";
        } else {
            this.membershipType = "senior";
        }
    }

    public String toString() {
        return String.format("%-18s %-7d %-13s %-12d %-27s %s",
                name, age, birthDateFormat, phoneNumber, address, membershipType);
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    public int getPhoneNumber(){
        return phoneNumber;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setDay(int day)
    {
        this.day = day;
    }

    public void setMonth(int month)
    {
        this.month = month;
    }

    public void setYear(int year)
    {
        this.year = year;
    }

    public void setPhoneNumber(int phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public void setActiveMembership(boolean activeMembership)
    {
        this.activeMembership = activeMembership;
    }

    public void setMembershipType(String membershipType)
    {
        this.membershipType = membershipType;
    }

    public void setAge(int age)
    {
        this.age = age;
    }
}




