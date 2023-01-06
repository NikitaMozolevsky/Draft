package by.mozolevskij.pharmacy.example.functional.predicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    //Сказуемое
    //checking compliance with a certain condition
    //проверка соблюдения некоторого условия
    public static void main(String[] args) {
        Predicate1<Integer> predicate = x -> x%2==0;

        System.out.println(predicate.test(4));
        System.out.println(predicate.test(10));


        List<Integer> list = List.of(4, 55, 66, 7, 4, 88);
        List<Integer> list2 = new ArrayList<>();
        List<Integer> list1 = list.stream()
                .filter(i -> i % 2==0)
                .collect(Collectors.toList());
    }

    public void predicateMethodFirst(List<String> stringList) {
        System.out.println((stringList.stream())
                .filter(((Predicate<String>) s -> s.length()>(10)).and(s -> s.length()>8)));
    }
}

@FunctionalInterface
interface Predicate1<T> {
    boolean test(T t);
}
