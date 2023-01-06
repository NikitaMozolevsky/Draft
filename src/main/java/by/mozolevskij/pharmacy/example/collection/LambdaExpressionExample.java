package by.mozolevskij.pharmacy.example.collection;

import java.util.ArrayList;
import java.util.function.Supplier;

public class LambdaExpressionExample {
    public static void main(String[] args) {
        ArrayList<String> nameList = new ArrayList<>();
        nameList .add("Elena");
        nameList .add("John");
        nameList .add("Alex");
        nameList .add("Jim");
        nameList .add("Sara");

        Supplier<String> randomName = () -> {
            int value = (int)(Math.random() * nameList.size());
            return nameList.get(value);
        };

        System.out.println(randomName.get());
    }



    @FunctionalInterface
    interface SomeInterface {
        void someAction();
    }

    public class PredicateInterface {

        @FunctionalInterface
        interface Predicate<T> {
            boolean test(T t);
        }

        public static void main(String[] args) {
            Predicate<Integer> predicate = a -> a%2 == 0;

            System.out.println(predicate.test(2));

        }
    }
}
