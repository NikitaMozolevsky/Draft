package by.mozolevskij.pharmacy.example.collection;

import java.util.Map;

public class MapComparator {
    public static void main(String[] args) {
        Map<String, Integer> map = Map.of(
                "Two", 2,
                "Three", 3,
                "Five", 5,
                "One", 1,
                "Four", 4
        );
        map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue()).forEach(System.out::println);
    }
}

