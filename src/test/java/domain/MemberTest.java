package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class MemberTest {
    CompetitionSwimmer swimmer1;
    CompetitionSwimmer swimmer2;
    Exerciser exerciser1;
    Exerciser exerciser2;
    Exerciser exerciser3;
    @BeforeEach
    void setup() {
        swimmer1 = new CompetitionSwimmer("Osama", LocalDate.of(2015, 1, 1), 27146786, "Siciliensgade","Active");
        swimmer2 = new CompetitionSwimmer("Jesper", LocalDate.of(1990, 5, 5), 27146786, "Siciliensgade","Active");
        exerciser1 = new Exerciser("Mathias", LocalDate.of(1950, 2, 2), 27146786, "Siciliensgade","Active");
        exerciser2 = new Exerciser("Mathias", LocalDate.of(1980, 2, 2), 27146786, "Siciliensgade","Passive");
        exerciser3 = new Exerciser("Mathias", LocalDate.of(1970, 2, 2), 27146786, "Siciliensgade","Inactive");
    }

    @Test
    void subscriptionPriceUnder18() {
        //Act
        int subscriptionPrice = swimmer1.subscriptionPrice();
        int expected = 1000;
        //Assert
        assertEquals(subscriptionPrice,expected);
    }

    @Test
    void subscriptionPriceFrom18til60() {
        //Act
        int subscriptionPrice = swimmer2.subscriptionPrice();
        int expected = 1600;
        //Assert
        assertEquals(subscriptionPrice,expected);
    }

    @Test
    void subscriptionPriceOver60() {
        //Act
        int subscriptionPrice = exerciser1.subscriptionPrice();
        int expected = 1200;

        //Assert
        assertEquals(subscriptionPrice,expected);
    }

    @Test
    void subscriptionForPassive() {
        //Act
        int subscriptionPrice = exerciser2.subscriptionPrice();
        int expected = 500;

        //Assert
        assertEquals(subscriptionPrice,expected);
    }

    @Test
    void subscriptionForInactiveMembers() {
        //Act
        int subscriptionPrice = exerciser3.subscriptionPrice();
        int expected = 0;

        //Assert
        assertEquals(subscriptionPrice,expected);
    }

}