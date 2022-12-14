package domain;

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
    private int subscriptionPrice;
    private boolean isPaid = false;
    private String notPaid;

    public Member(String name, LocalDate birthDate, int phoneNumber, String address, String memberStatus) {
        this.name = name;
        setBirthDate(birthDate);
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.memberStatus = memberStatus;
        this.subscriptionPrice = subscriptionPrice();
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
            this.membershipByAge = "Junior";
        } else {
            this.membershipByAge = "Senior";
        }
    }


    public String toString() {
        if(isPaid){
            this.notPaid = "Paid";
        } else{
            this.notPaid = "Not paid";
        }
        return String.format("Name: %-24s Age: %-5d Birthdate: %-13s Membership: %-9s Type: %-15s Status: %-11s Subscription: %-8d Paid: %-11s Phone: %-11d Address: %s",
                name, age, birthDateFormat, membershipByAge, membershipType, memberStatus, subscriptionPrice, notPaid, phoneNumber, address);
    }


    public int subscriptionPrice() {
        if (memberStatus.equalsIgnoreCase("passive")) {
            subscriptionPrice = 500;
        } else if (memberStatus.equalsIgnoreCase("inactive")) {
            subscriptionPrice = 0;
        } else if (age > 18 && age < 60) {
            subscriptionPrice = 1600;
        } else if (age < 18) {
            subscriptionPrice = 1000;
        } else if (age > 60) {
            subscriptionPrice = 1200;
        }
        return subscriptionPrice;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setIsPaid(boolean isPaid) {
        this.isPaid = isPaid;
        subscriptionPrice();
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

    public String getMembershipType() {
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

    public void setMembershipType(String membershipType) {
        this.membershipType = membershipType;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setMemberStatus(String memberStatus) {
        this.memberStatus = memberStatus;
    }
    public int getSubscriptionPrice() {
        return subscriptionPrice;
    }
}




