package project.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String expression = reader.readLine();
            char[] chars = expression.toCharArray();
            int i = 0, j = chars.length - 1;
            while (i < j) {
                if (!isValid(chars[i])) {
                    i++;
                } else if (!isValid(chars[j])) {
                    j--;
                } else if (Character.toLowerCase(chars[i]) == Character.toLowerCase(chars[j])) {
                    i++;
                    j--;
                } else {
                    System.out.println("False");
                    return;
                }
            }
            System.out.println("True");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static boolean isValid(char ch) {
        return ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z' || ch >= '0' && ch <= '9';
    }


    static short[] neighbors(short[][] matrix, short n, short m, short x, short y) {
        short s = 0;
        short[] neighbors = new short[4];

        if (x - 1 >= 0) {
            neighbors[s++] = matrix[x - 1][y];
        }
        if (x + 1 < n) {
            neighbors[s++] = matrix[x + 1][y];
        }
        if (y - 1 >= 0) {
            neighbors[s++] = matrix[x][y - 1];
        }
        if (y + 1 < m) {
            neighbors[s++] = matrix[x][y + 1];
        }

        return Arrays.copyOf(neighbors, s);
    }

    static void print(short[] neighbors) {
        for (short neighbor : neighbors)
            System.out.print(neighbor + " ");
    }

    public static int maxRepeating(String sequence, String word) {
        int currentIndex = 0;
        int index = 0;
        int max = 0;
        int offset = word.length();
        while (index < sequence.length() && (currentIndex = sequence.indexOf(word, index)) > -1) {
            int n = 0;
            int startIndex = currentIndex;
            int endIndex = currentIndex + offset;
            do {
                var sub = sequence.substring(startIndex, endIndex);
                if (word.equals(sub)) {
                    max = Math.max(++n, max);
                } else {
                    break;
                }
                startIndex += offset;
                endIndex += offset;
            } while (endIndex <= sequence.length());
            index = currentIndex + 1;
        }
        return max;
    }

//    public static void main(String[] args) {
//        NavigableMap<Number, String> map = new TreeMap<>();
//        map.put(1, "Simon");
//        map.put(2, "Red");
//        map.put(3, "White");
//
//        map.ceilingEntry(null);
//
//
//        TreeMap<Integer, String> treeMap = new TreeMap<>();
//        treeMap.put(1, "Karl");
//        treeMap.put(3, "Simon");
//        treeMap.put(2, "Pen");
//        treeMap.put(10, "Alex");
//
//
//        System.out.println(maxRepeating("aaabaaaabaaabaaaabaaaabaaaabaaaaba", "aaaba"));
//    }

    static void toCollection() {
        Set<String> treeSet = Stream.of("D", "X", "F", "A").collect(Collectors.toCollection(TreeSet::new));
        treeSet.forEach(System.out::print);
        System.out.println();
    }

    static void joining() {
        String symbols = Stream.of("D", "X", "F", "A").collect(Collectors.joining());
        System.out.println(symbols);
        String symbols2 = Stream.of("D", "X", "F", "A").collect(Collectors.joining("-"));
        System.out.println(symbols2);
        String symbols3 = Stream.of("D", "X", "F", "A").collect(Collectors.joining("-", "[", "]"));
        System.out.println(symbols3);
    }
}
