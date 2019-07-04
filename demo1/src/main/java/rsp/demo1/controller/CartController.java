package rsp.demo1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import rsp.demo1.repository.CartRepository;
import rsp.demo1.module.Cart;

import javax.transaction.Transactional;

@Controller
public class CartController {
    @Autowired
    private CartRepository cp;

    @ResponseBody
    @GetMapping(value = "/cart")
    public Iterable<Cart> getCarts(){
        return cp.findAll();
    }

    @ResponseBody
    @PostMapping(value = "/cart")
    public void createCart(Cart c){
        cp.save(c);
    }

    @Modifying
    @ResponseBody
    @PostMapping(value = "/modifyCart")
    public void setAmount(Cart c){
        try{
            Cart dbCart = cp.findByUseremailAndBookname(c.getUseremail(), c.getBookname());
            dbCart.setAmount(c.getAmount());
            dbCart.setPaied(c.isPaied());
            cp.saveAndFlush(dbCart);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Modifying
    @Transactional
    @ResponseBody
    @DeleteMapping(value = "/cart")
    public void deleteCart(String useremail, String bookname){
        try{
            cp.deleteByUseremailAndBookname(useremail, bookname);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
