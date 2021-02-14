package rsp.ebook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.web.bind.annotation.*;
import rsp.ebook.entity.FullUser;
import rsp.ebook.entity.User;
import rsp.ebook.service.UserService;

import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private UserService us;

    @ResponseBody
    @GetMapping(value = "/auser")
    public List<FullUser> getActiveUsers() {
        return us.getValidUsers(true);
    }

    @ResponseBody
    @GetMapping(value = "/nuser")
    public List<FullUser> getNegativeUsers(){
        return us.getValidUsers(false);
    }

    @ResponseBody
    @PostMapping(value = "/user")
    public void createUser(@RequestBody Map<String, String> map){
        us.createUser(map);
    }

    @ResponseBody
    @PutMapping(value = "/user")
    public void setPassword(@RequestParam String email, @RequestParam String password){
        try{
            User user = us.getUserByEmail(email);
            user.setPassword(password);
            us.update(user);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //启用
    @ResponseBody
    @PostMapping(value = "/user/active")
    public void setUserActive(@RequestBody List<String> list){
        us.setUsersActive(list);
    }

    //禁用
    @ResponseBody
    @PostMapping(value = "/user/disactive")
    public void setUserDisactive(@RequestBody List<String> list){
        us.setUsersDisactive(list);
    }
}
