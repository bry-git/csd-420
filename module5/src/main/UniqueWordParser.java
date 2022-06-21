package main;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class UniqueWordParser {
    public static LinkedHashSet<String> parse(File inputFile, boolean reverse) {
        LinkedHashSet<String> results = new LinkedHashSet<>();
        try {
            Scanner input = new Scanner(inputFile);
            while(input.hasNext()) {
                String word = input.next().replace(",", "").replace(".", "");
                results.add(word);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        if (reverse) {
            List<String> reversed = new ArrayList<>(results);
            Collections.reverse(reversed);
            return new LinkedHashSet<>(reversed);
        }
        return results;
    }
}
