package by.mozolevskij.pharmacy.example.collection;

import java.util.*;

public class CollectionsExample {
    public static void main(String[] args) {
        CollectionsExample collectionsExample = new CollectionsExample();
        List<Integer> list = Arrays.asList(2, 4, 0, 6, 5, 1);
        System.out.println(collectionsExample.sort(list));
    }

    public Map<Integer, Integer> sort(List<Integer> arrayList) {
        List<Integer> list = new ArrayList<>(arrayList);
        Map<Integer, Integer> integerIntegerMap = new HashMap<>();
        Collections.sort(arrayList);
        arrayList.remove(1);
        return integerIntegerMap;
    }

    public static Integer searchValue(HashMap<Integer, Integer> map, Integer value) {
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> entry = (Map.Entry<Integer, Integer>) iterator.next();
            if (!entry.getValue().equals(value)) {
                map.put(0, 0);

            }
        }
        return value;
    }
}
