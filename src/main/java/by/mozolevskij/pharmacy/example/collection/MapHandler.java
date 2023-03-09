package by.mozolevskij.pharmacy.example.collection;

import java.util.*;
import java.util.stream.Collectors;

public class MapHandler {

    public static void main(String[] args) {
        MapHandler mapHandler = new MapHandler();
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "string 1");
        map.put(2, "string 2");
        map.put(3, "string 3");

        mapHandler.simpleIterator(map);
        mapHandler.iterationWithIteratorInterface(map);
        mapHandler.convertMapToList(map);
    }


    /**
     *
     *
     *
     * */

    //перебор всех элементов Map без итератора
    void simpleIterator(Map<Integer, String> map) {
        map.put(1, "string 3");
        map.put(2, "string 3");
        map.put(3, "string 1");
        map.put(6, "string 2");
        map.put(7, "string 3");
        map.put(8, "string 3");
        map.put(9, "string 3");
        map.put(4, "string 2");
        map.put(5, "string 2");
        for(Map.Entry<Integer, String> entry : map.entrySet()) {
            Integer key = entry.getKey();
            String value = entry.getValue();
        }
    }

    //перебор всех элементов с итератором
    void iterationWithIteratorInterface(Map<Integer, String> map) {
        Iterator<Map.Entry<Integer, String>> mapIterator = map.entrySet().iterator();

        if (mapIterator.hasNext()) {
            Map.Entry<Integer, String> entry = mapIterator.next();

            Integer integer = entry.getKey();
            String string = entry.getValue();
            System.out.println(integer + " " + string);
        }
    }

    //конвертировать map в list
    void convertMapToList(Map<Integer, String> map) {

        List<String> stringList = map.values().stream().toList();
        List<String> stringList1 = new ArrayList<>(map.values());//second way

        List<Integer> integerList = map.keySet().stream().toList();
        List<Integer> integerList1 = new ArrayList<>(map.keySet());//second way

        //Entry list
        List<Map.Entry<Integer, String>> entryList = new ArrayList<>(map.entrySet());
        List<Map.Entry<Integer, String>> entryList1 = map.entrySet().stream().toList();//second way

    }

    //сортировка Map
    void sortMap(Map<Integer, String> map) {

        //получение map -> stream -> map
        Map<Integer, String> stringMap = map.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    }

}
