package by.mozolevskij.pharmacy.example.functional.supplier;

import java.util.ArrayList;

public class Main {
    //Поставщик
    //ничего не принимает, возвращает объект типа Т
    public static void main(String[] args) {
        ArrayList<String> nameList = new ArrayList<>();
        nameList.add("Elena");
        nameList.add("John");
        nameList.add("Alex");
        nameList.add("Jim");
        nameList.add("Sara");
        Supplier1<String> supplier1 = () -> {
            int i = (int) (Math.random()*nameList.size());
            return nameList.get(i);
        };
    }

}

@FunctionalInterface
interface Supplier1<T> {
    T get();
}
