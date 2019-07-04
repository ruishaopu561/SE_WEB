package rsp.demo1.daoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import rsp.demo1.dao.OrderItemDao;
import rsp.demo1.entity.OrderItem;
import rsp.demo1.repository.BookRepository;
import rsp.demo1.repository.OrderItemRepository;

import java.util.List;

@Repository
public class OrderItemDaoImpl implements OrderItemDao {

    @Autowired
    private OrderItemRepository oip;

    @Autowired
    private BookRepository bp;

    @Override
    public void deleteOrderItem(List<OrderItem> orderItems){
        try{
            for (OrderItem oi : orderItems) {
                oip.deleteById(oi.getId());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(OrderItem oi){
        oip.saveAndFlush(oi);
    }

    @Override
    public void saveOrderItem(Long orderid, Long bookid, int amount, double price)
    {
        OrderItem orderItem = new OrderItem();
        orderItem.setOrderID(orderid);
        orderItem.setBook(bp.findBookById(bookid));
        orderItem.setAmount(amount);
        orderItem.setValue(amount*price);
        oip.saveAndFlush(orderItem);
        System.out.println(orderItem.getId());
    }
}
