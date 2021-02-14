package rsp.ebook.service;

import rsp.ebook.entity.Order;

import java.util.List;
import java.util.Map;

public interface OrderService {

    Iterable<Order> getOrders(Map<String, String> map);

    void update(Order order);

    void modifyOrder(Order order);

    void deleteOrder(Order order);

    void addOrder(List<Map<String, String>> maps);

    Iterable<Order> getAllOrders();
}
