package project.java;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class App {

    public static void main(String[] args) {
        List<String> array = List.of("H", "e", "l", "l", "o", "W", "o", "r", "l", "d");
        var result = array.stream()
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append);
        System.out.println(result);
    }
}