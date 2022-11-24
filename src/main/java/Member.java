import com.beust.jcommander.IStringConverter;

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

    public abstract void ageCalculator();
    public abstract void formatBirthDate();

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

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public String getAddress() {
        return address;
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




