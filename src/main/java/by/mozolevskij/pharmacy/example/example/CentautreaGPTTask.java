package by.mozolevskij.pharmacy.example.example;

import java.util.Arrays;
import java.util.Comparator;

public class CentautreaGPTTask {

    public static String sortWordsByVowels(String[] words) {
        Arrays.sort(words, (a, b) -> {
            int vowelsInA = countVowels(a);
            int vowelsInB = countVowels(b);
            return Integer.compare(vowelsInA, vowelsInB);
        });
        return String.join(" ", words);
    }

    public static int countVowels(String word) {
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            char c = Character.toLowerCase(word.charAt(i));
            if ("aeiou".indexOf(c) != -1) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String[] words =
                {"apple", "banana", "some", "aaaa", "aaa", "aaaaa"};
        String result = sortWordsByVowels(words);
        System.out.println(result);
    }

}
