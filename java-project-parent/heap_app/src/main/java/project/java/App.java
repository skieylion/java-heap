package project.java;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class App {

    enum Day {MONDAY, THUESDAY, SUNDAY}

    EnumSet<Day> days = EnumSet.of(Day.MONDAY, Day.SUNDAY, Day.THUESDAY);

    public static void main(String[] args) {
        ArrayList<Number> arrayList = new ArrayList<>();
        arrayList.add(Integer.valueOf(2));


        EnumSet<Day> enumSet = EnumSet.allOf(Day.class);
        System.out.println(enumSet);
        EnumSet<Day> enumSetCopy = EnumSet.copyOf(EnumSet.allOf(Day.class));
        System.out.println(enumSetCopy);
        EnumSet<Day> emptySet = EnumSet.noneOf(Day.class);
        System.out.println(emptySet);
        EnumSet<Day> rangeSet = EnumSet.range(Day.MONDAY, Day.THUESDAY);
        System.out.println(rangeSet);
        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("asd");
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();
    }

    static String convert(String letters) {
        if ("".equals(letters))
            return "";
        StringBuilder builder = new StringBuilder();
        char letter = letters.charAt(0);
        int count = 1;
        for (int i = 1; i < letters.length(); i++) {
            char symbol = letters.charAt(i);
            if (letter != symbol) {
                builder.append(count).append(letter);
                count = 1;
                letter = symbol;
            } else {
                count++;
            }
        }
        builder.append(count).append(letter);
        return builder.toString();
    }

}
