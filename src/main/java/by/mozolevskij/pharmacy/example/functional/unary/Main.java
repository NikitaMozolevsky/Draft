package by.mozolevskij.pharmacy.example.functional.unary;

public class Main {
    public static void main(String[] args) {
        UnaryOperator1<Integer> unaryOperator1 = t -> t*t;
        System.out.println(unaryOperator1.apply(4));
    }

}

@FunctionalInterface
interface UnaryOperator1<T> {
    T apply (T t);
}
