package project.java;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        int[] array = {1, 3, 5, 6, 7};
        int value = Arrays.binarySearch(array, 4);
        System.out.println(value);
    }
}
