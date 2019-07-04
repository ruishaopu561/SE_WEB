package rsp.demo1.daoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import rsp.demo1.dao.UserDao;
import rsp.demo1.entity.User;
import rsp.demo1.repository.UserRepository;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private UserRepository up;

    @Override
    public User queryUser(Long id){
        return up.findUserById(id);
    }

    @Override
    public User queryUserByEmail(String email){
        return up.findByEmail(email);
    }

    @Override
    public Iterable<User> findAllByActive(boolean active){
        return up.findAllByActive(active);
    }

    @Override
    public void update(User user){
        up.saveAndFlush(user);
    }

}
