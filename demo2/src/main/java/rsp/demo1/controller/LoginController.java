package rsp.demo1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import rsp.demo1.login.LoginUser;
import rsp.demo1.module.User;
import rsp.demo1.repository.UserRepository;

import java.util.Objects;

@Controller
public class LoginController {

    @Autowired
    private UserRepository up;

    public String userEmail = "";

    @ResponseBody
    @PostMapping(value = "/register")
    public boolean setNewUser(@RequestBody User user){
        try{
            String inpute = user.getEmail();
            System.out.println(inpute);
            User u= up.findByEmail(inpute);
            if(u == null){
                up.save(user);
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
    public boolean getUser(@RequestBody LoginUser loginUser){
        try{
            String inpute = loginUser.getEmail();
            String inputpw = loginUser.getPassword();
//            System.out.println(inpute);
//            System.out.println(inputpw);
            User u = up.findByEmail(inpute);
            if(u == null){
                return false;
            }
            String dbpw = u.getPassword();
//            System.out.println(inputpw.equals(dbpw));
            if(Objects.equals(dbpw, inputpw)){
                userEmail = inpute;
                return true;
            }else{
                return false;
            }
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

//, produces = "application/json; charset=UTF-8"
//    method = { RequestMethod.GET, RequestMethod.POST }
//    @ResponseBody
//    @PostMapping(value = "/login", produces = "application/json; charset=UTF-8")
//    public Result getUser(@RequestBody LoginUser loginUser, BindingResult bindingResult){
//        try{
//            if(bindingResult.hasErrors()){
//                String message = String.format("登陆失败，详细信息[%s]。", Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage());
//                return ResultFactory.buildFailResult(message);
//            }
//            String inpute = loginUser.getEmail();
//            String inputpw = loginUser.getPassword();
//            System.out.println(inpute);
//            System.out.println(inputpw);
//            User u = up.findByEmail(inpute);
//            if(u == null){
//                String message = "登陆失败，详细信息[用户不存在]。";
//                return ResultFactory.buildFailResult(message);
//            }
//
//            String dbpw = u.getPassword();
//            System.out.println(inputpw.equals(dbpw));
//
//            if (!Objects.equals(dbpw, inputpw)) {
//                String message = "登陆失败，详细信息[密码不正确]。";
//                return ResultFactory.buildFailResult(message);
//            }
//            return ResultFactory.buildSuccessResult("登陆成功。");
//        }catch(Exception e){
//            e.printStackTrace();
//            return ResultFactory.buildFailResult("登陆失败");
//        }
//    }
}
