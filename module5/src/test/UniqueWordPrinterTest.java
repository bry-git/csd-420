package test;

import org.testng.annotations.Test;
import static org.junit.Assert.*;
import main.UniqueWordParser;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class UniqueWordPrinterTest {

    @Test
    public void testOutput() {
        LinkedHashSet<String> results = UniqueWordParser.parse(new File("collection_of_words.txt"), true);
        StringBuilder sb = new StringBuilder();
        for(String s : results) {
            sb.append(s + " ");
        }
        System.out.println(sb);
        assertFalse(sb.isEmpty());
    }

    @Test
    public void returnsUniqueWordsOnly() {
        // instantiate String of read txt file
        // int word count of original
        StringBuilder testString = new StringBuilder();
        int testWordCount = 0;
        try {
            Scanner s = new Scanner(new File("collection_of_words.txt"));
            while (s.hasNext()) {
                testString.append(s.next().replace(",", "").replace(".", ""));
                testWordCount++;
            }
        } catch (IOException e) {
            //fail the test but continue test suite
            fail();
        }

        // run uwp.parse and assign to string
        // int of word count of parsed file
        LinkedHashSet<String> results = UniqueWordParser.parse(new File("collection_of_words.txt"), false);
        StringBuilder resultString = new StringBuilder();
        int parsedWordCount = 0;
        for(String s : results) {
            resultString.append(s);
            parsedWordCount++;
        }
        // assert original String[] != parsed String[]
        // get word count of parsed textfile and assert != to above count
        assertNotEquals(testWordCount, parsedWordCount);
        assertNotEquals(testString, resultString);
    }

    @Test
    public void reversesInput() {
        String testString = "error called which its obtain able shouldn't sum algebraic differentiating vice-versa should " +
                "subtracts reason within just sure obtained information of some modified Because as works scenario computer" +
                " know also must However GEA by corrected may too factor significant be considered If between being variation" +
                " acquired has system not in event In was follows that Consequently now wasn't arriving and position the drive" +
                " commands corrective generate to deviations uses subsystem guidance deviation difference a obtains greater)" +
                " (whichever or from subtracting By isn't because this It times all at is it where knows missile The ";

        LinkedHashSet<String> result = UniqueWordParser.parse(new File("collection_of_words.txt"), true);
        StringBuilder resultString = new StringBuilder();
        for(String s : result) {
            resultString.append(s + " ");
        }

        assertEquals(testString, resultString.toString());
    }
}
