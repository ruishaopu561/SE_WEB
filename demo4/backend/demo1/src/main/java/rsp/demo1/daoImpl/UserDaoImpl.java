package rsp.demo1.daoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import rsp.demo1.dao.UserDao;
import rsp.demo1.entity.*;
import rsp.demo1.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private UserRepository up;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public User queryUser(Long id){
        return up.findUserById(id);
    }

    @Override
    public User queryUserByEmail(String email){ return up.findByEmail(email); }

    @Override
    public List<FullUser> findAllByActive(boolean active){
        Iterable<User> users = up.findAllByActive(active);
        List<FullUser> fullUsers = new ArrayList<>();
        for(User u:users){
            Query query = Query.query(Criteria.where("userId").is(String.valueOf(u.getId())));
            UserImage ui = mongoTemplate.findOne(query, UserImage.class);
            if(ui != null) {
                FullUser fu = new FullUser(u.getId(), u.getFirstname(),u.getLastname(),u.getEmail(),u.getPassword(), ui.getImage());
                fullUsers.add(fu);
            }
        }
        return fullUsers;
    }

    @Override
    public void update(User user){
        up.saveAndFlush(user);
    }

}
