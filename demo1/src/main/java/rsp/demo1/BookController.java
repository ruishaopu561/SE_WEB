package rsp.demo1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.lang.System.exit;

@Controller
@ResponseBody
public class BookController {
    //保存查询到的实体集合
    List list = null;
    DBHelper db = new DBHelper();

    @RequestMapping(value = "/books", method = RequestMethod.POST)
    @ResponseBody
    public List getBooks(@RequestBody String data){
        System.out.println("get request.");
        list = db.getBooks();
        return list;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public boolean ifIsRegistered(@RequestBody User user){
        String email = user.getEmail();
        String password = user.getPassword();
        return db.login(email, password);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public boolean ifRegisterOk(@RequestBody User user){
        return db.add(user);
    }

    @GetMapping(value = "/exit")
    public void exitThis(){
        exit(0);
    }
}
