package listexperiment;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

public class Main {

    private static LinkedList<Integer> generate(int size) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            list.add((Integer) i);
        }
        return list;
    }

    public static void main(String[] args) {
        LinkedList<Integer> list1 = generate(50000);
        Random r = new Random();
        int randomIndex = r.nextInt(50000 - 1) + 1;

        Long start1 = System.currentTimeMillis();
        Iterator<Integer> it = list1.iterator();
        while (it.hasNext()) {
            if (it.next().equals((Integer) randomIndex)) {
                break;
            }
        }
        Long stop1 = System.currentTimeMillis();

        Long start2 = System.currentTimeMillis();
        list1.get(randomIndex);
        Long stop2 = System.currentTimeMillis();

        LinkedList<Integer> list2 = generate(500000);
        Random r2 = new Random();
        int randomIndex2 = r2.nextInt(500000 - 1) + 1;

        Long start3 = System.currentTimeMillis();
        Iterator<Integer> it2 = list1.iterator();
        while (it.hasNext()) {
            if (it.next().equals((Integer) randomIndex2)) {
                break;
            }
        }
        Long stop3 = System.currentTimeMillis();

        Long start4 = System.currentTimeMillis();
        list2.get(randomIndex2);
        Long stop4 = System.currentTimeMillis();

        System.out.println("getting a random index (" + randomIndex + " / 50000) from LinkedList of 50000 via Iterator takes " + (stop1 - start1) + " ms");
        System.out.println("getting the same random index (" + randomIndex + " / 50000) from LinkedList of 50000 via LinkedList.get() takes " + (stop2 - start2) + " ms");
        System.out.println("getting a random index (" + randomIndex2 + " / 500000) from LinkedList of 500000 via Iterator takes " + (stop3 - start3) + " ms");
        System.out.println("getting the same random index (" + randomIndex2 + " / 500000) from LinkedList of 500000 via LinkedList.get() takes " + (stop4 - start4) + " ms");
    }
}


