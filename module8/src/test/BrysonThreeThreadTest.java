package test;

import csd420.BrysonThreeThread;
import org.junit.Assert;
import org.testng.annotations.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.concurrent.TimeUnit;

public class BrysonThreeThreadTest {
    private final PrintStream originalOut = System.out;

    @Test
    public void producesEnoughOutput() {
        BrysonThreeThread btt = new BrysonThreeThread();
        ByteArrayOutputStream output = btt.run();

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            Assert.fail();
        }

        Assert.assertTrue((output.toString().length()) > (10000 * 3));
        System.setOut(originalOut);
    }

    @Test
    public void producesCorrectCharacters() {
        BrysonThreeThread btt = new BrysonThreeThread();
        ByteArrayOutputStream output = btt.run();

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            Assert.fail();
        }

        System.setOut(originalOut);
        String outputs = output.toString();
        String[] assertions = "abcdefghizklmnopqrstuvwxzy1234567890!@#$%^&*(){}:/><\"+=-~".split("");
        for (int i = 0; i < assertions.length; i++ ) {
            boolean result = outputs.contains(assertions[i]);
            if(result){
                System.out.println("Assertion #" + i + " : " + assertions[i] + " = " + result);
            } else {
                System.out.println("Assertion #" + i + " : " + assertions[i] + " = " + result);
                Assert.fail();
            }
        }
    }
}
