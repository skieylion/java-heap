package project.java;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Set;
import java.util.stream.Collectors;

public class CustomVowelComparator implements Comparator<String> {

    private static final Set<String> VOWELS = Set.of("a", "e", "i", "o", "u", "y");

    @Override
    public int compare(String str1, String str2) {
        int count1 = getCountVowels(str1);
        int count2 = getCountVowels(str2);
        if (count1 == count2) {
            String vowels1 = getOnlyVowels(str1);
            String vowels2 = getOnlyVowels(str2);
            return count1 == 0 || vowels1.equals(vowels2) ?
                    str1.compareTo(str2) : vowels1.compareTo(vowels2);
        }
        return count1 > count2 ? 1 : -1;
    }

    private static int getCountVowels(String word) {
        return getOnlyVowels(word).length();
    }

    private static String getOnlyVowels(String str) {
        return Arrays.stream(str.split(""))
                .filter(VOWELS::contains)
                .collect(Collectors.joining());
    }
}
