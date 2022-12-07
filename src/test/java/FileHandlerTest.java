import datasource.FileHandler;
import domain.Database;
import domain.Member;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ui.UserInterface;

import java.io.File;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class FileHandlerTest {
    UserInterface ui;
    Database db;
    FileHandler fileHandler = new FileHandler();
    File file = new File("Dolphin.csv");

    @BeforeEach
    void setUp(){
        fileHandler = new FileHandler();
        file = fileHandler.getFile();
        db = new Database();
        ui = new UserInterface();
    }

    @Test
    void loadFile() {
        //ArrayList<domain.Member> membersC = fileHandler.loadFileC();
        //ArrayList<domain.Member> membersE = fileHandler.loadFileE();
        //assertEquals(0, membersC.size(), membersE.size());
    }

    @Test
    void saveFile(){
        long t1 = file.lastModified();
        ArrayList<Member> files = new ArrayList<>();
        //fileHandler.saveToFile(files);
        long t2 = file.lastModified();
        assertNotEquals(t1,t2);
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

