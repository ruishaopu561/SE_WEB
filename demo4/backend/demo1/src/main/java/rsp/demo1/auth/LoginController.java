package rsp.demo1.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import rsp.demo1.entity.FullUser;
import rsp.demo1.entity.User;
import rsp.demo1.entity.UserImage;
import rsp.demo1.repository.UserRepository;

import java.util.Map;
import java.util.Objects;

@RestController
public class LoginController {

    @Autowired
    private UserRepository up;

    @Autowired
    private MongoTemplate mongoTemplate;

    @ResponseBody
    @PostMapping(value = "/register")
    public boolean setNewUser(@RequestBody Map<String, String> maps){
        String firstname = maps.get("firstname");
        String lastname = maps.get("lastname");
        String email = maps.get("email");
        String password = maps.get("password");
        String image = maps.get("image");

        User user = new User();
        user.setFirstname(firstname);
        user.setLastname(lastname);
        user.setPassword(password);
        user.setEmail(email);
        user.setActive(true);

        try{
            User u= up.findByEmail(email);
            if(u == null){
                up.save(user);
                User newU = up.findByEmail(email);
                UserImage userImage = new UserImage(String.valueOf(newU.getId()), image);
                System.out.println(userImage.getUserId());
                mongoTemplate.insert(userImage);
                return true;
            }else{
                return false;
            }
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @ResponseBody
    @PostMapping(value = "/login", produces = "application/json; charset=UTF-8")
    public FullUser getUser(@RequestBody Map<String, String> map){

        String inpute = map.get("email");
        String inputpw = map.get("password");
        FullUser fullUser = new FullUser(0L,"","","","","");
        User u = up.findByEmail(inpute);
        if(u == null){
            return fullUser;
        }

        try{
            String dbpw = u.getPassword();
            if(Objects.equals(dbpw, inputpw)){
                Query query = Query.query(Criteria.where("userId").is(String.valueOf(u.getId())));
                UserImage userImage = mongoTemplate.findOne(query, UserImage.class);
                if(userImage != null){
                    return new FullUser(u.getId(),u.getFirstname(), u.getLastname(), u.getEmail(),u.getPassword(), userImage.getImage());
                }
            }
            return fullUser;
        }catch(Exception e){
            e.printStackTrace();
            return fullUser;
        }
    }

    @ResponseBody
    @PostMapping(value = "/modifyuser")
    public boolean modifyUser(@RequestBody Map<String, String> maps){
        String email = maps.get("email");
        String firstname = maps.get("firstname");
        String lastname = maps.get("lastname");
        String password = maps.get("password");
        try{
            User user = up.findByEmail(email);
            System.out.println(email);
            if(user!=null){
                user.setFirstname(firstname);
                user.setLastname(lastname);
                user.setPassword(password);
                up.saveAndFlush(user);
                return true;
            }else{
                return false;
            }
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

}
