package by.mozolevskij.pharmacy.example.collection;

import com.google.protobuf.MapEntry;

import java.util.*;
import java.util.stream.Collectors;

public class Sorter {
    Map<String, Integer> sortByValue(Map<String, Integer> map) {
        Map<String, Integer> sortedMap = new TreeMap<>(new MapComparator(map));
        sortedMap.putAll(map);
        return sortedMap;
    }

    class MapComparator implements Comparator<String> {

        private Map<String, Integer> map;

        public MapComparator(Map<String, Integer> map) {
            this.map = map;
        }

        @Override
        public int compare(String o1, String o2) {
            return map.get(o1) - map.get(o2);
        }

        @Override
        public boolean equals(Object obj) {
            return false;
        }
    }
}
