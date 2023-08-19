package project.java;

import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) {
        toCollection();
        joining();
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