package rsp.ebook.dao;

import rsp.ebook.entity.Order;

public interface OrderDao {

    void update(Order order);

    Iterable<Order> queryForUser(Long userId, boolean paied);

    void modifyPaied(Long id);

    void deleteOrder(Long id);

    Long saveNewOrder(Long userid, double allValue);

    Iterable<Order> queryAllOrders();
}
