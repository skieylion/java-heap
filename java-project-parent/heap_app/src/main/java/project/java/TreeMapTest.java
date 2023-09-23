package project.java;

import java.util.TreeMap;

public class TreeMapTest {

    public static void testCustomComparator(CustomVowelComparator comparator) {
        TreeMap<String, String> map = new TreeMap<>(comparator);

        map.put("apple", "apple");
        map.put("banana", "banana");
        map.put("cherry", "cherry");
        map.put("date", "date");
        map.put("kiwi", "kiwi");
        map.put("grape", "grape");
        map.put("ace", "ace");

        String[] expectedOrder = {"ace", "apple", "date", "grape", "cherry", "kiwi", "banana"};

        int index = 0;
        var r = map.keySet();
        for (String key : map.keySet()) {
            if (!key.equals(expectedOrder[index])) {
                System.out.println("Test failed! Expected " + expectedOrder[index] + " but got " + key);
                return;
            }
            index++;
        }
        System.out.println("Test passed!");
    }

    public static void main(String[] args) {
        testCustomComparator(new CustomVowelComparator());
    }
}
