package rsp.demo1.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rsp.demo1.dao.BookDao;
import rsp.demo1.dao.OrderDao;
import rsp.demo1.dao.OrderItemDao;
import rsp.demo1.dao.UserDao;
import rsp.demo1.entity.Orders;
import rsp.demo1.service.OrderService;

import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao od;

    @Autowired
    private BookDao bd;

    @Autowired
    private OrderItemDao oid;

    @Autowired
    private UserDao ud;

    @Override
    public Iterable<Orders> getOrders(Map<String, String> map){
        try{
            System.out.println(map);
            Long userID = Long.parseLong(map.get("userID"));
            int p =  Integer.parseInt(map.get("paied"));
            System.out.println(userID);
            System.out.println(p);
            return od.queryForUser(userID, p > 0);
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Iterable<Orders> getAllOrders(){
        return od.queryAllOrders();
    }

    @Override
    public void update(Orders order){od.update(order);}

    @Override
    public void modifyOrder(Orders order){
        System.out.println(order);
        bd.modifyBook(order.getOrderItems());
        od.modifyPaied(order.getId());
    }

    @Override
    public void deleteOrder(Orders order){
        try{
            oid.deleteOrderItem(order.getOrderItems());
            od.deleteOrder(order.getId());
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void addOrder(List<Map<String, String>> maps){
        try{
            double allValue = 0;
            Long orderid = 0L;
            Long userid = 0L;

            for(Map<String, String> map:maps){
                System.out.println(map);
                int amount = Integer.parseInt(map.get("amount"));
                userid = Long.parseLong(map.get("userID"));
                double price = Integer.parseInt(map.get("price"));
                allValue += amount * price;
            }

            System.out.println(userid);
            System.out.println(allValue);
            orderid = od.saveNewOrder(userid, allValue);
            System.out.println(orderid);

            for(Map<String, String> map:maps){
                Long bookid = Long.parseLong(map.get("bookID"));
                int amount = Integer.parseInt(map.get("amount"));
                double price = Integer.parseInt(map.get("price"));
                oid.saveOrderItem(orderid, bookid, amount, price);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
