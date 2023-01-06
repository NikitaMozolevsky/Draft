package by.mozolevskij.pharmacy.example.functional.function;

import java.util.function.BiFunction;

public class Main {

    //принимает аргумент T и приводит к объекту типа B

    public static void main(String[] args) {
        Function1<String, Integer> function1 = s -> Integer.valueOf(s);
        Integer i = function1.apply("123");
    }

    public void functionMethodFirst() {
        BiFunction<Double, String, Integer> biFunction = (d, s) ->(Double.toString(d) + s).length();
        int length = biFunction.apply(3.14, "java");
        System.out.println(length);
    }
}

@FunctionalInterface
interface Function1<B, T> {
    T apply (B b);
}