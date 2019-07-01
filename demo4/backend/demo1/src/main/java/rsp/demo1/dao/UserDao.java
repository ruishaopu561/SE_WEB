package rsp.demo1.dao;

import rsp.demo1.entity.FullUser;
import rsp.demo1.entity.User;

import java.util.List;

public interface UserDao {

    User queryUser(Long id);

    User queryUserByEmail(String email);

    List<FullUser> findAllByActive(boolean active);

    void update(User user);

}
