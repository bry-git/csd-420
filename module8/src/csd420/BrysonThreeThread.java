package csd420;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * damn
 * **/

public class BrysonThreeThread {
    ByteArrayOutputStream outputStorage;

    public BrysonThreeThread(ByteArrayOutputStream outputStorage) {
        this.outputStorage = outputStorage;
    }

    private static class AlphaGenerator implements Runnable{
        ByteArrayOutputStream outputStorage;

        public AlphaGenerator(ByteArrayOutputStream outputStorage) {
            this.outputStorage = outputStorage;
            System.setOut(new PrintStream(outputStorage));
        }

        @Override
        public void run() {
            String alphabet = "abcdefghijklmnopqrstuvwxyz";
            AtomicInteger alphaPointer = new AtomicInteger(0);
            IntStream.range(1, 100000).forEach((a) -> {
                if(alphaPointer.get() == 26) {
                    alphaPointer.set(0);
                }
                System.out.println(alphabet.charAt(alphaPointer.get()));
                alphaPointer.set(alphaPointer.incrementAndGet());
            });
        }
    }
    private static class NumerGenerator implements Runnable {
        ByteArrayOutputStream outputStorage;

        public NumerGenerator(ByteArrayOutputStream outputStorage) {
            this.outputStorage = outputStorage;
            System.setOut(new PrintStream(outputStorage));
        }

        @Override
        public void run() {
            IntStream.range(1, 100000).forEach((n) -> {
                System.out.println(n);
            });
        }
    }
    private static class SpecialCharGenerator implements Runnable {
        ByteArrayOutputStream outputStorage;

        public SpecialCharGenerator(ByteArrayOutputStream outputStorage) {
            this.outputStorage = outputStorage;
            System.setOut(new PrintStream(outputStorage));
        }

        String specials = "!@#$%^&*(){}:/><\"+=-~";
        AtomicInteger specialsPointer = new AtomicInteger(0);
        @Override
        public void run() {
            IntStream.range(1, 10000).forEach((s) -> {
                if(specialsPointer.get() == 21) {
                    specialsPointer.set(0);
                }
                System.out.println(specials.charAt(specialsPointer.get()));
                specialsPointer.set(specialsPointer.incrementAndGet());
            });

        }
    }

    public ByteArrayOutputStream run() {
        PrintStream originalOut = System.out;

        Thread t1 = new Thread(new AlphaGenerator(this.outputStorage));
        Thread t2 = new Thread(new NumerGenerator(this.outputStorage));
        Thread t3 = new Thread(new SpecialCharGenerator(this.outputStorage));

        t1.start();
        t2.start();
        t3.start();

        System.setOut(originalOut);
        //System.out.println(outputStorage);
        return this.outputStorage;
    }
}
