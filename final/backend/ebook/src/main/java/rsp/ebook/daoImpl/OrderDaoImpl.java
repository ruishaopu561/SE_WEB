package rsp.ebook.daoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import rsp.ebook.dao.OrderDao;
import rsp.ebook.entity.Order;
import rsp.ebook.repository.OrderRepository;
import rsp.ebook.repository.UserRepository;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Optional;

@Repository
public class OrderDaoImpl implements OrderDao {

    @Autowired
    private OrderRepository op;

    @Autowired
    private UserRepository up;

    @Override
    public void update(Order order){op.saveAndFlush(order);}

    @Override
    public Iterable<Order> queryForUser(Long userId, boolean paied){
        return op.findAllByUser_IdAndPaied(userId, paied);
    }

    @Override
    public Iterable<Order> queryAllOrders(){
        return op.findAll();
    }

    @Override
    public void modifyPaied(Long id){
        try{
            Optional<Order> o = op.findById(id);
            if(o.isPresent()){
                Order order = o.get();
                System.out.println(order.getId());
                order.setPaied(true);
                op.saveAndFlush(order);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteOrder(Long id){
        try{
            op.deleteById(id);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public Long saveNewOrder(Long userid, double allValue) {
        Order order = new Order();
        order.setUser(up.findUserById(userid));
        order.setValue(allValue);
        order.setPaied(false);

        DateFormat df5 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss EE", Locale.US);
        order.setTime(df5.format(new Date()));
//        order.setTime(new Date().toString());

        op.saveAndFlush(order);

        return order.getId();
    }
}
