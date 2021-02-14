package rsp.ebook.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rsp.ebook.dao.BookDao;
import rsp.ebook.dao.ItemDao;
import rsp.ebook.entity.Item;
import rsp.ebook.service.ItemService;

import java.util.Map;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemDao oid;

    @Autowired
    private BookDao bd;

    @Override
    public void addOrderItem(Map<String, String> map){
        try{
            Long orderid = Long.parseLong(map.get("orderID"));
            Long bookid = Long.parseLong(map.get("bookID"));
            int amount = Integer.parseInt(map.get("amount"));
            double value = Integer.parseInt(map.get("value"));

            System.out.println(orderid);
            System.out.println(bookid);
            System.out.println(amount);
            System.out.println(value);

            Item oi = new Item();
            oi.setOrderId(orderid);
            oi.setBook(bd.queryBook(bookid));
            oi.setAmount(amount);
            oi.setValue(value);

            oid.update(oi);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
