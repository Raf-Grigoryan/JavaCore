package homework.market.service;

import homework.market.model.order.Order;

public interface OrderService {

    void printOrders();

    void add(Order order);

    Order getOrderById(String id);

    boolean isEmpty();

    void printPaymentMethods();

    void getOrdersByUserId(String userId);

    boolean isEmpty(String userId);
}
