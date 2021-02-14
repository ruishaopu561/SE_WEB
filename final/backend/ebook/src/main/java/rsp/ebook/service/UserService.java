package rsp.ebook.service;

import rsp.ebook.entity.FullUser;
import rsp.ebook.entity.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    User getUser(Long id);

    User getUserByEmail(String email);

    List<FullUser> getValidUsers(boolean active);

    void update(User u);

    void setUsersActive(List<String> list);

    void setUsersDisactive(List<String> list);

    void createUser(Map<String, String> map);
}
