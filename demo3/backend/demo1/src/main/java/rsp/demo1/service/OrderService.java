package rsp.demo1.service;

import rsp.demo1.entity.Orders;

import java.util.List;
import java.util.Map;

public interface OrderService {

    Iterable<Orders> getOrders(Map<String, String> map);

    void update(Orders order);

    void modifyOrder(Orders order);

    void deleteOrder(Orders order);

    void addOrder(List<Map<String, String>> maps);
}
