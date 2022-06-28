package test;

import main.Util;
import org.junit.Assert;
import org.testng.annotations.Test;


public class BubbleSortTest {

    @Test
    public void sortsIntegers() {
        Integer[] nums = {2, 6, 3, 8, 9, 7, 1, 5, 4}; //need to use Integer object wrapper class

        Util.bubbleSort(nums);

        Integer[] sorted = {1,2,3,4,5,6,7,8,9};

        Assert.assertArrayEquals(nums, sorted);
    }

    @Test
    public void sortsStrings() {
        String[] names = {"alice", "bob", "zach", "jeffery", "James"};

        Util.bubbleSort(names, (o1, o2) -> o1.compareToIgnoreCase(o2));

        String[] sorted = {"alice", "bob", "James", "jeffery", "zach"};

        Assert.assertArrayEquals(names, sorted);
    }
}
