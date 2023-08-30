package project.java;

import java.util.AbstractMap;
import java.util.NavigableMap;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {
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

    public static void main(String[] args) {
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(1, "Karl");
        treeMap.put(3, "Simon");
        treeMap.put(2, "Pen");
        treeMap.put(10, "Alex");


        System.out.println(maxRepeating("aaabaaaabaaabaaaabaaaabaaaabaaaaba", "aaaba"));
    }

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
