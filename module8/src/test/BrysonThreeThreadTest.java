package test;

import csd420.BrysonThreeThread;
import org.junit.Assert;
import org.testng.annotations.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.concurrent.TimeUnit;

public class BrysonThreeThreadTest {

    private final ByteArrayOutputStream outputStorage = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Test
    public void producesEnoughOutput() {

        BrysonThreeThread btt = new BrysonThreeThread(outputStorage);
        ByteArrayOutputStream output = btt.run();

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            Assert.fail();
        }

        //Assert.assertTrue((outContent.toString().length()) > (10000 * 3));
        //System.setOut(originalOut);
        System.out.println("SEARCHFORME : " + output);
        System.out.println(output.toString().length());
    }

//    @Test
//    public void producesCorrectCharacters() {
//        //BrysonThreeThread.run(outContent);
//
//        try {
//            TimeUnit.SECONDS.sleep(3);
//        } catch (InterruptedException e) {
//            Assert.fail();
//        }
//    }

}
