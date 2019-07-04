package rsp.demo1.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rsp.demo1.dao.UserDao;
import rsp.demo1.entity.User;
import rsp.demo1.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao ud;

    @Override
    public User getUser(Long id){
        return ud.queryUser(id);
    }

    @Override
    public User getUserByEmail(String email){
        return ud.queryUserByEmail(email);
    }

    @Override
    public Iterable<User> getValidUsers(boolean active){
        return ud.findAllByActive(active);
    }

    @Override
    public void update(User u){
        ud.update(u);
    }

}
