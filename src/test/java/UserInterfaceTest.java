import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class UserInterfaceTest {
    UserInterface ui;
    Database db;
// Arrange
    @BeforeEach
    void setUp() {
        ui = new UserInterface();
        db = new Database();
        ui.getController().getMembers().clear();
        ui.getController().addExerciser("Jesper", LocalDate.of(1999, 05, 20), 20, "vange", "active");
    }


    @Test
    void sumOfSubscriptions() {
        // Act
        int actual = db.sumOfSubscriptions(ui.getController().getMembers());
        int expected = 1600;
        // Assert
        assertEquals(expected, actual);
    }


}