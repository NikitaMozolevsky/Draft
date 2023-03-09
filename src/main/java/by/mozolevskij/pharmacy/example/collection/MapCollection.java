package by.mozolevskij.pharmacy.example.collection;

import com.google.protobuf.MapEntry;

import java.util.*;

public class MapCollection {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(10, "string 10");
        map.put(1, "string 1");
        map.put(2, "string 2");
        map.put(1000, "string 1000");
        map.put(5, "string 5");
        map.put(100000, "string 100000");
        List list = new ArrayList(map.entrySet());
        /*System.out.println(list);*/
        Collections.sort(list, new Comparator<Map.Entry<Integer, String>>() {
            @Override
            public int compare(Map.Entry<Integer, String> o1, Map.Entry<Integer, String> o2) {
                return o1.getKey() - o2.getKey();
            }
        });
        /*Collections.sort(list, (o1, o2) -> o1.getKey() - o2.getKey());*/
        /*System.out.println(list);*/
        SortedMap<Integer, String> sortedMap = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        Map<Integer, String> sortedMap1 = new TreeMap<>((o1, o2) -> o2 - o1);
        Map<Integer, String> sortedMap2 = new TreeMap<>((o1, o2) -> o1 - o2); //так как стандартная реализациия
        System.out.println(sortedMap1);
        sortedMap.put(12, "fewf12");
        sortedMap.put(14, "fewf14");
        sortedMap.put(1, "fewf1");
        System.out.println(sortedMap);
    }
}
