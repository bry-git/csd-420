/**
 * bryson crandall CSD420
 * */

package main;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        DataGenerator generator = new DataGenerator();
        File data = generator.generate();

        DataReader reader = new DataReader(data);
        reader.read();
    }
}
