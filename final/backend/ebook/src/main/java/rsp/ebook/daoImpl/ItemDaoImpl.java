package rsp.ebook.daoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import rsp.ebook.dao.ItemDao;
import rsp.ebook.entity.Item;
import rsp.ebook.repository.BookRepository;
import rsp.ebook.repository.ItemRepository;

import java.util.List;

@Repository
public class ItemDaoImpl implements ItemDao {

    @Autowired
    private ItemRepository ir;

    @Autowired
    private BookRepository br;

    @Override
    public void deleteOrderItem(List<Item> items){
        try{
            for (Item oi : items) {
                ir.deleteById(oi.getId());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(Item oi){
        ir.saveAndFlush(oi);
    }

    @Override
    public void saveOrderItem(Long orderId, Long bookId, int amount, double price)
    {
        Item orderItem = new Item();
        orderItem.setOrderId(orderId);
        orderItem.setBook(br.findBookById(bookId));
        orderItem.setAmount(amount);
        orderItem.setValue(amount*price);
        ir.saveAndFlush(orderItem);
        System.out.println(orderItem.getId());
    }
}
