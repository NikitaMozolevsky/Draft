package by.mozolevskij.pharmacy.example.book.order;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class OrderType implements Iterable<String> {

    private int orderId;
    List<String> concurrencyNames = new ArrayList<>();

    public OrderType(int orderId) {
        this.orderId = orderId;
    }

    public List<String> getConcurrencyNames() {
        return List.copyOf(concurrencyNames);
    }

    public boolean add(String s) {
        return concurrencyNames.add(s);
    }

    @Override
    public Iterator<String> iterator() {
        return concurrencyNames.iterator();
    }
}
