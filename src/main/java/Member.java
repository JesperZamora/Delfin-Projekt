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
    private String hasPaid = "true";

    public Member(String name, LocalDate birthDate, int phoneNumber, String address, String memberStatus) {
        this.name = name;
        setBirthDate(birthDate);
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.memberStatus = memberStatus;
        this.hasPaid = hasPaid;
        this.subscriptionPrice = subscriptionPrice;
        membershipByAge();
        formatBirthDate();
        subscriptionPrice();
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
                        Member status:   %s 
                        Subscription:    %d
                        Payment:         %s
                        
                        \n""",
                name, age, birthDateFormat, phoneNumber, address, membershipByAge, membershipType, memberStatus, subscriptionPrice, hasPaid);
    }

    public String getName() {
        return name;
    }
    public void subscriptionPrice() {
        if(memberStatus.equalsIgnoreCase("passive")) {
            setSubscriptionPrice(500);
        }
        else if(memberStatus.equalsIgnoreCase("inactive")) {
            setSubscriptionPrice(0);
        }
        else if (age > 18 && age < 60) {
            setSubscriptionPrice(1600);
        }
        else if (age < 18) {
            setSubscriptionPrice(1000);
        }
        else if(age > 60) {
            setSubscriptionPrice(1200);
        }

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
    public void setSubscriptionPrice(int subscriptionPrice1) {
        subscriptionPrice = subscriptionPrice1;
    }
    public void setHasPaid(String hasMemberPaid) {
        hasPaid = hasMemberPaid;
    }
    public String getHasPaid() {
        return hasPaid;
    }
    public int getSubscriptionPrice() {
        return subscriptionPrice;
    }
}




