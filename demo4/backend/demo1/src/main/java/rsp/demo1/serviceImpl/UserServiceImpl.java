package rsp.demo1.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rsp.demo1.dao.UserDao;
import rsp.demo1.entity.FullUser;
import rsp.demo1.entity.User;
import rsp.demo1.service.UserService;

import java.util.List;

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
