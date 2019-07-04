package rsp.demo1.dao;

import rsp.demo1.entity.User;

public interface UserDao {

    User queryUser(Long id);

    User queryUserByEmail(String email);

    Iterable<User> findAllByActive(boolean active);

    void update(User user);

}
