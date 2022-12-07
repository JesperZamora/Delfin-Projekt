package domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class MemberTest {
    CompetitionSwimmer swimmer1;
    CompetitionSwimmer swimmer2;
    Exerciser exerciser1;
    Exerciser exerciser2;
    Exerciser exerciser3;
    Exerciser exerciser4;



    @Test
    void subscriptionPriceUnder18() {
        //Arrange
        swimmer1 = new CompetitionSwimmer("Osama", LocalDate.of(2015, 1, 1), 27146786, "Siciliensgade","Active");

        //Act
        int subscriptionPrice = swimmer1.subscriptionPrice();
        int expected = 1000;
        //Assert
        assertEquals(subscriptionPrice,expected);
    }

    @Test
    void subscriptionPriceFrom18til60() {
        //Arrange
        swimmer2 = new CompetitionSwimmer("Jesper", LocalDate.of(1990, 5, 5), 27146786, "Siciliensgade","Active");

        //Act
        int subscriptionPrice = swimmer2.subscriptionPrice();
        int expected = 1600;
        //Assert
        assertEquals(subscriptionPrice,expected);
    }

    @Test
    void subscriptionPriceOver60() {
        //Arrange
        exerciser1 = new Exerciser("Mathias", LocalDate.of(1950, 2, 2), 27146786, "Siciliensgade","Active");

        //Act
        int subscriptionPrice = exerciser1.subscriptionPrice();
        int expected = 1200;

        //Assert
        assertEquals(subscriptionPrice,expected);
    }

    @Test
    void subscriptionForPassive() {
        //Arrange
        exerciser2 = new Exerciser("Mathias", LocalDate.of(1980, 2, 2), 27146786, "Siciliensgade","Passive");

        //Act
        int subscriptionPrice = exerciser2.subscriptionPrice();
        int expected = 500;

        //Assert
        assertEquals(subscriptionPrice,expected);
    }

    @Test
    void subscriptionForInactiveMembers() {
        //Arrange
        exerciser3 = new Exerciser("Mathias", LocalDate.of(1970, 2, 2), 27146786, "Siciliensgade","Inactive");

        //Act
        int subscriptionPrice = exerciser3.subscriptionPrice();
        int expected = 0;

        //Assert
        assertEquals(subscriptionPrice,expected);
    }



    @Test
    void setActiveMemberToPaid() {
        //Arrange
        exerciser4 = new Exerciser("Osama", LocalDate.of(2015, 1, 1), 27146786, "Siciliensgade","Active");
        boolean paid = true;
        boolean notPaid = false;

        //Act 1
        exerciser4.setIsPaid(paid);
        int subscriptionPrice = exerciser4.subscriptionPrice();
        int expected = 0;

        //Act2
        exerciser4.setIsPaid(notPaid);
        int subscriptionPriceChangedBack = exerciser4.subscriptionPrice();
        int newExpected = 1000;

        //Assert
        assertEquals(subscriptionPrice,expected);
        assertEquals(subscriptionPriceChangedBack,newExpected);

    }

}