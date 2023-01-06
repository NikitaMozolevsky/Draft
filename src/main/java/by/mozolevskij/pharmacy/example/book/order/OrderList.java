package by.mozolevskij.pharmacy.example.book.order;

import java.util.ArrayList;
import java.util.List;

public class OrderList {
    private List<Order> orders;
    public OrderList() {
        orders = new ArrayList<Order>();
    }

    public OrderList(List<Order> orders) {
        this.orders = orders;
    }

    public List<Order> getOrders() {
        return List.copyOf(orders);
    }
}
