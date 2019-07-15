package rsp.demo1.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rsp.demo1.dao.BookDao;
import rsp.demo1.dao.OrderItemDao;
import rsp.demo1.entity.OrderItem;
import rsp.demo1.service.OrderItemService;

import java.util.Map;

@Service
public class OrderItemServiceImpl implements OrderItemService {

    @Autowired
    private OrderItemDao oid;

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

            OrderItem oi = new OrderItem();
            oi.setOrderID(orderid);
            oi.setBook(bd.queryBook(bookid));
            oi.setAmount(amount);
            oi.setValue(value);

            oid.update(oi);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
