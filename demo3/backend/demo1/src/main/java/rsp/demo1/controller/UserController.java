package rsp.demo1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.web.bind.annotation.*;
import rsp.demo1.entity.User;
import rsp.demo1.service.UserService;

@RestController
public class UserController {

    @Autowired
    private UserService us;

    @ResponseBody
    @GetMapping(value = "/user")
    public Iterable<User> getUsers(){
        return us.getValidUsers(true);
    }

    @Modifying
    @ResponseBody
    @PostMapping(value = "/user/password")
    public void setPassword(@RequestParam String email, @RequestParam String password){
        try{
            User user = us.getUserByEmail(email);
            user.setPassword(password);
            us.update(user);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //禁用
    @ResponseBody
    @PostMapping(value = "/user/active")
    public void setUserActive(@RequestParam Long id, @RequestParam int num){
        try{
            User u = us.getUser(id);
            if(num==0){
                u.setActive(false);
            }else{
                u.setActive(true);
            }
            us.update(u);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
