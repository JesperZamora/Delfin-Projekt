import com.beust.jcommander.IStringConverter;

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
    private String active;
    private String passive;
    private String inactive;



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

    public String toString() {
        return String.format("%-18s %-7d %-13s %-12d %-27s %s",
                name, age, birthDateFormat, phoneNumber, address, membershipType);
    }

    public String getName() {
        return name;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public boolean isActiveMembership() {
        return activeMembership;
    }

    public String getMembershipType() {
        return membershipType;
    }

    public int getAge() {
        return age;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getBirthDateFormat() {
        return birthDateFormat;
    }

    public String getActive() {
        return active;
    }
    public String getPassive() {
        return passive;
    }

    public void setMembershipType(){
        this.membershipType = membershipType;
    }

    public String activitiesForm(){
        if (name == active){
            return membershipType;
        } else if (name == passive) {
            return membershipType;
        } else if (name == inactive) {
            return membershipType;
        } return "";
    }


}




