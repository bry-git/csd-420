package main;

import java.util.Comparator;

public class Util {

    public static <E> void bubbleSort(E[] list, Comparator<? super E> comparator) {
        boolean needsNextPass = true;

        for (int i = 1; i < list.length && needsNextPass; i++) {
            needsNextPass = false;
            for (int j = 0; j < list.length - i; j++) {
                if(comparator.compare(list[j], list[j + 1]) > 0)
                    //return of .compare is -1, 0, or 1 based on -lt, -eq, or -gt
                {
                    //swap 2 values
                    E temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;

                    needsNextPass = true;
                }
            }
        }
    }

    public static <E extends Comparable<E>> void bubbleSort(E[] list) {
        bubbleSort(list, (o1, o2) -> ((Comparable<E>)o1).compareTo(o2));
    }

}


