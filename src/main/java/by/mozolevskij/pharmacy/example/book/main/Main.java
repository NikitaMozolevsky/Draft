package by.mozolevskij.pharmacy.example.book.main;

import by.mozolevskij.pharmacy.example.book.order.Order;
import by.mozolevskij.pharmacy.example.book.order.OrderType;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        int goodCount1 = 5;
        int goodCount2 = 8;
        List<Order> orderList = new ArrayList<>();
        orderList.add(new Order(213, 2));
        orderList.add(new Order(534, 5));
        orderList.add(new Order(76, 25));
        orderList.add(new Order(987, 8));
        orderList.add(new Order(675, 6));
        orderList.add(new Order(243, 3));

        orderList.forEach(o -> o.setAmount(o.getAmount()+11));
        orderList.removeIf(o -> o.getAmount()<goodCount1);

        List<Order> orderListStream = orderList.stream()
                .filter(o -> o.getAmount()<goodCount2)
                .map(o -> { o.setAmount(o.getAmount()+1);
                return o;})
                .collect(Collectors.toList());


        OrderType orderType1 = new OrderType(21);
        orderType1.add("WE");
        orderType1.add("S");
        orderType1.add("DE");
        orderType1.add("GRE");
        OrderType orderType2 = new OrderType(21);
        orderType2.add("WE");
        orderType2.add("ADS");
        orderType2.add("E");
        orderType2.add("GRE");

        List<String> types = List.of(orderType1, orderType2).stream()
                .peek(o -> System.out.println(o))
                .map(o -> o.getConcurrencyNames())

                .peek(o -> System.out.println(o))
                .flatMap(o -> o.stream())
                .sorted((s1, s2) -> s1.length()-s2.length())
                .peek(o -> System.out.println(o))
                .collect(Collectors.toList());
    }


}
