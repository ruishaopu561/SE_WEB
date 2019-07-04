package rsp.demo1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import rsp.demo1.repository.UserRepository;
import rsp.demo1.module.User;


@Controller
public class UserController {
    @Autowired
    private UserRepository up;

    @ResponseBody
    @GetMapping(value = "/user")
    public Iterable<User> getUsers(){
        return up.findAll();
    }

    @Modifying
    @ResponseBody
    @PostMapping(value = "/user/password")
    public void setPassword(@RequestParam String email, @RequestParam String password){
        try{
            User user = up.findByEmail(email);
            user.setPassword(password);
            up.saveAndFlush(user);
//            User u = up.findByEmail(email);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //禁用
    @ResponseBody
    @PostMapping(value = "/user/active")
    public void setUserActive(@RequestParam String email, @RequestParam int num){
        try{
            User u = up.findByEmail(email);
            if(num==0){
                u.setActive(false);
            }else{
                u.setActive(true);
            }
            up.saveAndFlush(u);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
