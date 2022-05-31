/**
 * bryson crandall CSD420
 * */

package test;

import main.DataGenerator;
import main.DataReader;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import static org.junit.Assert.assertTrue;

public class DataWriterReaderTest {

    DataGenerator generator = new DataGenerator();
    DataReader reader = new DataReader(generator.generate());

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @Test
    public void createsFile() {
        File file = new File(System.getProperty("user.dir") + "/bc-datafile.dat");
        assertTrue(file.exists());
    }

    /**
     * test programs that only System.out https://www.baeldung.com/java-testing-system-out-println
     * */

    @Test
    public void readsData() {
        //TODO: test doesnt do anything yet
        System.setOut(new PrintStream(outputStreamCaptor));
        reader.read();

        System.out.println(outputStreamCaptor.toString().trim());
    }
}
