package rsp.ebook.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rsp.ebook.dao.UserDao;
import rsp.ebook.entity.FullUser;
import rsp.ebook.entity.User;
import rsp.ebook.service.UserService;

import java.util.List;
import java.util.Map;

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
    public List<FullUser> getValidUsers(boolean active){
        return ud.findAllByActive(active);
    }

    @Override
    public void update(User u){
        ud.update(u);
    }


    @Override
    public void createUser(Map<String, String> map){
        User user = new User();

        user.setEmail(map.get("email"));
        user.setFirstname(map.get("firstname"));
        user.setLastname(map.get("lastname"));
        user.setPassword(map.get("password"));
        user.setActive(true);

        ud.update(user);
    }

    @Override
    public void setUsersActive(List<String> list){
        try{
            for(String res_id:list){
                Long id = Long.parseLong(res_id);
                User u = ud.queryUser(id);
                u.setActive(true);
                ud.update(u);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void setUsersDisactive(List<String> list){
        try{
            for(String res_id:list){
                Long id = Long.parseLong(res_id);
                User u = ud.queryUser(id);
                u.setActive(false);
                ud.update(u);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
