package by.mozolevskij.pharmacy.example.generics;

import java.util.Collection;
import java.util.List;

public class SomeType<T> {
    public <E> void test(Collection<E> collection) {
        for (E element : collection) {
            System.out.println(element);
        }
    }
    public void test(List<Integer> collection) {
        for (Integer element : collection) {
            System.out.println(element);
        }
    }
}

class Box<T, M> {

    private T item;

    public double getItemWeight() {
        // не скомпилируется
        return item == null ? 0 : 1;
    }
//... остальные методы
}
