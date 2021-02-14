package rsp.ebook.dao;

import rsp.ebook.entity.Item;

import java.util.List;

public interface ItemDao {
    void deleteOrderItem(List<Item> items);

    void update(Item oi);

    void saveOrderItem(Long orderId, Long bookId, int amount, double price);
}
