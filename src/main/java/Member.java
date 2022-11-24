

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

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
    private String birthDateFormat;
    private String active;
    private String passive;
    private String inactive;
    private LocalDate birthDate;


    public Member(String name, LocalDate birthDate, int phoneNumber, String address) {
        this.name = name;
        setBirthDate(birthDate);
        this.phoneNumber = phoneNumber;
        this.address = address;
        membershipAgeType();
        formatBirthDate();
    }

    public Member() {

    }

    public void ageCalculator() {
        LocalDate today = LocalDate.now();
        age = Period.between(birthDate, today).getYears();
    }

    public void formatBirthDate() {
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

    public void setActiveMembership(boolean activeMembership) {
        this.activeMembership = activeMembership;
    }

    public void setMembershipType(String membershipType) {
        this.membershipType = membershipType;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getActive() {
        return active;
    }


    public String getPassive() {
        return passive;
    }

    public void setMembershipType() {
        this.membershipType = membershipType;
    }

    public String activitiesForm() {
        if (name == active) {
            return membershipType;
        } else if (name == passive) {
            return membershipType;
        } else if (name == inactive) {
            return membershipType;
        }
        return "";
    }


    public int getMonth() {
        return month;
    }
    public LocalDate getBirthDate() {
        return birthDate;
    }
}




