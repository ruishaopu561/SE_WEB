package rsp.demo1.service;

import rsp.demo1.entity.User;

public interface UserService {

    User getUser(Long id);

    User getUserByEmail(String email);

    Iterable<User> getValidUsers(boolean active);

    void update(User u);

}
