package rsp.demo1.service;

import rsp.demo1.entity.FullUser;
import rsp.demo1.entity.User;

import java.util.List;

public interface UserService {

    User getUser(Long id);

    User getUserByEmail(String email);

    List<FullUser> getValidUsers(boolean active);

    void update(User u);

    void setUsersActive(List<String> list);

    void setUsersDisactive(List<String> list);
}
