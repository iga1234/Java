import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import java.rmi.NoSuchObjectException;

import static org.junit.Assert.*;

public class SecretaryTest {

    @Test
    public void testSaveSecretary() throws IOException {
        Secretary secretary = new Secretary();
        secretary.save("C:\\Users\\iga04\\Desktop\\iga.txt");
    }

    @Test
    public void testLoadSecretary() throws IOException {
        Secretary secretary = new Secretary();
        secretary.log("event");
        secretary.save("C:\\Users\\iga04\\Desktop\\iga.txt");
        secretary.load("C:\\Users\\iga04\\Desktop\\iga.txt");

        assertEquals(secretary.events.get(0), "event");

    }
}
