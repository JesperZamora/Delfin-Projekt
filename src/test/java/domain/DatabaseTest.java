package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ui.UserInterface;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseTest {
    UserInterface ui;

    @BeforeEach
    void setUp() {
        ui = new UserInterface();
        ui.getController().getMembers().clear();
        ui.getController().addExerciser("Jesper", LocalDate.of(1999, 05, 20), 20, "vange", "active");
        ui.getController().getMembers().get(0).setIsPaid(true);
    }

    @Test
    void sumOfSubscriptions() {
        // Act
        int actual = ui.getController().getSumOfSubscriptions(ui.getController().getMembers());
        // db.sumOfSubscriptions(ui.getController().getMembers());
        int expected = 1600;
        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void memberSize1(){
        assertEquals(1, ui.getController().getMembers().size());
    }

    @Test
    void memberSizeNotEmpy(){
        assertNotEquals(0, ui.getController().getMembers().size());
    }
}