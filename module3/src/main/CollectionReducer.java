/**
 * bryson crandall module 3 CSD420
 * */

package main;

import java.util.ArrayList;

public class CollectionReducer<T> extends ArrayList<T> {

    public static  <T> ArrayList<T> removeDuplicates(ArrayList<T> list) {
            ArrayList<T> mirror = new ArrayList<>();
            for (T t : list) {
                if (mirror.contains(t)) {
                    continue;
                }
                mirror.add(t);
            }
            return mirror;
    }
}
