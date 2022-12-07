package domain;

import java.time.LocalDate;

public class Exerciser extends Member {
    public Exerciser(String name, LocalDate birthDate, int phoneNumber, String address, String memberStatus) {
        super(name, birthDate, phoneNumber, address, memberStatus);
        setMembershipType("Exerciser");
    }
}