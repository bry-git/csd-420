/**
 * bryson crandall CSD420
 * */

package main;

import java.io.*;

public class DataReader {
    private File file;
    private FileInputStream fis;
    private BufferedInputStream bis;

    public DataReader(File inputFile) {
        file = inputFile;
    }

    public void read() {
        try {
            fis = new FileInputStream(file);
            bis = new BufferedInputStream(fis);

            while( bis.available() > 0 ){
                System.out.print((char)bis.read());
            }
        }
        catch (FileNotFoundException e) {
            System.out.println(e);
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }
}
