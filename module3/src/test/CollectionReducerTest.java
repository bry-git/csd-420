/**
 * bryson crandall module 3 CSD420
 * */

package test;

import org.testng.annotations.Test;
import static org.junit.Assert.*;
import main.CollectionReducer;

import java.util.ArrayList;
import java.util.Random;

public class CollectionReducerTest {

    private class Dog {

        private String name;
        private String breed;

        public Dog(String name, String breed) {
            name = name;
            breed = breed;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getBreed() {
            return breed;
        }

        public void setBreed(String breed) {
            this.breed = breed;
        }

        @Override
        public String toString() {
            return "Dog{" +
                    "name='" + name + '\'' +
                    ", breed=" + breed +
                    '}';
        }
    }

    private class Cat {

        private String name;
        private String breed;

        public Cat(String name, String breed) {
            this.name = name;
            this.breed = breed;
        }

        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getBreed() {
            return breed;
        }

        public void setBreed(String breed) {
            this.breed = breed;
        }

        @Override
        public String toString() {
            return "cat{" +
                    "name='" + name + '\'' +
                    ", breed=" + breed +
                    '}';
        }
    }

    @Test
    public void usesGeneric() {
        CollectionReducer<Dog> dogs = new CollectionReducer<>();
        dogs.add(new Dog("spot", "hound"));
        assertEquals(dogs.get(0).getClass(), Dog.class);

        CollectionReducer<Cat> cats = new CollectionReducer<>();
        cats.add(new Cat("winnie", "tabby"));
        assertEquals(cats.get(0).getClass(), Cat.class);
    }

    @Test
    public void removesDuplicates() {
        Random r = new Random();
        ArrayList<Integer> numbers = new ArrayList<>();

        for(int i = 0; i < 50; i++) {
            numbers.add(r.nextInt(20 - 1) + 1);
        }

        assertEquals(numbers.size(), 50);

        for(Integer i : numbers) {
            assertTrue(i >= 1 && i <= 20);
        }

        ArrayList<Integer> reduced = CollectionReducer.removeDuplicates(numbers);
        assertNotEquals(reduced, numbers);
        assertTrue(numbers.containsAll(reduced));
        assertFalse(reduced.contains(numbers));
    }
}
