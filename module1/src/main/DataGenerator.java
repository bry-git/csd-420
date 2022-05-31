/**
 * bryson crandall CSD420
 * */

package main;

import java.io.*;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

public class DataGenerator {
    private File file;
    private String path;

    public DataGenerator() {
        path = System.getProperty("user.dir");
        file = new File(path + "/bc-datafile.dat");
    }

    public File generate() {
        Random r = new Random();
        try {
            FileWriter writer = new FileWriter(file);
            int[] integers = new int[5];
            double[] doubles = new double[5];
            for (int i = 0; i < integers.length; i++) {
                integers[i] = r.nextInt(100 - 1) + 1;
                doubles[i] = 1.0 + r.nextDouble() * 10.0;
            }
            writer.write(Arrays.toString(integers) + "\n");
            writer.write(Arrays.toString(doubles) + "\n");

            Date date = new Date();
            writer.write("date is : " + date);

            writer.close();
        } catch (IOException e) {
            System.out.println(e);
        }
        return this.file;
    }
}
