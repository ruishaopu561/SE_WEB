package rsp.demo1.daoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import rsp.demo1.dao.OrderDao;
import rsp.demo1.entity.Orders;
import rsp.demo1.repository.OrderRepository;
import rsp.demo1.repository.UserRepository;

import java.util.Optional;

@Repository
public class OrderDaoImpl implements OrderDao {

    @Autowired
    private OrderRepository op;

    @Autowired
    private UserRepository up;

    @Override
    public void update(Orders order){op.saveAndFlush(order);}

    @Override
    public Iterable<Orders> queryForUser(Long userId, boolean paied){
        return op.findAllByUser_IdAndPaied(userId, paied);
    }

    @Override
    public void modifyPaied(Long id){
        try{
            Optional<Orders> o = op.findById(id);
            if(o.isPresent()){
                Orders order = o.get();
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
    public Long saveNewOrder(Long userid, double allValue)
    {
        Orders order = new Orders();
        order.setUser(up.findUserById(userid));
        order.setValue(allValue);
        order.setPaied(false);

        op.saveAndFlush(order);

        return order.getId();
    }
}
