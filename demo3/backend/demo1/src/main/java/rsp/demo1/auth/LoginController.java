package rsp.demo1.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import rsp.demo1.entity.User;
import rsp.demo1.repository.UserRepository;

import java.util.Map;
import java.util.Objects;

@RestController
public class LoginController {

    @Autowired
    private UserRepository up;

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
    public User getUser(@RequestBody Map<String, String> map){
        User user = new User();
        user.setId(0L);
        user.setEmail("");
        user.setPassword("");
        user.setFirstname("");
        user.setLastname("");
        try{
            String inpute = map.get("email");
            String inputpw = map.get("password");
//            System.out.println(inpute);
//            System.out.println(inputpw);
            User u = up.findByEmail(inpute);
            if(u == null){
                return user;
//                return false;
            }
            String dbpw = u.getPassword();
//            System.out.println(inputpw.equals(dbpw));
            if(Objects.equals(dbpw, inputpw)){
                return u;
//                return true;
            }else {
                return user;
//                return false;
            }
        }catch(Exception e){
            e.printStackTrace();
            return user;
//            return false;
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
