package by.mozolevskij.pharmacy.example.functional.consumer;

import java.util.function.Consumer;

public class Main {
    //Потребитель
    //Совершает некоторые действия и ничего не возвращает
    //Performs some actions and returns nothing
    public static void main(String[] args) {
        Consumer<String> consumer = s -> System.out.println("Hello " + s + " !");
        consumer.accept("Nikita");
    }
}

@FunctionalInterface
interface Consumer1<T> {
    void accept(T t);
}