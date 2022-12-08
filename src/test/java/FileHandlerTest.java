import datasource.FileHandler;
import domain.Database;
import domain.Member;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ui.UserInterface;

import java.io.File;
import java.time.LocalDate;
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
        ui.getController().getMembers().clear();
        ui.getController().addExerciser("Jesper", LocalDate.of(1999, 5, 20), 20, "vange", "active");
    }

    @Test
    void loadFile() {
        ArrayList<Member> membersC = fileHandler.loadFile();
        ArrayList<Member> membersE = fileHandler.loadFile();
        assertEquals(0, membersC.size(), membersE.size());
    }

    @Test
    void saveFile(){
        long t1 = file.lastModified();
        ArrayList<Member> files = new ArrayList<>();
        fileHandler.saveFile(files);
        long t2 = file.lastModified();
        assertNotEquals(t1,t2);
    }



}

