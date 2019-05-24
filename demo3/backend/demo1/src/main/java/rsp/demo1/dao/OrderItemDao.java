package rsp.demo1.dao;

import rsp.demo1.entity.OrderItem;

import java.util.List;

public interface OrderItemDao {
    void deleteOrderItem(List<OrderItem> orderItems);

    void update(OrderItem oi);

    void saveOrderItem(Long orderid, Long bookid, int amount, double price);
}
