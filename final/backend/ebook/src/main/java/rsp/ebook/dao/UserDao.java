package rsp.ebook.dao;

import rsp.ebook.entity.FullUser;
import rsp.ebook.entity.User;

import java.util.List;

public interface UserDao {

    User queryUser(Long id);

    User queryUserByEmail(String email);

    List<FullUser> findAllByActive(boolean active);

    void update(User user);

}
