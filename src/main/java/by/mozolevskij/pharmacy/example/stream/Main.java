package by.mozolevskij.pharmacy.example.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    static List<Integer> list = new ArrayList<>();

    static {
        for (int i = 0; i < 15; i++) {
            list.add((int) (Math.random()*150));
        }
        list.add(list.get(0));
    }

    static int capacity = 20;
    public static void main(String[] args) {
        System.out.println(list);
        task5();
    }

    public static void task1() {

        List<String> strings = list.stream()
                .filter(i -> i > capacity)
                .peek(System.out::print)
                .map(String::valueOf).toList();
        System.out.println();
        System.out.println(strings);
    }

    public static void task2() {
        System.out.println(list.stream()
                .limit(5).toList());
    }

    public static void task3() {
        System.out.println(list.stream()
                .distinct().toList());
    }

    public static void task4() {
        list.stream().forEach(System.out::println);
    }

    public static void task5() {
        System.out.println(list.stream()
                .reduce(0, (n1, n2) -> n1 + n2));
    }
}
