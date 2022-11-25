import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class FileHandlerTest {
    FileHandler fileHandler = new FileHandler();
    File file = new File("Delfin.csv");

    @BeforeEach
    void setUp(){
        fileHandler = new FileHandler();
        file = fileHandler.getFile();
    }

    @Test
    void loadFile() {
        //ArrayList<Member> membersC = fileHandler.loadFileC();
        //ArrayList<Member> membersE = fileHandler.loadFileE();
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

}
