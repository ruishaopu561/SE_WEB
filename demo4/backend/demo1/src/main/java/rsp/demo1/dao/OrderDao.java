package rsp.demo1.dao;

import rsp.demo1.entity.Orders;

public interface OrderDao {

    void update(Orders order);

    Iterable<Orders> queryForUser(Long userId, boolean paied);

    void modifyPaied(Long id);

    void deleteOrder(Long id);

    Long saveNewOrder(Long userid, double allValue);

    Iterable<Orders> queryAllOrders();
}
